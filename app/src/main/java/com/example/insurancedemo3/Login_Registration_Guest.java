package com.example.insurancedemo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.insurancedemo3.log_regi_guest.Guest_verification;

public class Login_Registration_Guest extends AppCompatActivity implements View.OnClickListener {

    Button login_btn,guest_btn;
    EditText user_id,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_registration_guest);

        login_btn=(Button) findViewById(R.id.button_login);
        guest_btn=(Button) findViewById(R.id.button_guest);
        user_id=(EditText) findViewById(R.id.userID);
        password=(EditText) findViewById(R.id.password);

        login_btn.setOnClickListener(this);
        guest_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userID_s =user_id.getText().toString();
        String password_S =password.getText().toString();

        if (userID_s.equals("bengal") && password_S.equals("b123")){
            Intent intent= new Intent(Login_Registration_Guest.this,HomePage.class);
            startActivity(intent);
        }

        if (v.getId()==R.id.button_guest){
            Intent intent= new Intent(Login_Registration_Guest.this, Guest_verification.class);
            startActivity(intent);
        }

    }
}