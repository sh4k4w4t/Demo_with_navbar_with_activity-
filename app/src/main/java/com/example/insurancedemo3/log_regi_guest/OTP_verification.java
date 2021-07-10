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

import com.example.insurancedemo3.HomePage;
import com.example.insurancedemo3.Login_Registration_Guest;
import com.example.insurancedemo3.R;

public class OTP_verification extends AppCompatActivity implements View.OnClickListener {

    EditText otp;
    Button submit_otp;
    TextView number_change_or_otp_resend, go_back_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.otp_verification);

        otp=(EditText) findViewById(R.id.otp_id);
        submit_otp= (Button) findViewById(R.id.otp_submit_button);
        number_change_or_otp_resend=(TextView) findViewById(R.id.otp_to_go_back_guest_verification_page);
        go_back_login=(TextView) findViewById(R.id.otp_to_go_back_login_page);

        submit_otp.setOnClickListener(this);
        number_change_or_otp_resend.setOnClickListener(this);
        go_back_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.otp_submit_button){
            Intent intent=new Intent(OTP_verification.this, HomePage.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.otp_to_go_back_guest_verification_page){
            Intent intent=new Intent(OTP_verification.this, Guest_verification.class);
            startActivity(intent);
        }
        if (v.getId()==R.id.otp_to_go_back_login_page){
            Intent intent=new Intent(OTP_verification.this, Login_Registration_Guest.class);
            startActivity(intent);
        }
    }
}