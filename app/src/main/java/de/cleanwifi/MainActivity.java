package de.cleanwifi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    public static MainActivity activity;
    public AlertDialog.Builder builder = null;


    public void showDialog(String title, String message, DialogInterface.OnClickListener listener, String positive, String negative) {

        builder.setMessage(message)
                .setTitle(title)
                .setPositiveButton(positive, listener)
                .setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                }).show();


    }

    public void goToUrl (String url) {
        //Uri uriUrl = Uri.parse(url);
        //Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        //startActivity(launchBrowser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(this);
        activity = this;

        Tips.showTip(0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }
}
