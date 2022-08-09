package com.example.tablet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

//import com.example.tablet.databinding.ActivityFullscreenBinding;
import com.tomerrosenfeld.customanalogclockview.CustomAnalogClock;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class AnalogActivity extends AppCompatActivity {
//    TextView mText;
//    TextView mTag;
//    TextClock mTime;
//    static boolean farbe;
//    View myView;
//    Model m = new Model();
//    MyModel myModel = new MyModel();

    private MyModel myModel;
    private MyView myView;
//
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        lightTheme();
//        setTheme(R.style.WestSide);
        setContentView(R.layout.activity_fullscreen);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

//        farbe = MainActivity.farbe;

        myModel = new MyModel(this);
        myView = new MyView(this);



        init();
        myView.init();

        okletsgo1();
//        myView.switcher();


    }

    public void init() {


        myModel.addView("alles", findViewById(R.id.analog_alles));

        myModel.addImageView("theme", findViewById(R.id.analog_themee));
        myModel.addImageView("analog", findViewById(R.id.analogg));

        myModel.addTextView("time", findViewById(R.id.analog_time_digital));
        myModel.addTextView("abschnitt", findViewById(R.id.analog_abschnit));
        myModel.addTextView("day", findViewById(R.id.analog_day));
        myModel.addTextView("date", findViewById(R.id.analog_date));
        myModel.addTextView("termine", findViewById(R.id.analog_termine));
        myModel.addTextView("termine2", findViewById(R.id.analog_termine2));
        myModel.addTextView("termine3", findViewById(R.id.analog_termine3));

        myView.setDarkIcon(R.drawable.icondigial);
        myView.setLightIcon(R.drawable.icondigital_light);

        myView.subscribe(myModel);
        myModel.subscribe(myView);
    }

    public void digitalSwitch(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void okletsgo1() {

        Date current = Calendar.getInstance().getTime();
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(current);


        CustomAnalogClock analog = (CustomAnalogClock) findViewById(R.id.analog_clock);
                                //face              //hour          //minute
        analog.init(this, R.drawable.aaa, R.drawable.side, R.drawable.west, 250, false, false);
        analog.setAutoUpdate(true);
        analog.setScale(.8f);
        View v = findViewById(R.id.analog_alles);
        v.setBackgroundColor(Color.WHITE);
    }
}