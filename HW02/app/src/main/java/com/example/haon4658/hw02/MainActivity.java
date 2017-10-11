package com.example.haon4658.hw02;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("1");
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("2");
            }
        });

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("3");
            }
        });

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("4");
            }
        });

        Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("5");
            }
        });

        Button button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("6");
            }
        });

        Button button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("7");
            }
        });

        Button button8 = (Button)findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("8");
            }
        });

        Button button9 = (Button)findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("9");
            }
        });

        Button button0 = (Button)findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("0");
            }
        });

        Button plus_button = (Button)findViewById(R.id.button_plus);
        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("+");
            }
        });

        Button minus_button = (Button)findViewById(R.id.button_minus);
        minus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("-");
            }
        });

        Button mutiple_button = (Button)findViewById(R.id.button_multiple);
        mutiple_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("*");
            }
        });
        Button divide_button = (Button)findViewById(R.id.button_divide);
        divide_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().append("/");
            }
        });

        Button clear_button = (Button) findViewById(R.id.button_clear);
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().clear();
            }
        });

        Button equal_button = (Button) findViewById(R.id.button_equal);
        equal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String[] operand = editText.getText().toString().split("[+\\-\\*/]");
                    String operator = editText.getText().toString().replaceAll("[0-9]", "");
                    int result = 0;
                    if (operator.equals("+")) {
                        result = Integer.parseInt(operand[0]) + Integer.parseInt(operand[1]);
                    } else if (operator.equals("-")) {
                        result = Integer.parseInt(operand[0]) - Integer.parseInt(operand[1]);
                    } else if (operator.equals("*")) {
                        result = Integer.parseInt(operand[0]) * Integer.parseInt(operand[1]);
                    } else if (operator.equals("/")) {
                        result = Integer.parseInt(operand[0]) / Integer.parseInt(operand[1]);
                    }

                    Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
