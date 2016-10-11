package com.cetpa.quickclicks;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class SocialApp extends AppCompatActivity {
    boolean isavail=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_app);
    }
    public  void mf(View v)
    {
        Uri u= Uri.parse("facebook://com.facebook/inbox");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        PackageManager p= getPackageManager();//to check if app is already installed or not
        List<ResolveInfo> info =p.queryIntentActivities(i,0);
        for (ResolveInfo ii:info)
        {
            if (ii.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana"))
            {
                isavail=true;
                break;
            }

        }
        if(!isavail) {
            Uri u1 = Uri.parse("http://facebook.com");
            i = new Intent(Intent.ACTION_VIEW, u1);
        }

        startActivity(i);
    }
    public  void mw(View v)
    {
       // Intent i=new Intent(Intent.ACTION_SEND);
        //i.setPackage("com.whatsaap");
       // i.setType("text/plain");
       // i.putExtra(Intent.EXTRA_TEXT,"hii");
        //startActivity(i);
        PackageManager pm=getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = "YOUR TEXT HERE";

            PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

    }
}
