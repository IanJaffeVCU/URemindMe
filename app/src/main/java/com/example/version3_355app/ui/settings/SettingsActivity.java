package com.example.version3_355app.ui.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.version3_355app.R;


public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        if(findViewById(R.id.fragment_container) != null){

            if(savedInstanceState != null)
                return;

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();

        }
    }
}