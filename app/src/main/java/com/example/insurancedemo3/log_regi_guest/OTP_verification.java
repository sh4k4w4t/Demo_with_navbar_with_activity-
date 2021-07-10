package com.example.insurancedemo3.log_regi_guest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.insurancedemo3.HomePage;
import com.example.insurancedemo3.R;

public class OTP_verification extends AppCompatActivity implements View.OnClickListener {

    Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.otp_verification);

        submit_button=(Button) findViewById(R.id.otp_submit_button);
        submit_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.otp_submit_button){
            Intent intent=new Intent(OTP_verification.this, HomePage.class);
            startActivity(intent);
        }
    }
}