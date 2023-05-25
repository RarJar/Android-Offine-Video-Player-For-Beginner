package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class SecondActivity extends AppCompatActivity {
    private TextView getText,marqueeText,number;
    private int count = 0;
    private VideoView video;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setTitle("Second Page");

//      Get Data From First
        getText = findViewById(R.id.getText);
        String getData = getIntent().getExtras().getString("name");
        getText.setText(getData);

//      Marquee Text
        marqueeText = findViewById(R.id.marqueeText);
        marqueeText.setSelected(true);

//      Counter
        number = findViewById(R.id.number);

//      Video Player
        video = findViewById(R.id.video);
        String filepath = "android.resource://com.example.myfirstapp/" + R.raw.video;
        Uri uri = Uri.parse(filepath);
        video.setVideoURI(uri);
        //Auto play
        video.start();
    }

//    Counter
    public void minus(View view) {
        if (count > 0){
            count--;
            number.setText(String.valueOf(count));
        }
    }
    public void plus(View view) {
        count++;
        number.setText(String.valueOf(count));
    }

//    Video Player
    public void play(View view) {
        video.start();
    }

    public void pause(View view) {
        video.pause();
    }
}