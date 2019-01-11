# cordova-plugin-zendesk
This plugin provides a wrapper for the native iOS and Android Zendesk SDKs for integrating help center and ticket management functionality into your Cordova app.

## Installation
`cordova plugin add cordova-plugin-zendesk`

## Usage

### initialize
Initializes the Zendesk SDK for usage with your application. You will need the appId, clientId, and zendeskUrl obtained when registering your application through [Zendesk Support](https://support.zendesk.com/hc/en-us/articles/204256073#topic_v4n_vgt_cq). This method must be invoked before any other plugin methods can be used.

```
document.addEventListener("deviceready", function() {
  window.zendesk.initialize(appId, clientId, zendeskUrl);
});
```

### setAnonymousIdentity
Sets the Zendesk SDK to use an anonymous identity. Name and email can optionally passed as identifying information to provide more context when submitting tickets. This method must be invoked after `initialize` and before any other plugin methods.

* `name` - The name of the user for identification purposes (optional)
* `email` - The email of the user for identification purposes (optional)

```
var name = "Tyler Durden";
var email = "tdurden@paperstreetsoapco.com";

window.zendesk.setAnonymousIdentity(name, email);
```

### showHelpCenter
Presents a new view for browsing help center articles for the application. The articles displayed can be filtered by category, section, and labels.

* `groupType` - Valid values are "category" and "section" (optional)
* `groupIds` - An array of group category or section IDs to filter displayed articles with (optional)
* `labels` - An array of label names to filter displayed articles with (optional)

```
var groupType = "category";
var groupIds = [1234, 5678];
var labels = ["mobile", "ios"];

window.zendesk.showHelpCenter(groupType, groupIds, labels)
```

### showTicketRequest
Presents a new view for submitting a support ticket.

* `subject` - The subject to assign to the new ticket (optional)
* `tags` - An array of tags to assign to the new ticket (optional)

```
window.zendesk.showTicketRequest()
```

### showUserTickets
Presents a new view listing a user's previously submitted tickets.

```
window.zendesk.showUserTickets()
```
