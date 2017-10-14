package com.example.haon4658.practice3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQEUST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

        SimpleData data = new SimpleData(100, "Hello Android");
        intent.putExtra(KEY_SIMPLE_DATA, data);
        startActivityForResult(intent, REQEUST_CODE_MENU);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == REQEUST_CODE_MENU){
                if(data != null){
                    Bundle bundle = data.getExtras();
                    String name = bundle.getString("name");
                    Toast.makeText(getApplicationContext(), "name: "+name, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
