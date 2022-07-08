package com.example.tablet;

import android.content.Context;
import android.database.Cursor;
import android.provider.CalendarContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyModel {

    private ArrayList<TextView> textViews;
    private MainActivity activity;

    private HashMap<String, View> views;// = new HashMap<>();
    private ArrayList<ImageView> imageViews;


    public MyModel(MainActivity activity) {
        this.activity = activity;
        textViews = new ArrayList<>();
        views = new HashMap<>();
        imageViews = new ArrayList<>();

        addView("alles", activity.findViewById(R.id.alles));
        addImageView("theme", activity.findViewById(R.id.theme));

        addTextView("day", activity.findViewById(R.id.day));
        addTextView("date", activity.findViewById(R.id.date));
        addTextView("time", activity.findViewById(R.id.time));
        addTextView("termine", activity.findViewById(R.id.termine));
        addTextView("termine2", activity.findViewById(R.id.termine2));
        addTextView("termine3", activity.findViewById(R.id.termine3));
        addTextView("abschnitt", activity.findViewById(R.id.abschnitt));

    }


    public List<String> getEvents(Context context, int days) {
        System.out.println("GET EVENTS METHOD");
        String[] projection = new String[] { CalendarContract.Events.CALENDAR_ID, CalendarContract.Events.TITLE, CalendarContract.Events.DESCRIPTION, CalendarContract.Events.DTSTART, CalendarContract.Events.DTEND, CalendarContract.Events.ALL_DAY, CalendarContract.Events.EVENT_LOCATION };
        Calendar startTime = Calendar.getInstance();

//        startTime.set(Calendar.HOUR_OF_DAY,0);
//        startTime.set(Calendar.MINUTE,0);
//        startTime.set(Calendar.SECOND, 0);

        Calendar endTime= Calendar.getInstance();

        // days = Tage ab heute ab denen gesucht werden soll
        endTime.add(Calendar.DATE, days);

        String selection = "(( " + CalendarContract.Events.DTSTART + " >= " + startTime.getTimeInMillis() + " ) AND ( " + CalendarContract.Events.DTSTART + " <= " + endTime.getTimeInMillis() + " ) AND ( deleted != 1 ))";
        Cursor cursor = context.getContentResolver().query(CalendarContract.Events.CONTENT_URI, projection, selection, null, null);

        String tmp = "";

        ArrayList<String> events = new ArrayList<>();
        cursor.moveToLast();

        if (cursor!=null&&cursor.getCount()>0) {
            do {

                tmp += cursor.getString(1) + ";";
                tmp += cursor.getString(3) + ";";
                tmp += cursor.getString(4);
                events.add(tmp);
                tmp = "";
                System.out.println("----------------------------------------------------------");

            } while ( cursor.moveToPrevious());
        }
        return events;
    }

    public String dateToString(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        return sdf.format(getTimeDate(time));
    }

    public String getTime(String string) {
        String s = dateToString(string);
        return s.split(" ")[1];
    }

    public String getDate(String string) {
        String s = dateToString(string);
        return s.split(" ")[0];
    }

    public Date getTimeDate(String time) {

        Date resultdate = new Date(Long.parseLong(time));
        return resultdate;
    }

    public static String getAbschnitt(int time) {

        if(time >= 7 && time < 11) {
            return "Morgens";
        }

        if(time >= 11 && time < 13) {
            return "Vormittags";
        }

        if(time >= 13 && time < 15) {
            return "Mittags";
        }

        if(time >= 15 && time < 18) {
            return "Nachmittags";
        }

        if(time >= 18 && time < 22) {
            return "Abends";
        }

        if(time >= 22 || time < 7) {
            return "Nachts";
        }

        return "";
    }

    public Calendar getNewCalendar() {
        return Calendar.getInstance();
    }


    public ArrayList<TextView> getTextViews() {
        return this.textViews;
    }

    public String getDateDate() {
        Date current = Calendar.getInstance().getTime();
        return DateFormat.getDateInstance(DateFormat.FULL).format(current);
    }

    public String getDay() {
        return getDateDate().split(",")[0].trim();
    }

    public String getDate() {
        return getDateDate().split(",")[1];
    }

    public String getAbschnitt() {
        return MyModel.getAbschnitt(getNewCalendar().get(Calendar.MINUTE));
    }












    public View getView(String id) {
        return views.get(id);
    }

    public void addTextView(String key, TextView textview) {
        views.put(key, textview);
        textViews.add(textview);
    }

    public void addView(String key, View view) {
        views.put(key, view);
    }

    public void addImageView(String key, ImageView imageView) {
        views.put(key, imageView);
        imageViews.add(imageView);
    }


    public void setTimeListener(MyView myView) {
        TextView tmp = (TextView) getView("time");
        tmp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myView.setAbschnitt();
                myView.setEvents();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void setThemeListener() {
        ImageView img = (ImageView) getView("theme");
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.switcher(v);
            }
        });

    }



}
