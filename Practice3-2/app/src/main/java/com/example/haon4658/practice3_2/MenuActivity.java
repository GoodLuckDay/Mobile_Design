package com.example.haon4658.practice3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView textView;

    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView) findViewById(R.id.testView);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name","mike");

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);

    }

    private void processIntent(Intent intent) {
        if(intent != null){
            Bundle bundle = intent.getExtras();

            SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA);

            textView.setText("전달 받은 데이터\nNumber : "+data.getNumber() +
            "\nMessage : "+data.getMessage());
        }
    }
}