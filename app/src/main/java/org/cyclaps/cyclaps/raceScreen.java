package org.cyclaps.cyclaps;

import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class raceScreen extends AppCompatActivity {


    private WebView wv;
    private BottomNavigationMenu bnm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_screen);


        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener(myNavigationItemListener);
        bottomNavigationView.setSelectedItemId(R.id.navigation_race);


        getSupportActionBar().hide();


        wv = (WebView) findViewById(R.id.mwebView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("http://mobilehci.s3-website.eu-west-2.amazonaws.com/race.html");
    }



}
