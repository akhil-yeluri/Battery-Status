package akhilyeluri.batterystatus;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Website extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        webView=(WebView)findViewById(R.id.web);
        SharedPreferences preferences=getApplicationContext().getSharedPreferences("IP_ADDRESS",0);
        String url="https://";
        url=url + preferences.getString("ip_address",null) +"/off";
        webView.getSettings().setJavaScriptEnabled(true);
        webView .setWebViewClient(new WebViewClient() {

                                         @Override
                                         public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                             return false;
                                         }
                                     }

        );
        webView.loadUrl(url);


    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
    }
}
