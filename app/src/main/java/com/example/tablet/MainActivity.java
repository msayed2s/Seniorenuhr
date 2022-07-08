package com.example.tablet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//import com.tomerrosenfeld.*

public class MainActivity extends AppCompatActivity {


    boolean farbe;
    private MyModel myModel;
    private MyView myView;

    final private int light_background = 0xFF2B2B2B;
    final private int light_text = 0xFFFFFFFF;
    final private int light_icon = R.drawable.sunny;

    final private int dark_background = 0xFFFFFFFF;
    final private int dark_text = 0xFF000000;
    final private int dark_icon = R.drawable.nighty;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        farbe = true;
        myModel = new MyModel(this);
        myView = new MyView(this, myModel);

        myView.init();

    }



    public void switcher(View v) {
        if(farbe) {
            myView.changeTheme(light_background, light_text, light_icon);
        } else {
            myView.changeTheme(dark_background, dark_text, dark_icon);
        }
        farbe = !farbe;
    }


}