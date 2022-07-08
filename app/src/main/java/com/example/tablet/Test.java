//package com.example.tablet;
//
//import android.content.ContentResolver;
//import android.database.Cursor;
//import android.icu.util.Calendar;
//import android.os.Build;
//import android.provider.CalendarContract;
//
//import androidx.annotation.RequiresApi;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Test {
//
////    @RequiresApi(api = Build.VERSION_CODES.N)
//    public static void main(String[] args) {
////        ContentResolver contentResolver = getContentResolver();
////        Cursor cursor = contentResolver.query(Uri.parse("content://com.android.calendar/calendars"),
////                (new String[]   { Calendars._ID,  Calendars.ACCOUNT_NAME,  Calendars.CALENDAR_DISPLAY_NAME, }), null, null, null);
//
//
//
////        String[] projection = new String[] { CalendarContract.Events.CALENDAR_ID, CalendarContract.Events.TITLE, CalendarContract.Events.DESCRIPTION, CalendarContract.Events.DTSTART, CalendarContract.Events.DTEND, CalendarContract.Events.ALL_DAY, CalendarContract.Events.EVENT_LOCATION };
////
////        Calendar startTime = Calendar.getInstance();
////
////        startTime.set(Calendar.HOUR_OF_DAY,0);
////        startTime.set(Calendar.MINUTE,0);
////        startTime.set(Calendar.SECOND, 0);
////
////        Calendar endTime= Calendar.getInstance();
////        endTime.add(Calendar.DATE, 1);
////
////        String selection = "(( " + CalendarContract.Events.DTSTART + " >= " + startTime.getTimeInMillis() + " ) AND ( " + CalendarContract.Events.DTSTART + " <= " + endTime.getTimeInMillis() + " ) AND ( deleted != 1 ))";
////        Cursor cursor = context.getContentResolver().query(CalendarContract.Events.CONTENT_URI, projection, selection, null, null);
////
////        List<String> events = new ArrayList<>();
////        if (cursor!=null&&cursor.getCount()>0&&cursor.moveToFirst()) {
////            do {
////                events.add(cursor.getString(1));
////            } while ( cursor.moveToNext());
////        }
//    }
//}
