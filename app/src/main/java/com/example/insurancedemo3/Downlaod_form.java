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

public class Downlaod_form extends AppCompatActivity {

    WebView webView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.downlaod_form);

        String download_form_url=getResources().getString(R.string.download_form_url);

        drawerLayout=(DrawerLayout) findViewById(R.id.drawerLayoutID);
        webView=(WebView) findViewById(R.id.webview_id);

        webView.loadUrl(download_form_url);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
    }

    //nav item======================================================================================

    public void ClickMenu(View view){ openDrawer(drawerLayout); }

    public static void openDrawer(DrawerLayout drawerLayout) { drawerLayout.openDrawer(GravityCompat.START);}

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){ redirectActivity(Downlaod_form.this,HomePage.class); }

    public void ClickPremiumCalculator(View view){ redirectActivity(Downlaod_form.this,Premium_Calculator.class);}

    public void ClickBranchOffice(View view){ redirectActivity(Downlaod_form.this,Branch_Office.class);}

    public void ClickWebsite(View view){ redirectActivity(Downlaod_form.this,Website.class); }

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