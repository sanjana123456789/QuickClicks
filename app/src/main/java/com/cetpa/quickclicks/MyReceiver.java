package com.cetpa.quickclicks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        if(bundle!=null)
        {
            String state=bundle.getString(TelephonyManager.EXTRA_STATE);
            Toast.makeText(context, "phone state-->"+state, Toast.LENGTH_SHORT).show();

            if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
            {
                Intent i=new Intent(context,MyService.class);
                context.startService(i);
                Toast.makeText(context, "phone state-->"+state, Toast.LENGTH_SHORT).show();
            }
            if(state.equals(TelephonyManager.EXTRA_STATE_IDLE));
            {
                Intent i=new Intent(context,MyService.class);
                 context.stopService(i);
                Toast.makeText(context, "phone state-->"+state, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
