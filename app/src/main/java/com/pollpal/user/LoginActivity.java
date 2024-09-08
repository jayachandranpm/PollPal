package com.votingsystem.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.votingsystem.R;
import com.votingsystem.database.AppDatabase;
import com.votingsystem.model.User;
import com.votingsystem.utils.OtpGenerator;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                User user = AppDatabase.getInstance(getApplicationContext()).userDao().getUserByUsername(username);
                if (user != null && user.getPassword().equals(password)) {
                    String otp = OtpGenerator.generateOtp();
                    // Save OTP to user
                    Intent intent = new Intent(LoginActivity.this, OtpVerificationActivity.class);
                    intent.putExtra("userId", user.getId());
                    intent.putExtra("otp", otp);
                    startActivity(intent);
                } else {
                    // Show error message
                }
            }
        });
    }
}