package com.example.tablet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

//import com.example.tablet.databinding.ActivityFullscreenBinding;
import com.tomerrosenfeld.customanalogclockview.CustomAnalogClock;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {}
//    TextView mText;
//    TextView mTag;
//    TextClock mTime;
//    boolean farbe;
//    View myView;
//    Model m = new Model();
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        farbe = true;
////        lightTheme();
////        setTheme(R.style.WestSide);
//        setContentView(R.layout.activity_fullscreen);
//
//
//        okletsgo1();
//
//    }
//
//    public void okletsgo1() {
//
//
//        System.out.println("Hier -      -           -               -");
//        Date current = Calendar.getInstance().getTime();
//        String date = DateFormat.getDateInstance(DateFormat.FULL).format(current);
//
//        CustomAnalogClock mmTime = (CustomAnalogClock) findViewById(R.id.analog_time);
//
//
//        mmTime.setScaleX(0.5f);  //set size
//        mmTime.setScaleY(0.5f);  //set size
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
//    }
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
//}