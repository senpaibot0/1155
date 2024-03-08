package com.example.justdidit.Ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.justdidit.R;
import com.example.justdidit.Ui.ProfileFrag;
import com.example.justdidit.Ui.StatsFrag;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_dashboard);

        // Initial fragment load
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ProfileFrag())
                    .commit();
        }

        // Setup button listeners
        Button buttonFragmentProfile = findViewById(R.id.btnprofile);
        buttonFragmentProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ProfileFrag())
                        .commit();
            }
        });

        Button buttonFragmentStats = findViewById(R.id.btnstats);
        buttonFragmentStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new StatsFrag())
                        .commit();
            }
        });
    }
}

