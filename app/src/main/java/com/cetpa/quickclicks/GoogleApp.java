package com.cetpa.quickclicks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GoogleApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_app);
    }
    public void gmap(View v)
    {
        Intent i=new Intent();
        i.setAction(Intent.ACTION_VIEW);
        Uri u =Uri.parse("geo:452.258,125.258");
        i.setData(u);
        i=Intent.createChooser(i,"no such app available");
        startActivity(i);

    }
    public void play(View v)
    {
        Uri u= Uri.parse("market://details?id=com.android.vending");
       Intent i=new Intent(Intent.ACTION_VIEW,u);
        i=Intent.createChooser(i,"no such app available");
        startActivity(i);



    }
    public void gmail(View v)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        Uri uri=Uri.parse("mailto:");
        i.setData(uri);
        i.setType("message/rfc822");
        String[] to={("sanjanachaudhary15@gmail.com"),("avinashrajchaudhary@gmail.com")};
        i.putExtra(Intent.EXTRA_EMAIL,to);
        i.putExtra(Intent.EXTRA_SUBJECT,"This is my first mail");
        i.putExtra(Intent.EXTRA_TEXT,"hi");
        Intent.createChooser(i,"complete action using");
        startActivity(i);
    }
}
