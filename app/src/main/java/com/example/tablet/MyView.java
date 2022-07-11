package com.example.tablet;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyView extends AppCompatActivity {


    AppCompatActivity activity;
    MyModel myModel;

    static int n  = 1;

    static boolean farbe = false;

    final private int light_background = 0xFF2B2B2B;
    final private int light_text = 0xFFFFFFFF;
    final private int light_icon = R.drawable.sunny;
    private int analog_icon_light = R.drawable.image;

    final private int dark_background = 0xFFFFFFFF;
    final private int dark_text = 0xFF000000;
    final private int dark_icon = R.drawable.nighty;
    private int analog_icon_dark = R.drawable.iconanalog;

    public void setLightIcon(int icon) {
        analog_icon_light = icon;
    }

    public void setDarkIcon(int icon) {
        analog_icon_dark = icon;
    }


    public MyView(AppCompatActivity activity) {
        this.activity = activity;


    }



    public void init() {
//        farbe = true;
        setDay();
        setDate();
        setAbschnitt();
        setEvents();
        switcher();



    }

    public void switcher(View v) {
        n+=1;
        System.out.println("\n\n");
        System.out.println(n + "   " + (n%2) + "   " + (n % 2 == 0));
        if((n % 2) == 0) {
            changeTheme(light_background, light_text, light_icon, analog_icon_light);
        } else {
            changeTheme(dark_background, dark_text, dark_icon, analog_icon_dark);
        }

    }

    public void switcher() {
        System.out.println("\n\n");
        System.out.println(n + "   " + (n%2) + "   " + (n % 2 == 0));
        if((n % 2) == 0) {
            changeTheme(light_background, light_text, light_icon, analog_icon_light);
        } else {
            changeTheme(dark_background, dark_text, dark_icon, analog_icon_dark);
        }

    }


    public void changeTheme(int background, int textColor, int themeID, int analogID) {

        if(myModel.getTextViews().size() != 0) {
            for (TextView v : myModel.getTextViews()) {
//                System.out.println(v);
                v.setTextColor(textColor);
            }
        }

        View alles = myModel.getView("alles");
        ImageView theme = (ImageView) myModel.getView("theme");
        ImageView analog = (ImageView) myModel.getView("analog");

        alles.setBackgroundColor(background);
        theme.setImageDrawable(activity.getResources().getDrawable(themeID));
        analog.setImageDrawable(activity.getResources().getDrawable(analogID));
    }




    public void setEvents() {

        List<String> events = myModel.getEvents(activity, 14);
        TextView termine = (TextView) myModel.getView("termine");
        TextView termine2 = (TextView) myModel.getView("termine2");
        TextView termine3 = (TextView) myModel.getView("termine3");
        String tmp;
        try {

            String[] info = events.get(0).split(";");
            tmp = "Der nächste Termin: " + info[0];
            termine.setText(tmp);

            tmp = "Start: " + myModel.getDate(info[1]) + " " + myModel.getTime(info[1]) + " Uhr";
            termine2.setText(tmp);

            tmp = "Ende: " + myModel.getDate(info[2]) + " " + myModel.getTime(info[2]) + " Uhr";
            termine3.setText(tmp);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Keine Termine gefunden glaube ich?");
            tmp = "Keine Termine in den nächsten 14 Tagen!";
            termine.setText(tmp);
        }
    }



    public void setDay() {
        TextView v = (TextView) myModel.getView("day");
        v.setText(myModel.getDay());
    }

    public void setDate() {
        TextView v = (TextView) myModel.getView("date");
        v.setText(myModel.getDate());
    }

    public void setAbschnitt() {
        TextView v = (TextView) myModel.getView("abschnitt");
        v.setText(myModel.getAbschnitt());
    }

    public void subscribe(MyModel myModel) {
        this.myModel = myModel;
        this.myModel.setTimeListener(this);
        this.myModel.setThemeListener();
    }


}
