package com.example.haon4658.hw04;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 1001;
    public static final int RESULT_CODE_OK = 0;
    public static final int RESULT_CODE_REJECT = -1;

    public static final int REQUEST_PERMISSION_LOCATION = 1;
    public static final int REQUEST_PERMISSION_CAMERA = 2;
    public static final int REQUEST_PERMISSION_CALENDAR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button position_button = (Button) findViewById(R.id.position_button);
        position_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MenuActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION_LOCATION);
            }
        });

        Button camera_button = (Button) findViewById(R.id.camera_button);
        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MenuActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION_CAMERA);
            }
        });

        Button calendar_button = (Button) findViewById(R.id.calendar_button);
        calendar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(MenuActivity.this, new String[]{Manifest.permission.READ_CALENDAR}, REQUEST_PERMISSION_CALENDAR);
            }
        });
        Button back_login = (Button) findViewById(R.id.back_login);
        back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Intent intent = new Intent(getApplicationContext(), certiActivity.class);
        switch (requestCode){
            case REQUEST_PERMISSION_LOCATION :
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    intent.putExtra("msg", "위치 권한 인증");
                    intent.putExtra("code", RESULT_CODE_OK);
                }
                else{
                    intent.putExtra("msg", "위치 권한 인증 실패");
                    intent.putExtra("code", RESULT_CODE_REJECT);
                }
                intent.putExtra("type", "위치 권한");
                startActivityForResult(intent, REQUEST_CODE_MENU);
                return ;
            case REQUEST_PERMISSION_CAMERA :
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    intent.putExtra("msg", "카메라 권한 인증");
                    intent.putExtra("code", RESULT_CODE_OK);
                }
                else{
                    intent.putExtra("msg", "카메라 권한 인증 실패");
                    intent.putExtra("code", RESULT_CODE_REJECT);
                }
                intent.putExtra("type", "카메라 권한");
                startActivityForResult(intent, REQUEST_CODE_MENU);
                return ;
            case REQUEST_PERMISSION_CALENDAR :
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    intent.putExtra("msg", "달력 권한 인증");
                    intent.putExtra("code", RESULT_CODE_OK);
                }
                else{
                    intent.putExtra("msg", "달력 권한 인증 실패");
                    intent.putExtra("code", RESULT_CODE_REJECT);
                }
                intent.putExtra("type", "달력 권한");
                startActivityForResult(intent, REQUEST_CODE_MENU);
                return ;
            default:
                return ;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_MENU){
                if(data != null){
                    Toast.makeText(getApplicationContext(), data.getStringExtra("msg"), Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
