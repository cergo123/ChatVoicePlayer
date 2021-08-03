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
import android.view.View;
import android.widget.Button;

import java.io.File;

import me.jagar.chatvoiceplayerlibrary.VoicePlayerView;

public class MainActivity extends AppCompatActivity {

    private VoicePlayerView voicePlayerView, voicePlayerView2, voicePlayerView3, voicePlayerView4, voicePlayerView5,
            voicePlayerView6, voicePlayerView7;
    private Button btn_refresh;
    private static final int MY_PERMISSIONS_REQUEST_READ_WRITE_EXTERNAL_STORAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        voicePlayerView = findViewById(R.id.voicePlayerView);
        voicePlayerView2 = findViewById(R.id.voicePlayerView2);
        voicePlayerView3 = findViewById(R.id.voicePlayerView3);
        voicePlayerView4 = findViewById(R.id.voicePlayerView4);
        voicePlayerView5 = findViewById(R.id.voicePlayerView5);
        voicePlayerView6 = findViewById(R.id.voicePlayerView6);
        voicePlayerView7 = findViewById(R.id.voicePlayerView7);
        btn_refresh = findViewById(R.id.btn_refresh);

        checkPermissions();

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED){
            initPlayers();
        }

        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_GRANTED){
                    refershPlayers();
                }
            }
        });


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

    private void refershPlayers(){
        long startTime = System.currentTimeMillis();
        final String path = Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3";
        voicePlayerView.refreshPlayer("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView.refreshPlayer(path);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }
        final String path2 = Environment.getExternalStorageDirectory().getPath() + File.separator + "s1.mp3";
        voicePlayerView2.refreshPlayer("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "s1.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView2.refreshPlayer(path);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }
        final String path3 = Environment.getExternalStorageDirectory().getPath() + File.separator + "s3.mp3";
        voicePlayerView3.refreshPlayer("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "s3.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView3.refreshPlayer(path);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }
        final String path4 = Environment.getExternalStorageDirectory().getPath() + File.separator + "s3.mp3";
        voicePlayerView4.refreshPlayer("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "s3.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView4.refreshPlayer(path3);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }
        final String path5 = Environment.getExternalStorageDirectory().getPath() + File.separator + "s1.mp3";
        voicePlayerView5.refreshPlayer("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "s1.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView5.refreshPlayer(path2);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }

        long endTime = System.currentTimeMillis();
        Log.e("Time", String.valueOf(endTime - startTime));
    }


    private void initPlayers(){
        long startTime = System.currentTimeMillis();
        final String path = Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3";
        voicePlayerView.setAudio("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView.setAudio(path);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }
        final String path2 = Environment.getExternalStorageDirectory().getPath() + File.separator + "s1.mp3";
        voicePlayerView2.setAudio("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "s1.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView2.setAudio(path2);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }
        final String path3 = Environment.getExternalStorageDirectory().getPath() + File.separator + "s3.mp3";
        voicePlayerView3.setAudio("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "s3.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView3.setAudio(path3);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }
        final String path4 = Environment.getExternalStorageDirectory().getPath() + File.separator + "s3.mp3";
        voicePlayerView4.setAudio("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "s3.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView4.setAudio(path4);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }
        final String path5 = Environment.getExternalStorageDirectory().getPath() + File.separator + "s1.mp3";
        voicePlayerView5.setAudio("none");
        if ((new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "s1.mp3")).exists()){
            Log.e("EXIST", "SONG EXISTS");
            voicePlayerView5.setAudio(path5);
        }else{
            Log.e("DOESNT EXIST", Environment.getExternalStorageDirectory().getPath() + File.separator + "song.mp3");
        }

        long endTime = System.currentTimeMillis();
        Log.e("Time", String.valueOf(endTime - startTime));
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
