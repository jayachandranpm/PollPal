package com.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.votingsystem.admin.AddContestantActivity;
import com.votingsystem.admin.SetVotingPeriodActivity;
import com.votingsystem.admin.ViewResultsActivity;

public class AdminOptionsActivity extends AppCompatActivity {
    private Button addContestantButton, setVotingPeriodButton, viewResultsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_options);

        addContestantButton = findViewById(R.id.addContestantButton);
        setVotingPeriodButton = findViewById(R.id.setVotingPeriodButton);
        viewResultsButton = findViewById(R.id.viewResultsButton);

        addContestantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToAddContestant();
            }
        });

        setVotingPeriodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToSetVotingPeriod();
            }
        });

        viewResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToViewResults();
            }
        });
    }

    private void navigateToAddContestant() {
        Intent intent = new Intent(AdminOptionsActivity.this, AddContestantActivity.class);
        startActivity(intent);
    }

    private void navigateToSetVotingPeriod() {
        Intent intent = new Intent(AdminOptionsActivity.this, SetVotingPeriodActivity.class);
        startActivity(intent);
    }

    private void navigateToViewResults() {
        Intent intent = new Intent(AdminOptionsActivity.this, ViewResultsActivity.class);
        startActivity(intent);
    }
}