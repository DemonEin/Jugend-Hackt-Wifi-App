package de.cleanwifi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Tips {

    public static List<Tip> tips = new ArrayList<Tip>();
    public static final String TAG = "Tips";


    public static void showTip(int i, DialogInterface.OnClickListener listener) {
        if(!tips.isEmpty())
            MainActivity.activity.showDialog(tips.get(i).getTitle(), tips.get(i).getMessage(), listener, "Mehr", "Schließen");
        else
            Log.v(TAG, "Keine Tipps vorhanden!");
    }

    public static void goToUrl (String url, Context context) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        context.startActivity(launchBrowser);
    }
    public static void openTip(int i, Context context) {
        goToUrl("https://so.urceco.de/cleanwifi/#Tipp" + (i+1), context);
    }


    public static void loadTips() {
        tips = readTipsFromJSON();
    }
    public static List<Tip> readTipsFromJSON() {
        List<Tip> tipList = new ArrayList<Tip>();
        try {
            JSONArray tipArray = new JSONArray(loadJSONFromAsset());
            for (int i = 0; i < tipArray.length(); i++) {
                Log.v(TAG, "Tipp " + i + " hinzugefügt");
                JSONObject tipJson = tipArray.getJSONObject(i);
                Tip tip = new Tip(tipJson.getString("title"), tipJson.getString("text"), i);
                tipList.add(tip);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tipList;
    }

    public static String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = MainActivity.activity.getResources().openRawResource(R.raw.tips);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



}
