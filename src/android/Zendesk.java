package com.rarestep.zendesk;

import android.content.Context;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import zendesk.core.AnonymousIdentity;
import zendesk.core.Identity;
import zendesk.support.Support;
import zendesk.support.guide.HelpCenterActivity;
import zendesk.support.request.RequestActivity;
import zendesk.support.requestlist.RequestListActivity;

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
      Support.INSTANCE.init(zendesk.core.Zendesk.INSTANCE);
    } else if (ACTION_SET_ANONYMOUS_IDENTITY.equals(action)) {
      String name = args.getString(0);
      String email = args.getString(1);

      Identity identity = new AnonymousIdentity.Builder()
        .withNameIdentifier(name)
        .withEmailIdentifier(email)
        .build();

      zendesk.core.Zendesk.INSTANCE.setIdentity(identity);
    } else if (ACTION_SHOW_HELP_CENTER.equals(action)) {
      String groupType = args.getString(0);
      List<Long> groupIds = jsonArrayToList(args.getJSONArray(1));
      List<String> labels = jsonArrayToList(args.getJSONArray(2);

      zendesk.support.guide.HelpCenterUiConfig.Builder helpCenterActivityBuilder = HelpCenterActivity.builder();

      if ("category".equals(groupType) && !groupIds.isEmpty()) {
        helpCenterActivityBuilder.withArticlesForCategoryIds(groupIds);
      } else if ("section".equals(groupType) && !groupIds.isEmpty()) {
        helpCenterActivityBuilder.withArticlesForSectionIds(groupIds);
      }

      if (labels.size() > 0) {
        helpCenterActivityBuilder.withLabelNames(labels);
      }

      helpCenterActivityBuilder.show(this.cordova.getActivity());
    } else if (ACTION_SHOW_TICKET_REQUEST.equals(action)) {
      RequestActivity.builder().show(this.cordova.getActivity());
    } else if (ACTION_SHOW_USER_TICKETS.equals(action)) {
      RequestListActivity.builder().show(this.cordova.getActivity());
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

  private <T> List<T> jsonArrayToList(JSONArray jsonArray) {
    List<T> arrayList = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
      try {
        arrayList.add((T)jsonArray.get(i));
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }

    return arrayList;
  }
}
