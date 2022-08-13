package com.example.opt_21_july;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

public class OTP extends BroadcastReceiver {
    private static EditText editText_OTP;

    public void setEditText_OTP(EditText editText){
        OTP.editText_OTP=editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        SmsMessage[] smsMessages= Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (SmsMessage smsMessage: smsMessages){
            String message_body= smsMessage.getMessageBody();
            String getOTP=message_body.split(":")[1];

            editText_OTP.setText(getOTP);
        }

    }
}
