var exec = require("cordova/exec");

function Zendesk() {}

Zendesk.prototype.initialize = function(appId, clientId, zendeskUrl, successCallback, errorCallback) {
  exec(successCallback, errorCallback, appId, clientId, zendeskUrl);
}

Zendesk.prototype.setAnonymousIdentity = function(name, email, successCallback, errorCallback) {
  exec(successCallback, errorCallback, name, email);
}

Zendesk.prototype.showHelpCenter = function(successCallback, errorCallback) {
  exec(successCallback, errorCallback);
}

var Zendesk = new Zendesk();
module.exports = Zendesk;
