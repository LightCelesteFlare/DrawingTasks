package com.example.brandon.drawingassign;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Task2 extends AppCompatActivity {
    AnimationDrawable mframeAnimation = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        //
        // Handle Start Button
        final Button onButton = (Button) findViewById(R.id.buttonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.buttonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
        Button Back;
        Back = (Button) findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Task2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void startAnimation()
    {

        ImageView img = (ImageView)findViewById(R.id.imageViewBomb);

        BitmapDrawable frame1 = (BitmapDrawable)
                getResources().getDrawable(R.drawable.bomb1,null);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb2,null);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb3,null);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb4,null);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb5,null);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb6,null);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb7,null);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb8,null);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb9,null);
        BitmapDrawable frame10 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb10,null);
        BitmapDrawable frame11 = (BitmapDrawable)getResources().getDrawable(R.drawable.bomb11,null);
        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);
        mframeAnimation.addFrame(frame5, reasonableDuration);
        mframeAnimation.addFrame(frame6, reasonableDuration);
        mframeAnimation.addFrame(frame7, reasonableDuration);
        mframeAnimation.addFrame(frame8, reasonableDuration);
        mframeAnimation.addFrame(frame9, reasonableDuration);
        mframeAnimation.addFrame(frame10, reasonableDuration);
        mframeAnimation.addFrame(frame11, reasonableDuration);

        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }

}
