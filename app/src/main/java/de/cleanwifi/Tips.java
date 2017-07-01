package de.cleanwifi;

import android.content.DialogInterface;

public class Tips {

    public static int tips = 1;


    public static String getTitle(int i) {

        return "Tipp " + (i + 1);
    }

    public static String getMessage(int i) {
        if(i == 0) {
            return "AGBGZBI";
        }


        return "Unbekannter Tipp";
    }


    public static void showTip(int i, DialogInterface.OnClickListener listener) {
        MainActivity.activity.showDialog(getTitle(i), getMessage(i), listener, "Mehr", "Schließen");
    }



}
