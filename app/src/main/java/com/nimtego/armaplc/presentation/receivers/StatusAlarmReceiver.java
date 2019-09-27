package com.nimtego.armaplc.presentation.receivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

//todo ref. this

public class StatusAlarmReceiver extends BroadcastReceiver {
    private static final int NOTIFICATION_ID = 53652;
    public static final String SEND_ALARM = "com.send.alarm";
    private static final String updateText = "010281E1";
    private Context context;
    private final long minute = 60000;

    public void onReceive(Context context, Intent arg1) {
        this.context = context;
        updateStatus();
    }

    private void updateStatus() {
//        for (Station item : FactoryModel.stationsModel().getItemsAll()) {
//            if (item.getDoRequest() != 0) {
//                long period = ((long) item.get_requestInterval()) * 60000;
//                if (System.currentTimeMillis() - item.get_lastRequestTime() > period) {
//                    item.set_lastRequestTime(System.currentTimeMillis());
//                    SMSSupport.sendSMS(item.getPhone(), updateText);
//                }
//                if (item.get_lastResponseTime() == 0) {
//                    return;
//                }
//                if (System.currentTimeMillis() - item.get_lastResponseTime() > 2 * period) {
//                    item.clearState();
//                    Intent intentRedraw = new Intent();
//                    intentRedraw.setAction(StationView.STATION_REDRAW);
//                    this.context.sendBroadcast(intentRedraw);
//                    NotificationManager notifManager = (NotificationManager) this.context.getSystemService("notification");
//                    Notification notif = new Notification(2130837638, this.context.getString(2131361808), System.currentTimeMillis());
//                    PendingIntent pendingIntent = PendingIntent.getActivity(this.context, 0, new Intent(this.context, KHCList.class), 134217728);
//                    notif.setLatestEventInfo(this.context, this.context.getString(R.string.problems_indicators), this.context.getString(R.string.problems_not_response), pendingIntent);
//                    notif.defaults = 7;
//                    notif.flags |= 16;
//                    notifManager.notify(NOTIFICATION_ID, notif);
//                }
//            }
//        }
    }
}
