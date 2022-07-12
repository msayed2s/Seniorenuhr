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
//        setContentView(R.layout.activity_fullscreen);
    }
//
    public void okletsgo1() {
//
//
//        System.out.println("Hier -      -           -               -");
        Date current = Calendar.getInstance().getTime();
        String date = DateFormat.getDateInstance(DateFormat.FULL).format(current);

//        CustomAnalogClock mmTime = (CustomAnalogClock) findViewById(R.id.analog_time);

        CustomAnalogClock analog = (CustomAnalogClock) findViewById(R.id.analog_clock);
                                    //face              //hour          //minute
        analog.init(this, R.drawable.aaa, R.drawable.side, R.drawable.west, 250, false, false);
        analog.setAutoUpdate(true);
        analog.setScale(.8f);
        View v = findViewById(R.id.analog_alles);
        v.setBackgroundColor(Color.WHITE);

//        Drawable d = getResources().getDrawable(R.drawable.a);
//        analog.setBackground(d);

//        analog.setBackgroundColor(Color.BLACK);
//        analog.setBackgroundColor(Color.WHITE);

//        View v = findViewById(R.id.alless);

//        v.setBackgroundColor(Color.WHITE);
//        analog.init();
//        findViewById(R.id.alless).setBackgroundColor(Color.BLACK);

//
//        mmTime.setScaleX(.3f);  //set size
//        mmTime.setScaleY(1f);  //set size
//        mmTime.setTime(Calendar.getInstance()); //setTime
//
//        mTag = findViewById(R.id.tag1);
//        mText = (TextView) findViewById(R.id.date1);
//
//        String[] test = date.split(",");
//        mTag.setText(test[0].trim());
////        String aaa = mTime.getText().toString();
////        aaa += " Uhr";
////        mTime.setText(aaa);
//
//
//
//        mText.setText(test[1]);
//
////        lightTheme();
//
////        this.setTheme(R.style.WestSide);
//        was();
    }
//
//    public void was() {
//
//        List<String> s = m.test(this);
//        TextView t = (TextView) findViewById(R.id.termine);
//        TextView termine2 = (TextView) findViewById(R.id.termine2);
//        TextView termine3 = (TextView) findViewById(R.id.termine3);
//        String tmp;
//        try {
//
//            String[] r = s.get(0).split(";");
//            tmp = "Der nächste Termin: " + r[0];
//            t.setText(tmp);
//            tmp = "Start: " + m.getDate(r[1]) + " " + m.getTime(r[1]) + " Uhr";
//            termine2.setText(tmp);
//            tmp = "Ende: " + m.getDate(r[2]) + " " + m.getTime(r[2]) + " Uhr";
//            termine3.setText(tmp);
//
//
//
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("Keine Termine gefunden glaube ich?");
//            tmp = "Keine Termine in den nächsten 14 Tagen!";
//            t.setText(tmp);
//        }
//    }
//
}