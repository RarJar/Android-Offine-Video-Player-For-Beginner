package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ConstraintLayout mainBg;
    private TextView helloText;
    private Button toggle,one,two,showImgBtn,getTextBtn;
    private ImageView imageView;
    private EditText editText;
    boolean condition = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       getSupportActionBar().hide();

        mainBg = findViewById(R.id.mainBg);

       Thread td =new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                   mainBg.setBackgroundColor(getResources().getColor(R.color.teal_700));
//                 mainBg.setBackgroundColor(0xFF00FF00);
               }
           }
       });
       td.start();

        toggle = findViewById(R.id.toggle);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(condition){
                    toggle.setText("Toggle On");
                    Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
                    condition = false;
                }else{
                    toggle.setText("Toggle Off");
                    Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
                    condition = true;
                }
            }
        });

        helloText = findViewById(R.id.helloText);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        showImgBtn = findViewById(R.id.showImgBtn);
        getTextBtn = findViewById(R.id.getTextBtn);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        showImgBtn.setOnClickListener(this);
        getTextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.one:
                Toast.makeText(this, "One Click", Toast.LENGTH_SHORT).show();
            break;

            case R.id.two:
                Toast.makeText(this, "Two Click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.showImgBtn:
                if(condition){
                    imageView.setVisibility(View.INVISIBLE);
                    condition = false;
                }else{
                    imageView.setVisibility(View.VISIBLE);
                    condition = true;
                }
                break;

            case R.id.getTextBtn:
                String text = editText.getText().toString();
                helloText.setText(text);
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void nextPage(View view) {
        String text = editText.getText().toString();

        Intent i= new Intent(MainActivity.this,SecondActivity.class);
        Bundle bd = new Bundle();
        bd.putString("name",text);
        i.putExtras(bd);
        startActivity(i);
    }
}