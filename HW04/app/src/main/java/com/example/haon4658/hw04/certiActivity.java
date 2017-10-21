package com.example.haon4658.hw04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class certiActivity extends AppCompatActivity {
    TextView textView;
    Button backMenu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certi);

        final Intent intent = getIntent();
        final String type = intent.getStringExtra("type");
        final String msg = intent.getStringExtra("msg");
        final int code = intent.getIntExtra("code", 0);

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        textView = (TextView) findViewById(R.id.certiText);
        textView.setText(msg);

        backMenu_button = (Button) findViewById(R.id.back_menu);
        backMenu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent temp = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("msg", String.format("%s 응답, result code : %d, message: result message is %s",type, code, code==-1 ? "OK" : "실패"));

                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
