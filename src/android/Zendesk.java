package com.rarestep.zendesk;

import org.apache.cordova.*;

import org.json.JSONException;

public class Zendesk extends CordovaPlugin {
  private static final String ACTION_INITIALIZE = "initialize";
  private static final String ACTION_SET_ANONYMOUS_IDENTITY = "setAnonymousIdentity";
  private static final String ACTION_SHOW_HELP_CENTER = "showHelpCenter";
  private static final String ACTION_SHOW_TICKET_REQUEST = "showTicketRequest";
  private static final String ACTION_SHOW_USER_TICKETS = "showUserTickets";

  @Override
  public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext)
    throws JSONException {
    if (ACTION_INITIALIZE.equals(action)) {
        
    } else if (ACTION_SET_ANONYMOUS_IDENTITY.equals(action)) {

    } else if (ACTION_SHOW_HELP_CENTER.equals(action)) {

    } else if (ACTION_SHOW_TICKET_REQUEST.equals(action)) {

    } else if (ACTION_SHOW_USER_TICKETS.equals(action)) {

    } else {
      return false;
    }

    return true;
  }
}
