package com.example.insurancedemo3.log_regi_guest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.insurancedemo3.Login_Registration_Guest;
import com.example.insurancedemo3.R;

public class Guest_verification extends AppCompatActivity implements View.OnClickListener {

    Button guest_mobile_number_submit_button;
    TextView guest_back_login_page;
    EditText guest_mobile_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.guest_verification);

        guest_mobile_number_submit_button=(Button) findViewById(R.id.guest_login);
        guest_back_login_page=(TextView) findViewById(R.id.guest_go_back_login_page);
        guest_mobile_number=(EditText) findViewById(R.id.guest_mobile_number);

        guest_mobile_number_submit_button.setOnClickListener(this);
        guest_back_login_page.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.guest_go_back_login_page){
            Intent intent=new Intent(Guest_verification.this, Login_Registration_Guest.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.guest_login){
            Intent intent=new Intent(Guest_verification.this,OTP_verification.class);
            startActivity(intent);
        }
    }
}