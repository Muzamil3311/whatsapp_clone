package com.example.whatsappclone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    EditText txtUsername, txtEmail, txtPassword;
    Button btnSignUp, btnGoogle, btnFacebook;
    TextView txtAlreadyHaveAccount, txtSignUpPhone;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Firebase auth instance
        mAuth = FirebaseAuth.getInstance();

        // Initialize Views
        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtpassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnGoogle = findViewById(R.id.btngoogle);
        btnFacebook = findViewById(R.id.btnfacebook);
        txtAlreadyHaveAccount = findViewById(R.id.txtAlreadyHaveAccount);
        txtSignUpPhone = findViewById(R.id.txtSignUpPhone);

        btnSignUp.setOnClickListener(v -> {
            String username = txtUsername.getText().toString().trim();
            String email = txtEmail.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Firebase Auth: Create user
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
                            // Navigate to Sign-In
                            startActivity(new Intent(signup.this, sigin.class));
                            finish();
                        } else {
                            Toast.makeText(this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });

        txtAlreadyHaveAccount.setOnClickListener(v -> {
            startActivity(new Intent(signup.this, sigin.class));
        });

        txtSignUpPhone.setOnClickListener(v -> {
            Toast.makeText(this, "Sign Up with Phone not implemented", Toast.LENGTH_SHORT).show();
        });

        btnGoogle.setOnClickListener(v -> {
            Toast.makeText(this, "Google Sign Up not implemented", Toast.LENGTH_SHORT).show();
        });

        btnFacebook.setOnClickListener(v -> {
            Toast.makeText(this, "Facebook Sign Up not implemented", Toast.LENGTH_SHORT).show();
        });
    }
}
