import Foundation

class PortalRegistry {
  
  static var _registry: PortalRegistry?
  
  static func create() -> PortalRegistry {
    if (PortalRegistry._registry == nil) {
      PortalRegistry._registry = PortalRegistry()
    }
    return PortalRegistry._registry!
  }
  
  private var destinations = [NSString : PortalDestination]()
  private var origins = [NSString : PortalOrigin]()
  
  // Target part
  func put(destination: PortalDestination) {
    destinations[destination.name] = destination
  }
  
  func get(name: NSString) -> PortalDestination? {
    return destinations[name]
  }
  
  // Sources part
  func put(origin: PortalOrigin) {
    origins[origin.destination] = origin
  }
  
  func get(destinationName: NSString) -> PortalOrigin? {
    return origins[destinationName]
  }
  
  func remove(origin: PortalOrigin) {
    origins[origin.destination] = nil
  }
}

