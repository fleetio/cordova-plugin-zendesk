var exec = require("cordova/exec");

function Zendesk() {}

/**
 * Initializes the Zendesk SDK with the application settings
 *
 * @param appId The Zendesk Support application ID 
 * @param clientId The Zendesk Support client ID
 * @param zendeskUrl The url of the Zendesk Support instance
 * @param successCallback The callback to be executed upon command success
 * @param errorCallback The callback to be executed upon command failure
 */
Zendesk.prototype.initialize = function(appId, clientId, zendeskUrl, successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'initialize', [appId, clientId, zendeskUrl]);
}

/**
 * Sets an anonymous user identity for tracking the user
 *
 * @param name The name of the user (optional)
 * @param email The email of the user (optional)
 * @param successCallback The callback to be executed upon command success
 * @param errorCallback The callback to be executed upon command failure
 */
Zendesk.prototype.setAnonymousIdentity = function(name, email, successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'setAnonymousIdentity', [name, email]);
}

/**
 * Opens a native view for viewing the help center
 *
 * @param groupType Either "category" or "section" to filter articles by group type (optional)
 * @param groupIds Array of category or section group identifiers to filter help center articles (optional)
 * @param labels Array of labels to filter help center by (optional)
 * @param successCallback The callback to be executed upon command success
 * @param errorCallback The callback to be executed upon command failure
 */
Zendesk.prototype.showHelpCenter = function(groupType, groupIds, labels, successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'showHelpCenter', [groupType, groupIds, labels]);
}

/**
 * Opens a native view for viewing a single help center article
 *
 * @param articleId The ID of the article to display
 * @param successCallback The callback to be executed upon command success
 * @param errorCallback The callback to be executed upon command failure
 */
Zendesk.prototype.showHelpCenterArticle = function(articleId, successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'showHelpCenterArticle', [articleId]);
}

/**
 * Opens a native view allowing the user to submit a ticket
 * 
 * @param subject The subject to assign to the new ticket
 * @param tags An array of tags to assign to the new ticket
 * @param fields An array of pipe-delimited ID/value pairs for custom fields to assign to the new ticket (ex: "123456|abcdef")
 * @param successCallback The callback to be executed upon command success
 * @param errorCallback The callback to be executed upon command failure
 */
Zendesk.prototype.showTicketRequest = function(subject, tags, fields, successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'showTicketRequest', [subject, tags, fields]);
}

/**
 * Opens a native view listing the user's previously submitted tickets
 *
 * @param successCallback The callback to be executed upon command success
 * @param errorCallback The callback to be executed upon command failure
 */
Zendesk.prototype.showUserTickets = function(successCallback, errorCallback) {
  exec(successCallback, errorCallback, 'Zendesk', 'showUserTickets', []);
}

var Zendesk = new Zendesk();
module.exports = Zendesk;
