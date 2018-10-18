package com.example.brandon.drawingassign;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Task1 extends AppCompatActivity {

    ArrayAdapter <String> adapter;
    ImageView reusableImageView;

    //
    int startx = 10;
    int starty = 10;
    int endx = 50;
    int endy = 50;
    //
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    //
    private Spinner spinner;
    private static final String[] sizes = {"6px", "10px", "12px", "14px", "16px"};
    //
    int x = 5, y = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(30);

        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);

        canvas.drawColor(Color.LTGRAY); //background
        //
        reusableImageView = (ImageView) findViewById(R.id.signature_canvas);
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);

        //
        //reusableImageView.setImageResource(R.drawable.green_rect);
        ImageButton Up = (ImageButton) findViewById(R.id.UpArrow);
        ImageButton Right = (ImageButton) findViewById(R.id.RightArrow);
        ImageButton Left = (ImageButton) findViewById(R.id.LeftArrow);
        ImageButton Down = (ImageButton) findViewById(R.id.DownArrow);
        Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y =+ 1;
                onPress(x,y);
            }
        });
        Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x =+ 1;
                onPress(x,y);
            }
        });
        Left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x =+ -1;
                onPress(x,y);
            }
        });
        Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int y =+ -1;
                onPress(x,y);
            }
        });

    }// end of onCreate
    public void OnSpinnerClick (View v)
    {
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Task1.this,
                android.R.layout.simple_spinner_dropdown_item,
                sizes);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    // 6 size
                    case 0:
                        paint.setStrokeWidth(6f);
                        break;

                    // 10 size
                    case 1:
                        paint.setStrokeWidth(10f);
                        break;

                    // 12 size
                    case 2:
                        paint.setStrokeWidth(12f);
                        break;

                    // 14 size
                    case 3:
                        paint.setStrokeWidth(14f);
                        break;

                    // 16 size
                    case 4:
                        paint.setStrokeWidth(16f);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void onRadioGroupClicked(View v)
    {
        final RadioButton Red = (RadioButton) findViewById(R.id.red);
        final RadioButton green = (RadioButton) findViewById(R.id.green);
        final RadioButton yellow = (RadioButton) findViewById(R.id.yellow);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (Red.isChecked()) {
                    paint.setColor(Color.RED);
                }
                if (green.isChecked()) {
                    paint.setColor(Color.GREEN);
                }
                if (yellow.isChecked()) {
                    paint.setColor(Color.YELLOW);
                }
            }
        });
    }

    public void clearCanvas(View v) {
        canvas.drawColor(Color.LTGRAY);
        startx = 10;
        starty = 10;
        endx = 50;
        endy = 50;
//        textView.setText(getResources().getString(R.string.help));


    }

    public void startDrawing(View v) {
        canvas.drawPoint(11, 11, paint);


    }

    public void drawLine(Canvas canvas) {

//        textView.setText(String.valueOf(endy));
        //canvas.drawLine(100,100,300,300,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx = endx;
        starty = endy;

    }

    //Activate the DPAD on emulator:
    //change the settings in config.ini file in .android folder
    //hw.dPad=yes
    //hw.mainKeys=yes
    public void onPress(float a, float b) {
        endy += b;
        endx += a;
        drawLine(canvas);

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:

                //reusableImageView.setVisibility(View.VISIBLE);
                //reusableImageView.setFocusable(true);
                //reusableImageView.requestFocus();
                endy = endy - 5;
                drawLine(canvas);
                //moveRect(canvas);
                //reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_DOWN:
                //reusableImageView.setVisibility(View.VISIBLE);
                //reusableImageView.setFocusable(true);
                //reusableImageView.requestFocus();
                endy = endy + 5;
                drawLine(canvas);
                //moveRect(canvas);
                //reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_LEFT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx = endx - 5;
                drawLine(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx = endx + 5;
                drawLine(canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;

        }
        return false;

    }

}


