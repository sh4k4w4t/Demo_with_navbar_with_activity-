package com.example.insurancedemo3.log_regi_guest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.insurancedemo3.Login_Registration_Guest;
import com.example.insurancedemo3.R;

public class Guest_verification extends AppCompatActivity implements View.OnClickListener {

    Button guestNumberSubmit_btn, backLoginPage_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.guest_verification);

        guestNumberSubmit_btn=(Button) findViewById(R.id.guest_button_login);
        backLoginPage_btn=(Button) findViewById(R.id.guest_button_Back_to_login_page);

        guestNumberSubmit_btn.setOnClickListener(this);
        backLoginPage_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.guest_button_Back_to_login_page){
            Intent intent=new Intent(Guest_verification.this, Login_Registration_Guest.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.guest_button_login){
            Intent intent=new Intent(Guest_verification.this,OTP_verification.class);
            startActivity(intent);
        }
    }
}