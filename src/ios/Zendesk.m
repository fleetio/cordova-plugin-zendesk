#import "Zendesk.h"

@import ZendeskSDK;
@import ZendeskCoreSDK;

@implementation Zendesk

- (void)initialize:(CDVInvokedUrlCommand *)command {
  NSString *appId = [command.arguments objectAtIndex:0];
  NSString *clientId = [command.arguments objectAtIndex:1];
  NSString *zendeskUrl = [command.arguments objectAtIndex:2];
  
  [ZDKZendesk initializeWithAppId:appId clientId:clientId zendeskUrl:zendeskUrl];
  [ZDKSupport initializeWithZendesk: [ZDKZendesk instance]];
  
  [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId];
}

- (void)setAnonymousIdentity:(CDVInvokedUrlCommand *)command { 
  NSString *name = [command.arguments objectAtIndex:0];
  NSString *email = [command.arguments objectAtIndex: 1];

  id<ZDKObjCIdentity> userIdentity = [[ZDKObjCAnonymous alloc] initWithName:name email:email];
  [[ZDKZendesk instance] setIdentity:userIdentity];

  [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId]; 
}

- (void)showHelpCenter:(CDVInvokedUrlCommand *)command {
  
  UIViewController *helpCenter = [ZDKHelpCenterUi buildHelpCenterOverviewUiWithConfigs:@[]];
  [self.viewController.navigationController pushViewController:helpCenter animated:YES];

  [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId];
}

@end
