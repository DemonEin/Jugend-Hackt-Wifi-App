package de.cleanwifi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    final String TAG = "MainActivity";

    public static MainActivity activity;
    public AlertDialog.Builder builder = null;

    public Boolean activated = false;


    public void showDialog(String title, String message, DialogInterface.OnClickListener listener, String positive, String negative) {
        Log.v("Tips", "showDialog");
        builder.setMessage(message)
                .setTitle(title)
                .setPositiveButton(positive, listener)
                .setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                }).show();


    }

    public void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;


        Tips.loadTips();


        Drawable bg2 = getResources().getDrawable(R.drawable.bg2);
        Drawable bg3 = getResources().getDrawable(R.drawable.bg3);

        builder = new AlertDialog.Builder(this);


        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.activity, TipList.class);
                startActivity(intent);
            }
        });

        Button b = ((Button)findViewById(R.id.cleanWifi));

        b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                switch(motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if(!activated)
                            ((ConstraintLayout) findViewById(R.id.main_layout)).setBackgroundResource(R.drawable.bg2);
                        return true;
                    case MotionEvent.ACTION_UP:
                        if(!activated) {
                            ((ConstraintLayout) findViewById(R.id.main_layout)).setBackgroundResource(R.drawable.bg3);
                            activated = true;

                            Toast.makeText(MainActivity.activity, "CleanWiFi wurde aktiviert!", Toast.LENGTH_LONG).show();



                        }

                        return true;
                }
                return false;

            }
        });


        Tips.showTip(0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Tips.openTip(0, MainActivity.activity);
            }
        });


    }
}
