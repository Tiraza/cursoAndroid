package extractor.com.helloworld.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import extractor.com.helloworld.Exercicios;
import extractor.com.helloworld.R;

public class NotificationsActivity extends ActionBarActivity {
    private NotificationManager mNotificationManager;
    private int notificationID = 100;
    private int numMessage = 0;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, Exercicios.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        setTitle("Notifications");
    }

    public void onClickBtnStart(View v){
        displayNotification();
    }

    public void onClickBtnCancel(View v){
        try {
            cancelNotification();
        } catch (Exception e){}
    }
    public void onClickBtnUpdate(View v){
        updateNotification();
    }

    public void onClickBtnStartBig(View v){
        displayBigNotification();
    }

    protected void displayNotification(){
        Log.i("START: ", "Display Notification");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("New Message");
        mBuilder.setContentText("You've received new message.");
        mBuilder.setTicker("New Message Alert!");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setNumber(++numMessage);
        mBuilder.setAutoCancel(true);

        Intent resultIntent = new Intent(this, ViewNotificationActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ViewNotificationActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationID, mBuilder.build());
    }

    protected void cancelNotification(){
        Log.i("CANCEL: ", "Cancel Notification");
        mNotificationManager.cancel(notificationID);
        numMessage = 0;
    }

    protected void updateNotification(){
        Log.i("UPDATE: ", "Update Notification");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("Update Message");
        mBuilder.setContentText("You've updated new message.");
        mBuilder.setTicker("Update Message Alert!");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setNumber(++numMessage);
        mBuilder.setAutoCancel(true);

        Intent resultIntent = new Intent(this, ViewNotificationActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ViewNotificationActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationID, mBuilder.build());
    }

    protected void displayBigNotification(){
        Log.i("START: ", "Display Notification");

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("New Message");
        mBuilder.setContentText("You've received new message.");
        mBuilder.setTicker("New Message Alert!");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setNumber(++numMessage);
        mBuilder.setAutoCancel(true);

        String[] events = new String[6];
        events[0] = new String("Primeira Linha");
        events[1] = new String("Segunda Linha");
        events[2] = new String("Terceira Linha");
        events[3] = new String("Quarta Linha");
        events[4] = new String("Quinta Linha");
        events[5] = new String("Sexta Linha");

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Big Title Details");

        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        mBuilder.setStyle(inboxStyle);

        Intent resultIntent = new Intent(this, ViewNotificationActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ViewNotificationActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(notificationID, mBuilder.build());
    }

}
