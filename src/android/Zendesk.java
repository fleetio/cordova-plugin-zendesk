package com.rarestep.zendesk;

import android.content.Context;

import org.apache.cordova.*;

import org.json.JSONException;

import zendesk.core.AnonymousIdentity;
import zendesk.core.Identity;

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
      String appId = args.getString(0);
      String clientId = args.getString(1);
      String zendeskUrl = args.getString(2);

      zendesk.core.Zendesk.INSTANCE.init(this.getContext(), zendeskUrl, appId, clientId);
    } else if (ACTION_SET_ANONYMOUS_IDENTITY.equals(action)) {
      String name = args.getString(0);
      String email = args.getString(1);

      Identity identity = new AnonymousIdentity.Builder()
        .withNameIdentifier(name)
        .withEmailIdentifier(email)
        .build();

      zendesk.core.Zendesk.INSTANCE.setIdentity(identity);
    } else if (ACTION_SHOW_HELP_CENTER.equals(action)) {

    } else if (ACTION_SHOW_TICKET_REQUEST.equals(action)) {

    } else if (ACTION_SHOW_USER_TICKETS.equals(action)) {

    } else {
      callbackContext.error("Invalid action: " + action);
      return false;
    }

    callbackContext.success();
    return true;
  }

  private Context getContext() {
    return this.cordova.getActivity().getApplicationContext();
  }
}
