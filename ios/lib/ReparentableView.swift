import Foundation
import UIKit

protocol PortalView { }

extension PortalView where Self: UIView {
  func moveTo(destination: UIView) {
    subviews.forEach({ destination.addSubview($0) })
  }
}
