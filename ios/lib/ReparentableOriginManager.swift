import Foundation
import UIKit

@objc(RCTPortalOrigin)
class PortalOriginManager: RCTViewManager {
  
  override func view() -> UIView! {
    return PortalOrigin(registry:  PortalRegistry.create())
  }
  
  override static func moduleName() -> String! {
    return "RCTPortalOrigin"
  }
}
