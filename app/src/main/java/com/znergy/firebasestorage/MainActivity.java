package com.znergy.firebasestorage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.etLocation) EditText etLocation;
    @Bind(R.id.tvLocationDisplay) TextView tvLocationDisplay;
    @Bind(R.id.tvResult) TextView tvResult;
    @Bind(R.id.button) Button button;

    /** Declaring our Shared Preferences */
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /** Assigning our Shared Preferences variables */
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == button) {
            String location = etLocation.getText().toString();
            if(!(location).equals("")) {
                /** calls the method that stores our location in Shared Preferences */
                addToSharedPreferences(location);
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
            }
        }
    }

    /** Stores the location being passed in Shared Preferences */
    private void addToSharedPreferences(String location) {
        editor.putString("location", location).apply();
    }
}
