package com.example.brandon.drawingassign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next;
        next = (Button) findViewById(R.id.Task1);
        Button next2;
        next2 = (Button) findViewById(R.id.Task2);
        Button next3;
        next3 = (Button) findViewById(R.id.Task3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Task1.class);
                startActivity(intent);
            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Task2.class);
                startActivity(intent);
            }
        });

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Task3.class);
                startActivity(intent);
            }
        });
    }
}
