var exec = require("cordova/exec");

function Zendesk() {}

Zendesk.prototype.initialize = function(appId, clientId, zendeskUrl, successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'initialize', [appId, clientId, zendeskUrl]);
}

Zendesk.prototype.setAnonymousIdentity = function(name, email, successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'setAnonymousIdentity', [name, email]);
}

Zendesk.prototype.showTicketRequest = function(successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'showTicketRequest', []);
}

Zendesk.prototype.showHelpCenter = function(successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'showHelpCenter', []);
}

var Zendesk = new Zendesk();
module.exports = Zendesk;
