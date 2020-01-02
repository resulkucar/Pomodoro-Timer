package com.example.pomodorotimer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean isStart;
    private String userinput;
    private int finalinput;
    Button Start;
    Button mButton;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        Start = (Button)findViewById(R.id.button);
        mButton = (Button)findViewById(R.id.button2);
        mEdit   = (EditText)findViewById(R.id.editText);

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                chronometer = chronometerChanged;
            }
        });
    }

    public void startStopChronometer(View view){

        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String userinput = mEdit.getText().toString();
                finalinput =Integer.valueOf(userinput);
            }
        });

        if(isStart){
            chronometer.stop();
            isStart = false;
            ((Button)view).setText("Start");
        }else{
            chronometer.setCountDown(true);
            int timeInput = finalinput;
            long dayInMilli = 60*timeInput*1000;
            chronometer.setBase(SystemClock.elapsedRealtime()+dayInMilli);
            chronometer.start();
            isStart = true;

            ((Button)view).setText("Stop");
        }
    }

}
