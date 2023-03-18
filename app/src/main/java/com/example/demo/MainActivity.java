package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText number,msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit=(Button)findViewById(R.id.submit);
        number=(EditText) findViewById(R.id.number);
        msg=(EditText)findViewById(R.id.msg);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=number.getText().toString();
                String msgText=msg.getText().toString();

                try {
                    // Construct data
                    String apiKey = "apikey=" + "NmQ2YTc5NjM0OTM0NDk2ODc1MzA1NjQ0Nzk0NTM5Mzc=";
                    String message = "&message=" +msgText;
                    String sender = "&sender=" + "TXTLCL";
                    String numbers = "&numbers=" +phone;

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        stringBuffer.append(line);
                    }
                    rd.close();


                } catch (Exception e) {
                    System.out.println("Error SMS "+e);

                }
            }
        });

    }
}