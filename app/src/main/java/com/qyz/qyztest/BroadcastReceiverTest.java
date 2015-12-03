package com.qyz.qyztest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BroadcastReceiverTest extends BroadcastReceiver {
    public BroadcastReceiverTest() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("test", System.currentTimeMillis() + "");
    }
}
