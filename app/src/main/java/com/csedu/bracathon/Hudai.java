package com.csedu.bracathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Hudai extends AppCompatActivity {

    WebView myBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hudai);
        setTitle("জন্মের সাথে সাথে নবজাতকের যত্ন");
        myBrowser = (WebView)findViewById(R.id.my_html_browser);
        myBrowser.loadUrl("file:///android_asset/mypage.html")  ;
    }
}
