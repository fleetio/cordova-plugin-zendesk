#import <Cordova/CDVPlugin.h>

@interface Zendesk : CDVPlugin

- (void)initialize:(CDVInvokedUrlCommand *)command;
- (void)setAnonymousIdentity:(CDVInvokedUrlCommand *)command;
- (void)showHelpCenter:(CDVInvokedUrlCommand *)command;

@end
