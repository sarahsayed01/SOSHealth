package com.example.sara.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
   // WebViewClient myclientview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      mWebView=(WebView)findViewById(R.id.webveiwform);
        MyWebViewClient mm=new MyWebViewClient();
       mWebView.setWebViewClient(mm);
        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.loadUrl("http://192.168.1.234:8080/HealthTrack/");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.User) {
            mWebView.loadUrl("http://192.168.1.234:8080/HealthTrack/");
            return true;
        }
        if (id == R.id.Admin) {
            mWebView.loadUrl("http://192.168.1.234:8080/HealthTrack/admin/login/");
            return true;
        }
       if (id == R.id.Emergency) {
           mWebView.loadUrl("http://192.168.1.234:8080/HealthTrack/Emergency/");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

 class MyWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().equals("www.example.com")) {
            // This is my web site, so do not override; let my WebView load the page
            return true;
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs

        return false;
    }
}
