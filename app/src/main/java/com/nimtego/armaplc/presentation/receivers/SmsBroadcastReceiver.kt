package com.nimtego.armaplc.presentation.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.nimtego.armaplc.presentation.view_model.StationListViewModel


//todo ref. this

class SmsBroadcastReceiver : BroadcastReceiver() {

    private var context: Context? = null

    override fun onReceive(context: Context, intent: Intent) {
        this.context = context
        if (intent.action != null && intent.action == ACTION) {
            val bundle = intent.extras
            if (bundle != null) {
                try {
                    val pdusObj = bundle.get("pdus") as Array<*>

                    for (i in pdusObj.indices) {

                        val currentMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray)
                        val phoneNumber = currentMessage.displayOriginatingAddress

                        val message = currentMessage.displayMessageBody

                        Log.i("SmsReceiver", "senderNum: $phoneNumber; message: $message")


                        // Show Alert
                        val duration = Toast.LENGTH_LONG
                        val toast = Toast.makeText(
                            context,
                            "senderNum: $phoneNumber, message: $message", duration
                        )
                        toast.show()
                    } // end for loop
                } catch (e: Exception) {
                    Log.e("SmsReceiver", "Exception smsReceiver$e")

                }

            }
            //                StationModel stationModel;
            //                SmsComandModel SmsComandModel = FactoryModel.getSmsComandModel();
            //                SMSDetail smsDetail = SMSSupport.getSMSDetail((Object[]) bundle.get("pdus"), context);
            //                Station station = stationModel.getStationPhone(smsDetail.getSender());
            //                if (station != null) {
            //                    abortBroadcast();
            //                    String message = getMessageKNS((String) smsDetail.getSmsMessages().get(0));
            //                    if (message.length() != 0) {
            //                        StringBuilder builder = new StringBuilder();
            //                        for (int i = 0; i < message.length(); i += 2) {
            //                            builder.append(String.format("%8s", new Object[]{Integer.toBinaryString(UtilsProtocol.hex2Byte(message.substring(i, i + 2))[0])}).replace(' ', '0'));
            //                        }
            //                        String statusIndicator = builder.toString();
            //                        Log.d("CRC16", new StringBuilder(String.valueOf(statusIndicator)).toString());
            //                        station.set_sms_status(statusIndicator);
            //                        station.set_lastResponseTime(System.currentTimeMillis());
            //                        stationModel.save(station);
            //                        SmsCommandItem item = new SmsCommandItem();
            //                        item.setPhone(smsDetail.getSender());
            //                        item.setEncryptedMessage(message);
            //                        item.setTime(System.currentTimeMillis());
            //                        item.setDecryptedMessage(statusIndicator);
            //                        SmsComandModel.save(item);
            //                        Intent intentRedraw = new Intent();
            //                        intentRedraw.setAction(StationView.STATION_REDRAW);
            //                        context.sendBroadcast(intentRedraw);
            //                        List<Crash> crashes = ApplicationModel.getInstance().checkStationForCrash(station, item.getTime());
            //                        if (crashes.size() > 0) {
            //                            for (Crash crash : crashes) {
            //                                FactoryModel.crashesModel().save(crash);
            //                            }
            //                            String stationName = station.getName();
            //                            if (stationName == null || stationName.length() == 0) {
            //                                stationName = station.getPhone();
            //                            }
            //                            sendNotification(String.format("Аварии на станции: %s", new Object[]{stationName}));
            //                        }
            //                    }
            //                }
        }
    }

    private fun sendNotification(notification: String) {
        //        NotificationManager notifManager = (NotificationManager) this.context.getSystemService("notification");
        //        Notification notif = new Notification(2130837638, this.context.getString(2131361808), System.currentTimeMillis());
        //        //notif.setLatestEventInfo(this.context, this.context.getString(R.string.problems_indicators), new StringBuilder(String.valueOf(notification)).append(".").toString(), PendingIntent.getActivity(this.context, 0, new Intent(this.context, KHCList.class), 134217728));
        //        notif.defaults = 7;
        //        notif.flags |= 16;
        //        notifManager.notify(NOTIFICATION_ID, notif);
    }

    private fun getMessageKNS(message: String): String {
        return message.substring(4, message.length - 4)
    }

    private fun isVerifyCRC16(message: String): Boolean {
        return true
    }

    companion object {

        private val ACTION = "android.provider.Telephony.SMS_RECEIVED"
        private val NOTIFICATION_ID = 123457
    }
}
