package com.example.sergei.a02myjsonparser.services;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


/**
 * Created by sergei on 21.01.2017.
 *
 * Собственно сервис для сообщений нотификации.
 *
 */



public class ServiceEVRO2016 extends IntentService {



    public ServiceEVRO2016(){
        super("evro2016service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

            Log.i("Info", "Start proccess");
            Intent intent1 = new Intent(this, TimeNotification.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent1, PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        // Этот временной интервал мне для наглядности результатов
        // Алгоритм подсчета временного интервала пока не пришел в голову
            am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), (5 * 1000), pendingIntent);

        }
}
