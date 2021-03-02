package ru.gulov.indicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;

import com.warkiz.widget.ColorCollector;
import com.warkiz.widget.IndicatorSeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IndicatorSeekBar sectionSeekBar = findViewById(R.id.custom_section_color);


    }
}