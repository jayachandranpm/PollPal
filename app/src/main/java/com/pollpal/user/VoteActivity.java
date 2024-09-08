package com.votingsystem.user;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.votingsystem.R;
import com.votingsystem.database.AppDatabase;
import com.votingsystem.model.Contestant;

import java.util.List;

public class VoteActivity extends AppCompatActivity {
    private RadioGroup contestantsRadioGroup;
    private Button voteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        contestantsRadioGroup = findViewById(R.id.contestantsRadioGroup);
        voteButton = findViewById(R.id.voteButton);

        loadContestants();

        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = contestantsRadioGroup.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedContestantName = selectedRadioButton.getText().toString();
                    updateVoteCount(selectedContestantName);
                    finish();
                } else {
                    Toast.makeText(VoteActivity.this, "Please select a contestant", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadContestants() {
        List<Contestant> contestants = AppDatabase.getInstance(getApplicationContext()).contestantDao().getAll();
        for (Contestant contestant : contestants) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(contestant.getName());
            radioButton.setId(View.generateViewId());
            contestantsRadioGroup.addView(radioButton);
        }
    }

    private void updateVoteCount(String contestantName) {
        AppDatabase.getInstance(getApplicationContext()).contestantDao().voteByName(contestantName);
        Toast.makeText(VoteActivity.this, "Vote submitted successfully", Toast.LENGTH_SHORT).show();
    }
}