package me.jagar.chatvoiceplayer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

import me.jagar.chatvoiceplayerlibrary.VoicePlayerView;

public class MainActivity extends AppCompatActivity {

    private VoicePlayerView voicePlayerView;
    private static final int MY_PERMISSIONS_REQUEST_READ_WRITE_EXTERNAL_STORAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voicePlayerView = findViewById(R.id.voicePlayerView);
        checkPermissions();

        long startTime = System.currentTimeMillis();
        final String path = Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3";
        voicePlayerView.setAudio("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView.setAudio(path);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }

        long endTime = System.currentTimeMillis();
        Log.e("Time", String.valueOf(endTime - startTime));
        /*voicePlayerView.showPlayProgressbar();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                voicePlayerView.hidePlayProgresbar();
                voicePlayerView.refreshPlayer(path);
            }
        }, 5000);*/
    }

    private void checkPermissions() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_WRITE_EXTERNAL_STORAGE);

                // MY_PERMISSIONS_REQUEST_READ_WRITE_EXTERNAL_STORAGE is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_WRITE_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        voicePlayerView.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        voicePlayerView.onPause();
    }
}
