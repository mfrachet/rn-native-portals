import Foundation

@objc(RCTReparentableDestination)
class ReparentableDestinationManager: RCTViewManager {
  
  override func view() -> UIView! {
    return ReparentableDestination(registry: ReparentableRegistry.create())
  }
  
  override static func moduleName() -> String! {
    return "RCTReparentableDestination"
  }
}
