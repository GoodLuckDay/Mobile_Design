package com.example.haon4658.hw04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText idText;
    EditText passwdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText = (EditText) findViewById(R.id.idText);
        passwdText = (EditText) findViewById(R.id.passwordText);

        Button button = (Button) findViewById(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idText.getText().toString().length() == 0 || passwdText.getText().length() == 0){
                    Toast.makeText(getApplicationContext(), "사용자명이나 비밀번호가 입력되지 않았습니다.", Toast.LENGTH_LONG).show();
                }
                else{
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                }
            }
        });
    }
}
