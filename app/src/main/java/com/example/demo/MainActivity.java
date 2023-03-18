package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

   private EditText editTextNumber,editTextmsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);
        editTextNumber=findViewById(R.id.Number);
        editTextmsg=findViewById(R.id.msg);




    }
    public void sendSms(View view) {
        String number = editTextNumber.getText().toString();
        String message = editTextmsg.getText().toString();


        SmsManager mysms = SmsManager.getDefault();
        mysms.sendTextMessage(number, null, message, null, null);


    }
}