package com.suyogshrestha.dhyandeu;

import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.WifiManager;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;


public class Timer extends AppCompatActivity{

    private final static long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private EditText mTimerInput;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private long Counter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //Button Activity
        Button Circular_button = (Button) findViewById(R.id.Circular_button);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final String[] messages = {"Focus on your job"," Please Concentrate", " Stop DayDreaming"};

        //TimerActivity
        final Button button1 = findViewById(R.id.button_start_pause);
        Button button2 = findViewById(R.id.button_reset);


        Circular_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random = (int) (Math.random() * messages.length);
                textView.setText(messages[random]);
                Counter ++;
                Toast.makeText(getApplicationContext(),"Distraction times: " + Counter ,Toast.LENGTH_LONG).show();


            }

        });


        Circular_button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
                return false;
            }
        });

        mTimerInput = findViewById(R.id.timer_input);
        //Timer Clock!
       /* Button button3 = findViewById(R.id.timer_add_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(Timer.this);
                View view = inflater.inflate(R.layout.timer_input,null);

                AlertDialog.Builder builder = new AlertDialog.Builder(Timer.this);
                builder.setTitle("Please enter the time");
                builder.setView(R.layout.timer_input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Timer.this, "All set to go", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel",null);
                builder.show();
            }
        });
*/
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);


        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
                Toast.makeText(getApplicationContext(),"Distraction Counter Reset!",Toast.LENGTH_LONG).show();
            }
        });

        updateCountDownText();
    }


    private void startTimer() {
        ResetCounter();
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }

    private void ResetCounter(){

        Counter = 0;
    }

/*        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    mTextViewCountDown.setText(mtextInput.getText());
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    break;
        }*/


}
