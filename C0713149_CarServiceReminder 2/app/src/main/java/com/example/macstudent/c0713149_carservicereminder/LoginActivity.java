package com.example.macstudent.c0713149_carservicereminder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button signUp;
    EditText userName;
    EditText psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText) findViewById(R.id.txtUserName);
        psw = (EditText) findViewById(R.id.txtPsw);
        signUp = (Button) findViewById(R.id.btnLogin);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = userName.getText().toString();
                String str1 = psw.getText().toString();

                if (str.equals("a@g.com") && str1.equals("123")) {
                    Toast.makeText(LoginActivity.this, "User Logged In", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);

                } else {
                    Toast.makeText(LoginActivity.this, "User Not logged in", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
