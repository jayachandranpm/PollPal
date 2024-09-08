package com.votingsystem.admin;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.votingsystem.R;
import com.votingsystem.database.AppDatabase;
import com.votingsystem.model.Contestant;

import java.util.List;

public class ViewResultsActivity extends AppCompatActivity {
    private TextView resultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        resultsTextView = findViewById(R.id.resultsTextView);

        List<Contestant> contestants = AppDatabase.getInstance(getApplicationContext()).contestantDao().getAll();
        StringBuilder results = new StringBuilder();
        for (Contestant contestant : contestants) {
            results.append(contestant.getName()).append(": ").append(contestant.getVotes()).append("\n");
        }
        resultsTextView.setText(results.toString());
    }
}