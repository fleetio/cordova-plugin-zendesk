#import <Cordova/CDVPlugin.h>

@interface Zendrive : CDVPlugin

- (void)setAnonymousIdentity:(CDVInvokedUrlCommand *)command;
- (void)showHelpCenter:(CDVInvokedUrlCommand *)command;

@end
