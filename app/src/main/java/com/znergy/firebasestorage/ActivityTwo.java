package com.znergy.firebasestorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityTwo extends AppCompatActivity {
    @Bind(R.id.textViewThatDisplaysLocation) TextView tvThatDisplaysLocation;

    /** Declaring our Shared Preferences variable */
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);

        /** Assigning our Shared Preferences variable */
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        /** Setting the text as our Shared Preferences location value from MainActivity
         * getString(key, default value), default value could be a zip code or nothing */
        tvThatDisplaysLocation.setText(sharedPreferences.getString("location", null));
    }
}
