#import <Cordova/CDVPlugin.h>

@interface Zendesk : CDVPlugin

- (void)setAnonymousIdentity:(CDVInvokedUrlCommand *)command;
- (void)showHelpCenter:(CDVInvokedUrlCommand *)command;

@end
