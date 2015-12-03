package com.qyz.qyztest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AlarmManagerTest extends AppCompatActivity {

    private AlarmManager am;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(AlarmManagerTest.this, BroadcastReceiverTest.class);
        long l = System.currentTimeMillis();
        intent.putExtra("test", l + "");
        pendingIntent = PendingIntent.getBroadcast(this, 1000, intent, Intent.FLAG_ACTIVITY_NEW_TASK);
        am.setInexactRepeating(AlarmManager.RTC_WAKEUP,l,2000, pendingIntent);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        am.cancel(pendingIntent);
    }
}
