package com.votingsystem.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.votingsystem.R;

public class OtpVerificationActivity extends AppCompatActivity {
    private EditText otpEditText;
    private Button verifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        otpEditText = findViewById(R.id.otpEditText);
        verifyButton = findViewById(R.id.verifyButton);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = otpEditText.getText().toString();
                String expectedOtp = getIntent().getStringExtra("otp");
                if (otp.equals(expectedOtp)) {
                    Intent intent = new Intent(OtpVerificationActivity.this, VoteActivity.class);
                    intent.putExtra("userId", getIntent().getIntExtra("userId", -1));
                    startActivity(intent);
                } else {
                    // Show error message
                }
            }
        });
    }
}