package com.simplestopwatch.jose.stopwatch;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.jose.stopwatch.R;
import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;

public class StopwatchActivity extends AppCompatActivity {
    TextView time;
    Stopwatch stopwatch = Stopwatch.createUnstarted();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        time = (TextView) findViewById(R.id.time_view);

        Typeface timeFont = Typeface.createFromAsset(getAssets(),"fonts/FuturaLight.ttf");
        TextView timeView = (TextView) findViewById(R.id.time_view);
        timeView.setTypeface(timeFont);

        Typeface startFont = Typeface.createFromAsset(getAssets(),"fonts/FuturaLight.ttf");
        TextView startView = (TextView) findViewById(R.id.start_button);
        startView.setTypeface(startFont);

        Typeface stopFont = Typeface.createFromAsset(getAssets(),"fonts/FuturaLight.ttf");
        TextView stopView = (TextView) findViewById(R.id.stop_button);
        stopView.setTypeface(stopFont);

        Typeface resetFont = Typeface.createFromAsset(getAssets(),"fonts/FuturaLight.ttf");
        TextView resetView = (TextView) findViewById(R.id.reset_button);
        resetView.setTypeface(resetFont);
        runTimer();
    }
    public void onClickStart (View view) throws IllegalStateException {
        stopwatch.start();
    }
    public void onClickStop(View view) throws IllegalStateException {
            stopwatch.stop();
        }
    public void onClickReset(View view){
      stopwatch.reset();
    }
    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int millis = (int)stopwatch.elapsed(TimeUnit.MILLISECONDS);
                int minutes = (int) (millis / (1000 * 60));
                int secs = (int) ((millis / 1000) % 60);
                int seconds10 = (int) ((millis / 100) % 10);
                String time = String.format("%d:%02d:%d",
                        minutes, secs, seconds10);
                timeView.setText(time);
                handler.postDelayed(this, 0);
            }
        });
        }
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
}

