package com.cetpa.quickclicks;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MyService extends Service {
    public MyService() {
    }
MediaRecorder mr;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES);
        String path=folder.getAbsolutePath()+"/recording.mp3";

        mr.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
        mr.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mr.setOutputFile(path);

        try
        {
            mr.prepare();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }  mr=new MediaRecorder();




        Toast.makeText(this, "service is created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        File folder= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES);
        String path=folder.getAbsolutePath()+"/recording.mp3";

        mr.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
        mr.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mr.setOutputFile(path);

        try
        {
            mr.prepare();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }  mr=new MediaRecorder();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                mr.start();
            }
        };
        Thread t=new Thread(r);
        t.start();
        Toast.makeText(this, "recording started", Toast.LENGTH_SHORT).show();
        //return START_NOT_STICKY;//os will not call it again
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mr.stop();
        mr.release();
        Toast.makeText(this, "recording is done", Toast.LENGTH_SHORT).show();
    }
}
