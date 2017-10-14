package com.example.haon4658.hw3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button customerButton = (Button) findViewById(R.id.customer_button);
        customerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("service", "메뉴: 고객 관리");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button salesButton = (Button) findViewById(R.id.sales_button);
        salesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("service", "메뉴: 매출 관리");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button productButton = (Button) findViewById(R.id.product_button);
        productButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("service", "메뉴: 상품 관리");
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
            String id = bundle.getString("id");
            String passwd = bundle.getString("passwd");
            Toast.makeText(getApplicationContext(), "username: "+id+ ", password: "+passwd, Toast.LENGTH_SHORT).show();
        }
    }
}
