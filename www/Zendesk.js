function Zendesk() {}

Zendesk.prototype.setAnonymousIdentity = function(name, email, successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, name, email);
}

Zendesk.prototype.showHelpCenter = function(successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback);
}

var Zendesk = new Zendesk();
module.exports = Zendesk;
