function Zendesk() {}

Zendesk.prototype.initialize = function(appId, clientId, zendeskUrl, successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, appId, clientId, zendeskUrl);
}

Zendesk.prototype.setAnonymousIdentity = function(name, email, successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, name, email);
}

Zendesk.prototype.showHelpCenter = function(successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback);
}

var Zendesk = new Zendesk();
module.exports = Zendesk;
