#import <Cordova/CDVPlugin.h>

@interface Zendesk : CDVPlugin

- (void)initialize:(CDVInvokedUrlCommand *)command;
- (void)setAnonymousIdentity:(CDVInvokedUrlCommand *)command;
- (void)showTicketRequest:(CDVInvokedUrlCommand *)command;
- (void)showUserTickets:(CDVInvokedUrlCommand *)command;
- (void)showHelpCenter:(CDVInvokedUrlCommand *)command;
- (void)showHelpCenterArticle:(CDVInvokedUrlCommand *)command;

@end
