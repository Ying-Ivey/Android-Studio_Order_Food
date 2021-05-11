package com.example.btquatrinh_lan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webViewThongTinTra extends AppCompatActivity {
    String urlInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_thong_tin_tra);
        getSupportActionBar().setTitle("Thông tin loại trà đã đặt");
        Intent intent = getIntent();
        urlInfo = intent.getStringExtra("UrlTra");
        WebView myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        myWebView.loadUrl(urlInfo);
        webSettings.setJavaScriptEnabled(true);

    }
}