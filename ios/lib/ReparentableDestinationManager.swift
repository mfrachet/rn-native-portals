import Foundation

@objc(RCTPortalDestination)
class PortalDestinationManager: RCTViewManager {
  
  override func view() -> UIView! {
    return PortalDestination(registry: PortalRegistry.create())
  }
  
  override static func moduleName() -> String! {
    return "RCTPortalDestination"
  }
}
