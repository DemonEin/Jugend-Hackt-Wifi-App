package de.cleanwifi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class TipList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_list);
    }


    public void updateListView(String[] list) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, list)
    }



}
