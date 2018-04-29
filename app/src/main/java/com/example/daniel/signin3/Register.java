package com.example.daniel.signin3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private Button reg;
    private EditText email;
    private EditText pass;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg = findViewById(R.id.Register);
        email = findViewById(R.id.emailReg);
        pass = findViewById(R.id.PassReg);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();

            }
        });

    }

    public void OnStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void Register() {
        String emnewreg = email.getText().toString();
        String pwnewreg = pass.getText().toString();
        if (TextUtils.isEmpty(emnewreg) || TextUtils.isEmpty(pwnewreg)) {
            Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG).show();
        } else {
            mAuth.createUserWithEmailAndPassword(emnewreg, pwnewreg).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                public static final String TAG = "";

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        startActivity(new Intent(getApplicationContext(),
                                Home.class));
                        Toast.makeText(getApplicationContext(), "Welcome New User", Toast.LENGTH_LONG).show();
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure");
                        Toast.makeText(getApplicationContext(), "Cannot add user at this time. Please try again.", Toast.LENGTH_LONG).show();

                    }
                }
            });


        }

    }
}
