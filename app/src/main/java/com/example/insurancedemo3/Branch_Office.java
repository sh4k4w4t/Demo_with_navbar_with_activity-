package com.example.insurancedemo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Branch_Office extends AppCompatActivity {

    WebView webView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.branch_office);

        String branch_office_url=getResources().getString(R.string.branch_details_url);

        drawerLayout=(DrawerLayout) findViewById(R.id.drawerLayoutID);
        webView=(WebView) findViewById(R.id.webview_id);
        webView.loadUrl(branch_office_url);

        // Enable Javascript
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        webView.setWebViewClient(new WebViewClient());
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

    public void ClickHome(View view){ redirectActivity(Branch_Office.this,HomePage.class); }

    public void ClickPremiumCalculator(View view){ redirectActivity(Branch_Office.this,Premium_Calculator.class);}

    public void ClickBranchOffice(View view){ recreate();}

    public void ClickWebsite(View view){
        redirectActivity(Branch_Office.this,Website.class);
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
}