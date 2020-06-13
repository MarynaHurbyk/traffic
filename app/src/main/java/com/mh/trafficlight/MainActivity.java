package com.mh.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout red ;
    private LinearLayout yeelow;
    private LinearLayout green ;
    private Button button;
    private boolean start_stop = false;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = findViewById(R.id.bulb_red);
        yeelow = findViewById(R.id.bulb_yellow);
        green = findViewById(R.id.bulb_green);
        button= findViewById(R.id.button);
    }

    public void onClickStart(View view) {
        if (!start_stop) {
            button.setText("Stop");
            start_stop =true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (start_stop) {
                        counter++;
                        switch (counter){
                            case 1:
                                red.setBackgroundColor(Color.GRAY);
                                yeelow.setBackgroundColor(Color.GRAY);
                                green.setBackgroundColor(Color.GREEN);
                                break;
                            case 2:
                                red.setBackgroundColor(Color.GRAY);
                                yeelow.setBackgroundColor(Color.YELLOW);
                                green.setBackgroundColor(Color.GRAY);
                                break;
                            case 3:
                                red.setBackgroundColor(Color.RED);
                                yeelow.setBackgroundColor(Color.GRAY);
                                green.setBackgroundColor(Color.GRAY);
                                break;
                            case 4:
                                red.setBackgroundColor(Color.GRAY);
                                yeelow.setBackgroundColor(Color.YELLOW);
                                green.setBackgroundColor(Color.GRAY);
                                counter =0;
                                break;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } else{
                button.setText("Start");
                start_stop =false;
            counter =0;
            }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }
}
