package com.example.version3_355app.ui.settings;

import android.os.Bundle;
import com.example.version3_355app.R;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.prefrerences, rootKey);

        PreferenceScreen screen = getPreferenceScreen();
        final ListPreference listPreference = (ListPreference) findPreference("list_prefrence_key");
        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {

            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                listPreference.setValue(newValue.toString());
                String theme = String.valueOf(listPreference.getEntry());
                if(theme.equals("Light")){
                    System.out.println("light");

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                if(theme.equals("Dark")){
                    System.out.println("dark");

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                if(theme.equals("System")){
                    System.out.println("sytem");
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }

                return true;
            }
        });
    }


}