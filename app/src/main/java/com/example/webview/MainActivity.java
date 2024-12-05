package com.example.webview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;

/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity {
    WebView view;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=findViewById(R.id.web);
        progressBar=findViewById(R.id.progress);
        view.loadUrl("https://www.google.com");
        view.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(view.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(view.GONE);
                super.onPageFinished(view, url);
            }
        });





    }

    @Override
    public void onBackPressed() {
        if(view.canGoBack())
        {
            view.goBack();
        }
        else
        {
            super.onBackPressed();
        }


    }
}