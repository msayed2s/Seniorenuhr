package com.example.tablet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//import com.tomerrosenfeld.*

public class MainActivity extends AppCompatActivity {



    private MyModel myModel;
    private MyView myView;

//    final private int light_background = 0xFF2B2B2B;
//    final private int light_text = 0xFFFFFFFF;
//    final private int light_icon = R.drawable.sunny;
//    final private int analog_icon_light = R.drawable.image;
//
//    final private int dark_background = 0xFFFFFFFF;
//    final private int dark_text = 0xFF000000;
//    final private int dark_icon = R.drawable.nighty;
//    final private int analog_icon_dark = R.drawable.iconanalog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        analogSwitch();


        myModel = new MyModel(this);
        myView = new MyView(this);



        init();
        myView.init();
//        myView.switcher();


    }

    public void init() {



        myModel.addView("alles", findViewById(R.id.alles));

        myModel.addImageView("theme", findViewById(R.id.theme));
        myModel.addImageView("analog", findViewById(R.id.analog));

        myModel.addTextView("day", findViewById(R.id.day));
        myModel.addTextView("date", findViewById(R.id.date));
        myModel.addTextView("time", findViewById(R.id.time));
        myModel.addTextView("termine", findViewById(R.id.termine));
        myModel.addTextView("termine2", findViewById(R.id.termine2));
        myModel.addTextView("termine3", findViewById(R.id.termine3));
        myModel.addTextView("abschnitt", findViewById(R.id.abschnitt));


        myView.subscribe(myModel);
        myModel.subscribe(myView);
    }




    public void analogSwitch(View v) {

        Intent intent = new Intent(this, FullscreenActivity.class);
//        FullscreenActivity.farbe = this.myView.farbe;
        startActivity(intent);
        finish();
//        setContentView(R.layout.activity_fullscreen);
    }


    public void analogSwitch() {

//        setContentView(R.layout.activity_fullscreen);

        Intent intent = new Intent(this, FullscreenActivity.class);
        startActivity(intent);

//        setContentView(R.layout.activity_fullscreen);
    }


}