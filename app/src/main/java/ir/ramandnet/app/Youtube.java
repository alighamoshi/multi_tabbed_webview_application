package ir.ramandnet.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Youtube extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        webView= (WebView) findViewById(R.id.yt_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://google.com");
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);


        BottomNavigationView bottomNavigationView =findViewById(R.id.bottom_youtube);
        bottomNavigationView.setSelectedItemId(R.id.yt);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.yt:
                        return true;
                    case R.id.fb:
                        startActivity(new Intent(getApplication(),Facebook.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.twitter:
                        startActivity(new Intent(getApplication(),Twitter.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.services:
                        startActivity(new Intent(getApplication(),services.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();

        }else {


            super.onBackPressed();
        }
        }

    }
