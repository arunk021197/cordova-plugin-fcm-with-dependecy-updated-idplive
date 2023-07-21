package com.gae.scaffolder.plugin;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import java.util.Map;
import java.util.HashMap;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import com.marketo.Marketo;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Marketo marketoSdk = Marketo.getInstance(this.getApplicationContext());
        marketoSdk.setPushNotificationToken(s);
    }

    
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
       Marketo marketoSdk = Marketo.getInstance(this.getApplicationContext());
        marketoSdk.showPushNotification(remoteMessage);
    }
    // [END receive_message]
}
