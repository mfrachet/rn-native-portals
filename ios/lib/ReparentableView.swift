import Foundation
import UIKit

protocol PortalView { }

extension PortalView where Self: UIView {
  func moveTo(destination: UIView) {
    destination.subviews.forEach({ $0.removeFromSuperview() })
    subviews.forEach({ destination.addSubview($0) })
  }
}
