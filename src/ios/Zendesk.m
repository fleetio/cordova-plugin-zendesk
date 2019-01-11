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

  if ([name isKindOfClass:[NSNull class]]) {
    name = nil;
  }
  
  if ([email isKindOfClass:[NSNull class]]) {
    email = nil;
  }
  
  id<ZDKObjCIdentity> userIdentity = [[ZDKObjCAnonymous alloc] initWithName:name email:email];
  [[ZDKZendesk instance] setIdentity:userIdentity];

  [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId]; 
}

- (void)showHelpCenter:(CDVInvokedUrlCommand *)command {
  ZDKHelpCenterUiConfiguration *helpCenterConfig = [ZDKHelpCenterUiConfiguration new];
  
  NSString *groupType = [command.arguments objectAtIndex: 0];
  NSArray *groupIds = [command.arguments objectAtIndex: 1];
  NSArray *labels = [command.arguments objectAtIndex:2];
  
  if (groupType != nil && groupIds != nil) {
    if ([groupType isEqualToString:@"category"]) {
      [helpCenterConfig setGroupType:ZDKHelpCenterOverviewGroupTypeCategory];
    } else if ([groupType isEqualToString:@"section"]) {
      [helpCenterConfig setGroupType:ZDKHelpCenterOverviewGroupTypeSection];
    } else {
      [helpCenterConfig setGroupType:ZDKHelpCenterOverviewGroupTypeDefault];
    }
    
    [helpCenterConfig setGroupIds:groupIds];
  }
  
  if (labels != nil) {
    helpCenterConfig.labels = labels;
  }
  
  UIViewController *helpCenterController = [ZDKHelpCenterUi buildHelpCenterOverviewUiWithConfigs:@[helpCenterConfig]];
  [self presentViewController:helpCenterController];
  
  [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId];
}

- (void)showTicketRequest:(CDVInvokedUrlCommand *)command {
  NSString *subject = [command.arguments objectAtIndex:0];
  NSArray *tags = [command.arguments objectAtIndex:1];
  
  ZDKRequestUiConfiguration *config = [ZDKRequestUiConfiguration new];
  config.subject = subject;
  config.tags = tags;
  UIViewController *ticketRequestController = [ZDKRequestUi buildRequestUiWith:@[config]];
  [self presentViewController:ticketRequestController];
  
  [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId];
}

- (void)showUserTickets:(CDVInvokedUrlCommand *)command {
  UIViewController *requestListController = [ZDKRequestUi buildRequestList];
  [self presentViewController:requestListController];
  
  [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId];
}

- (void)presentViewController:(UIViewController *)viewController {
  UINavigationController *navigationController = [[UINavigationController alloc] init];
  [[[[[UIApplication sharedApplication] delegate] window] rootViewController] presentViewController:navigationController animated:YES completion:^{}];
  [navigationController pushViewController:viewController animated:YES];
}

@end
