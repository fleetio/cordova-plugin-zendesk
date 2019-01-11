# cordova-plugin-zendesk
This plugin provides a wrapper for the native iOS and Android Zendesk SDKs for integrating help center and ticket management functionality into your Cordova app.

## Installation
`cordova plugin add cordova-plugin-zendesk`

## Usage

### initialize
Initializes the Zendesk SDK for usage with your application. You will need the appId, clientId, and zendeskUrl obtained when  registering your application through [Zendesk Support](https://support.zendesk.com/hc/en-us/articles/204256073#topic_v4n_vgt_cq). This method must be invoked before any other plugin methods can be used.

```
document.addEventListener('deviceready', function() {
  window.zendesk.initialize(appId, clientId, zendeskUrl);
});
```

### setAnonymousIdentity
Sets the Zendesk SDK to use an anonymous identity. Name and email can optionally passed as identifying information to provide more context when submitting tickets. This method must be invoked after `initialize` and before any other plugin methods.

```
window.zendesk.setAnonymousIdentity("Tyler Durden", "tdurden@paperstreetsoapco.com");
```

### showHelpCenter
```
window.zendesk.showHelpCenter()
```

### showTicketRequest
```
window.zendesk.showTicketRequest()
```

### showUserTickets
```
window.zendesk.showUserTickets()
```
