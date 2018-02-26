import Foundation

class ReparentableRegistry {
  
  static var _registry: ReparentableRegistry?
  
  static func create() -> ReparentableRegistry {
    if (ReparentableRegistry._registry == nil) {
      ReparentableRegistry._registry = ReparentableRegistry()
    }
    return ReparentableRegistry._registry!
  }
  
  private var destinations = [NSString : ReparentableDestination]()
  private var origins = [NSString : ReparentableOrigin]()
  
  // Target part
  func put(destination: ReparentableDestination) {
    destinations[destination.name] = destination
  }
  
  func get(name: NSString) -> ReparentableDestination? {
    return destinations[name]
  }
  
  // Sources part
  func put(origin: ReparentableOrigin) {
    origins[origin.destination] = origin
  }
  
  func get(destinationName: NSString) -> ReparentableOrigin? {
    return origins[destinationName]
  }
  
  func remove(origin: ReparentableOrigin) {
    origins[origin.destination] = nil
  }
}

