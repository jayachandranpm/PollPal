package com.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.votingsystem.admin.AddContestantActivity;
import com.votingsystem.admin.SetVotingPeriodActivity;
import com.votingsystem.admin.ViewResultsActivity;
import com.votingsystem.user.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private Button adminButton, userButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adminButton = findViewById(R.id.adminButton);
        userButton = findViewById(R.id.userButton);

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAdminOptions();
            }
        });

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToLogin();
            }
        });
    }

    private void showAdminOptions() {
        // Create a dialog or a new activity to show admin options
        // For simplicity, we'll navigate to a new activity
        Intent intent = new Intent(MainActivity.this, AdminOptionsActivity.class);
        startActivity(intent);
    }

    private void navigateToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}