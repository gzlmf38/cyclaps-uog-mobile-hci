package org.cyclaps.cyclaps;

import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class leaderboardScreen extends AppCompatActivity {


    private WebView wv;
    private BottomNavigationMenu bnm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_screen);


        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener(myNavigationItemListener);
        bottomNavigationView.setSelectedItemId(R.id.navigation_leaderboard);


        getSupportActionBar().hide();


        wv = (WebView) findViewById(R.id.mwebView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://mobilehci.s3-website.eu-west-2.amazonaws.com/leaderboard.html");
    }

}
