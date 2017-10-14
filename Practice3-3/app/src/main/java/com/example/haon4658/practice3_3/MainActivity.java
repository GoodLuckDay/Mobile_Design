package com.example.haon4658.practice3_3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput;
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Main: onStart 호출됨",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Main: onPause 호출됨",Toast.LENGTH_SHORT).show();
        saveState();
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name", nameInput.getText().toString());
        editor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Main: onDestory 호출됨",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Main: onResume 호출됨",Toast.LENGTH_SHORT).show();
        restoreState();
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((pref != null) && (pref.contains("name"))){
            String name = pref.getString("name", "");
            nameInput.setText(name);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Main: onStop 호출됨",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Main: onCreate 호출됨",Toast.LENGTH_SHORT).show();
        nameInput = (EditText) findViewById(R.id.nameInput);
    }

    public void onButton1Clicked(View v){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        startActivity(intent);
    }
}
