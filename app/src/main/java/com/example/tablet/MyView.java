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


    MainActivity activity;
    MyModel myModel;


    public MyView(MainActivity activity, MyModel myModel) {
        this.activity = activity;
        this.myModel = myModel;
    }



    public void init() {
        setDay();
        setDate();
        setAbschnitt();
        setEvents();
        myModel.setTimeListener(this);
        myModel.setThemeListener();

    }



    public void changeTheme(int background, int textColor, int id) {

        for (TextView v: myModel.getTextViews()) {
            v.setTextColor(textColor);
        }

        View alles = myModel.getView("alles");
        ImageView icon = (ImageView) myModel.getView("theme");

        alles.setBackgroundColor(background);
        icon.setImageDrawable(activity.getResources().getDrawable(id));
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




}
