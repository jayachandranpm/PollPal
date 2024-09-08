package com.votingsystem.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.votingsystem.R;
import com.votingsystem.database.AppDatabase;

public class SetVotingPeriodActivity extends AppCompatActivity {
    private EditText startDateEditText, endDateEditText;
    private Button setButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_voting_period);

        startDateEditText = findViewById(R.id.startDateEditText);
        endDateEditText = findViewById(R.id.endDateEditText);
        setButton = findViewById(R.id.setButton);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startDate = startDateEditText.getText().toString();
                String endDate = endDateEditText.getText().toString();
                // Save voting period to database
                finish();
            }
        });
    }
}