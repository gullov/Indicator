package ru.gulov.indicator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import com.warkiz.widget.ColorCollector;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.OnSeekChangeListener;
import com.warkiz.widget.SeekParams;

public class MainActivity extends AppCompatActivity {

    public boolean planeta = true;
    void checkPosition(){
        int widthS = sectionSeekBar.getWidth() - sectionSeekBar.getPaddingLeft() - sectionSeekBar.getPaddingRight();
        int percentPosition = scrollView.getWidth()-(scrollView.getWidth()*20)/100;
        int percentPosition2 =(scrollView.getWidth()*20)/100;
        int thumbPos = (int)(sectionSeekBar.getPaddingLeft() + widthS * sectionSeekBar.getProgress() / sectionSeekBar.getMax());
        Log.d("plaplsasadjhld", "checkPosition: "+widthS+"  "+percentPosition+"  "+percentPosition2+"  "+thumbPos);
        if(thumbPos-scrollView.getScrollX()>percentPosition){
            planeta = false;
            scrollView.scrollTo(scrollView.getScrollX()+3, 0);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    planeta = true;
                    Log.d("plaplapaplasssssses", (thumbPos-scrollView.getScrollX())+"  "+percentPosition);
                    checkPosition();
                }
            }, 5);

        }
        else if (thumbPos-scrollView.getScrollX()<percentPosition2){
            planeta = false;
            scrollView.scrollTo(scrollView.getScrollX()-3, 0);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    planeta = true;
                    Log.d("plaplapaplasssssses", (thumbPos-scrollView.getScrollX())+"  "+percentPosition);
                    checkPosition();
                }
            }, 5);
        }
        else{
            Log.d("plaplapaplasss", (thumbPos-scrollView.getScrollX())+"  "+percentPosition);
        }

    }

    Button btn1, btn2;
    HorizontalScrollView scrollView;
    IndicatorSeekBar sectionSeekBar;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionSeekBar = findViewById(R.id.custom_section_color);
        sectionSeekBar.setOnSeekChangeListener(new OnSeekChangeListener() {
            @Override
            public void onSeeking(SeekParams seekParams) {
                if(planeta) checkPosition();
            }

            @Override
            public void onStartTrackingTouch(IndicatorSeekBar seekBar) {
                checkPosition();
            }

            @Override
            public void onStopTrackingTouch(IndicatorSeekBar seekBar) {

            }
        });

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        scrollView = findViewById(R.id.scrollable);
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                Log.d("plaplapapla", "   "+ scrollView.getWidth()+"onCreate: "+scrollView.getX()+"  "+scrollX+"    "+oldScrollX);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(scrollView.getScrollX()+100, 0);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(scrollView.getScrollX()-100, 0);
            }
        });

    }
}