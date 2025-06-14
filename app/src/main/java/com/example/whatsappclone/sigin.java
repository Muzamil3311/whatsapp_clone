package com.example.whatsappclone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class sigin extends AppCompatActivity {

    EditText txtEmail, txtPassword;
    Button btnSignIn, btnGoogleSignIn, btnFacebookSignIn;
    TextView txtForgotPassword, txtNoAccount;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);

        // Firebase instance
        mAuth = FirebaseAuth.getInstance();

        // Bind Views
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnGoogleSignIn = findViewById(R.id.btnGoogleSignIn);
        btnFacebookSignIn = findViewById(R.id.btnFacebookSignIn);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtNoAccount = findViewById(R.id.txtNoAccount);

        // Sign In logic
        btnSignIn.setOnClickListener(v -> {
            String email = txtEmail.getText().toString().trim();
            String password = txtPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(this, "Sign In Successful!", Toast.LENGTH_SHORT).show();
                            // Navigate to main/home activity
                            startActivity(new Intent(sigin.this, main.class)); // replace with your home activity
                            finish();
                        } else {
                            Toast.makeText(this, "Sign In Failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });

        txtNoAccount.setOnClickListener(v -> {
            // Go to sign-up screen
            startActivity(new Intent(sigin.this, signup.class));
        });

        txtForgotPassword.setOnClickListener(v -> {
            // Handle password reset here (can implement later)
            Toast.makeText(this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
        });

        btnGoogleSignIn.setOnClickListener(v -> {
            Toast.makeText(this, "Google Sign In not implemented", Toast.LENGTH_SHORT).show();
        });

        btnFacebookSignIn.setOnClickListener(v -> {
            Toast.makeText(this, "Facebook Sign In not implemented", Toast.LENGTH_SHORT).show();
        });
    }
}
