package com.example.mobilesanitizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.CalendarView;

public class Hospital extends AppCompatActivity {
    MediaPlayer player;
    private CalendarView mCalanderView;
    private static final String TAG ="CalendarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        mCalanderView = (CalendarView) findViewById(R.id.calendarView);
        mCalanderView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date =  year + "/" + month + "/" + dayOfMonth;
                Log.d(TAG, "onSelectedDayChange: date:"+date);
            }
        });
    }
    public void opening(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=6p_yaNFSYao"));
        startActivity(browserIntent);
    }
    public void play(View v){
        if(player==null){
            player= MediaPlayer.create(this,R.raw.medicmusic);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }
    public void stop(View v){
        stopPlayer();
    }
    public void pause(View v){
        if(player!=null){
            player.pause();
        }
    }
    private void stopPlayer(){
        if(player!=null){
            player.release();
            player = null;
            Toast.makeText(this,"Media Player Released",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
