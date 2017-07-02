package de.cleanwifi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TipList extends AppCompatActivity {


    final String TAG = "TipList";


    public AlertDialog.Builder builder = null;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_list);
        builder = new AlertDialog.Builder(this);

        updateTips();

        ((ListView)findViewById(R.id.tip_list)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tip tip = Tips.tips.get(i);
                showDialog(tip.getTitle(), tip.getMessage(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tips.openTip(i, TipList.this);
                    }
                }, "Mehr", "Abbrechen");
            }
        });
    }

    public void updateTips() {
        Log.v(TAG, "updateTips()");
        String[] tips = new String[Tips.tips.size()];

        for (int i = 0; i < tips.length; i++) {
            tips[i] = Tips.tips.get(i).getTitle();
            Log.v(TAG, "Hinzugefügt " + tips[i]);
        }

        updateListView(tips);
    }


    public void updateListView(String[] list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.tip_item, list);
        ListView listView = (ListView)findViewById(R.id.tip_list);
        listView.setAdapter(adapter);
    }



}
