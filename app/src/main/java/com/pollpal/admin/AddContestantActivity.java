package com.votingsystem.admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.votingsystem.R;
import com.votingsystem.database.AppDatabase;
import com.votingsystem.model.Contestant;

public class AddContestantActivity extends AppCompatActivity {
    private EditText nameEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contestant);

        nameEditText = findViewById(R.id.nameEditText);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                Contestant contestant = new Contestant(name);
                AppDatabase.getInstance(getApplicationContext()).contestantDao().insert(contestant);
                finish();
            }
        });
    }
}