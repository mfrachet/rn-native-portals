import Foundation
import UIKit

@objc(RCTReparentableOrigin)
class ReparentableOriginManager: RCTViewManager {
  
  override func view() -> UIView! {
    return ReparentableOrigin(registry:  ReparentableRegistry.create())
  }
  
  override static func moduleName() -> String! {
    return "RCTReparentableOrigin"
  }
}
