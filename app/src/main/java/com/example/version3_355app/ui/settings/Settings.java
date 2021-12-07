package com.example.version3_355app.ui.settings;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.version3_355app.R;

import java.util.ArrayList;

public class Settings extends AppCompatActivity{
    ArrayList<String> settingsList = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_settings);

        ListView listView = (ListView) findViewById(R.id.listview); // list in your XML

        settingsList.add("Account");
        settingsList.add("NotificationSetting");
        settingsList.add("Appearance");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, settingsList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener( new  AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        Intent i = new Intent(Settings.this,
                                Account.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i1 = new Intent( Settings.this,
                                NotificationSetting.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(Settings.this,
                                Appearance.class);
                        startActivity(i2);
                        break;
                }
            }

        });

    }
}

