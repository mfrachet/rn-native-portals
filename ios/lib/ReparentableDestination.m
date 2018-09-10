#import <Foundation/Foundation.h>
#import <React/RCTViewManager.h>

@interface RCT_EXTERN_MODULE(RCTPortalDestination, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(name, NSString)

+ (BOOL)requiresMainQueueSetup
{
  return YES;
}

@end

