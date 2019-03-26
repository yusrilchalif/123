package com.example.resultintent;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button loginButton;
    TextView tvRegister;
    EditText editEmail;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(this);
        tvRegister = findViewById(R.id.txtRegister);
        tvRegister.setOnClickListener(this);

        editEmail = findViewById(R.id.edtEmail);
        editPassword = findViewById(R.id.edtPassword);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                if (emptyText()) {
                    Toast.makeText(this,
                            "Email or Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(loginIntent);
                }
                break;
            case R.id.txtRegister:
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
                break;
        }
    }

    boolean emptyText()
    {
        boolean error;
        if (editEmail.getText().toString().equals("") || editPassword.getText().toString().equals("")) {
            error = true;
        }
        else {
            error = false;
        }

        return  error;
    }
}
