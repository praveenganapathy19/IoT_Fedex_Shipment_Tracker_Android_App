package com.example.praveen.fedextracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static Button btnTrackMain,btnSendMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TrackOnclickListener();
        SendOnclickListener();

    }

    //Method executing on clicking Track button in the entry screen
    public void TrackOnclickListener()
    {
        btnTrackMain=(Button)findViewById(R.id.btnTrackMain);
        btnTrackMain.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentTrack = new Intent("com.example.praveen.fedextracking.Tracking");
                        startActivity(intentTrack);
                    }
                }
        );


    }

    //Method executing on clicking Send button in the entry screen
    public void SendOnclickListener()
    {
        btnSendMain=(Button)findViewById(R.id.btnSendMain);
        btnSendMain.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentSend = new Intent("com.example.praveen.fedextracking.Sending");
                        startActivity(intentSend);
                    }
                }
        );


    }
}
