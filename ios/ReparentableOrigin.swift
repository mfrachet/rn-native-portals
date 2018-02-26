import Foundation
import UIKit

class ReparentableOrigin: UIView, ReparentableView {
  
  var registry: ReparentableRegistry
  var lastDestination: ReparentableDestination?
  
  @objc var destination: NSString {
    willSet(newDestination) {
      restituteIfNeeded(destinationName: newDestination)
      registry.remove(origin: self)
    }
    didSet {
      registry.put(origin: self)
      move()
    }
  }
  
  func restituteIfNeeded(destinationName: NSString) {
    if (destinationName == "" && lastDestination?.lastOrigin == self) {
      lastDestination?.restitute()
    }
  }
  
  func move() {
    guard let realDestination = registry.get(name: destination) else { return }
    
    realDestination.restitute()
    moveTo(destination: realDestination)
    
    realDestination.prepareNextRestitute(origin: self)
  }
  
  init(registry: ReparentableRegistry) {
    self.registry = registry
    destination = ""
    super.init(frame: CGRect.zero)
  }
  
  required init?(coder aDecoder: NSCoder) {
    fatalError("init(coder:) has not been implemented")
  }
}
