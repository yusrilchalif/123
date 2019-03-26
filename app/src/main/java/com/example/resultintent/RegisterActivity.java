package com.example.resultintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editName;
    EditText editEmail;
    EditText editPassword;
    EditText editPhone;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.slime));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(backIntent);
            }
        });

        editName = findViewById(R.id.edtName);
        editEmail = findViewById(R.id.edtEmail);
        editPassword = findViewById(R.id.edtPassword);
        editPhone = findViewById(R.id.edtPhoneNumber);

        registerButton = findViewById(R.id.btnRegister);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegister) {
            if (emptyText()) {
                Toast.makeText(this,
                        "Data cannot be empty", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent();
                intent.putExtra("MESSAGE", editEmail.getText().toString());
                setResult(100, intent);
                finish();
            }
        }
    }

    boolean emptyText()
    {
        boolean error;
        if (editEmail.getText().toString().equals("") || editPassword.getText().toString().equals("")
            || editPassword.getText().toString().equals("") || editPhone.getText().toString().equals("")) {
            error = true;
        }
        else {
            error = false;
        }

        return  error;
    }
}
