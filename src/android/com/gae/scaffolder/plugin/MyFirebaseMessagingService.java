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
import java.io.FileWriter;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Marketo marketoSdk = Marketo.getInstance(this.getApplicationContext());
        marketoSdk.setPushNotificationToken(s);
        File appDirectory;
        FileWriter fileWriterObj;
        String data = "Text data will be saved here...";
        /* CHECKING THE DIRECTORY EXISTS OR NOT AND CREATING THE DIRECTORY */
        appDirectory = new File(new File(cordova.getActivity().getExternalFilesDir(""), "") + "/" + "onNewToken.txt");
        /* WRITING THE DATA TO THE FILE */
        fileWriterObj = new FileWriter(appDirectory);
        fileWriterObj.write(data);
        fileWriterObj.flush();
        fileWriterObj.close();
    }

    
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
       Marketo marketoSdk = Marketo.getInstance(this.getApplicationContext());
        marketoSdk.showPushNotification(remoteMessage);
        File appDirectory;
        FileWriter fileWriterObj;
        String data = "Text message  data will be saved here...";
        /* CHECKING THE DIRECTORY EXISTS OR NOT AND CREATING THE DIRECTORY */
        appDirectory = new File(new File(cordova.getActivity().getExternalFilesDir(""), "") + "/" + "onMessageReceived.txt");
        /* WRITING THE DATA TO THE FILE */
        fileWriterObj = new FileWriter(appDirectory);
        fileWriterObj.write(data);
        fileWriterObj.flush();
        fileWriterObj.close();
    }
    // [END receive_message]
}
