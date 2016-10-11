package com.cetpa.quickclicks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mgoogle(View v) {
        Intent i = new Intent(this, GoogleApp.class);
        startActivity(i);
    }

    public void msocialapps(View v) {
        Intent i = new Intent(this, SocialApp.class);
        startActivity(i);

    }

    public void mtelephoneapps(View v) {
        Intent i = new Intent(this, CallApp.class);
        startActivity(i);

    }

    public void sb(View v) {
        Uri u = Uri.parse("http://www.google.co.in");
        Intent i = new Intent(Intent.ACTION_VIEW, u);
        // i.addCategory(Intent.CATEGORY_DEFAULT);  added automatically
        startActivity(i);

    }
}
