package com.example.insurancedemo3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class HomePage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    CardView individual_plan,payment_method,premium_calculator,download_form,claim_status,claim,policy_statement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.home_page);

        drawerLayout=(DrawerLayout) findViewById(R.id.drawerLayoutID);
        individual_plan=(CardView) findViewById(R.id.home_cardview_individual_plan_Id);
        payment_method=(CardView) findViewById(R.id.home_cardview_payment_method_id);
        premium_calculator=(CardView) findViewById(R.id.home_cardview_premium_calculator_id);
        claim=(CardView) findViewById(R.id.home_cardview_claim_id);
        claim_status=(CardView) findViewById(R.id.home_cardview_claim_status_id);
        policy_statement=(CardView) findViewById(R.id.home_cardview_policy_statement_id);
        download_form=(CardView) findViewById(R.id.home_cardview_download_form_id);

        premium_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.home_cardview_premium_calculator_id){
                    Intent intent=new Intent(HomePage.this,Premium_Calculator.class);
                    startActivity(intent);
                }
            }
        });

        payment_method.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.home_cardview_payment_method_id){
                    Intent intent=new Intent(HomePage.this,Payment.class);
                    startActivity(intent);
                }
            }
        });

        download_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.home_cardview_download_form_id){
                    Intent intent=new Intent(HomePage.this,Downlaod_form.class);
                    startActivity(intent);
                }
            }
        });
    }



    //nav item======================================================================================


    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) { drawerLayout.openDrawer(GravityCompat.START); }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        recreate();
    }

    public void ClickPremiumCalculator(View view){ redirectActivity(HomePage.this,Premium_Calculator.class); }

    public void ClickBranchOffice(View view){ redirectActivity(HomePage.this,Branch_Office.class); }

    public void ClickWebsite(View view){
        redirectActivity(HomePage.this,Website.class);
    }

    public void ClickMyPolicy(View view){}
    public void ClickHospital(View view){}
    public void ClickContact(View view){}

    public static void redirectActivity(Activity activity, Class aclass) {
        Intent intent=new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }

    // this section for backpressed alert box=======================================================
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }


    // End backpressed section for alert box========================================================
}