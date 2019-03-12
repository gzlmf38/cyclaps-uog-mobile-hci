package org.cyclaps.cyclaps;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class leaderboardScreen extends AppCompatActivity {


    private WebView wv;
    private BottomNavigationMenu bnm;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_screen);


        //BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        //bottomNavigationView.setOnNavigationItemSelectedListener(myNavigationItemListener);
        bottomNavigationView.setSelectedItemId(R.id.navigation_leaderboard);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        getSupportActionBar().hide();


        wv = (WebView) findViewById(R.id.mwebView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://mobilehci.s3-website.eu-west-2.amazonaws.com/leaderboard.html");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    bottomNavigationView.getMenu().getItem(0).setChecked(true);
                    startActivity(new Intent(leaderboardScreen.this, homeScreen.class));
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_race:
                    //mTextMessage.setText("Race");
                    bottomNavigationView.getMenu().getItem(1).setChecked(true);
                    startActivity(new Intent(leaderboardScreen.this, raceScreen.class));
                    return true;
                case R.id.navigation_hunt:
                    // mTextMessage.setText("Hunt");
                    return true;
                case R.id.navigation_leaderboard:
                    // mTextMessage.setText("Leaderboard");
                    bottomNavigationView.getMenu().getItem(3).setChecked(true);
                    startActivity(new Intent(leaderboardScreen.this, leaderboardScreen.class));
                    return true;

            }
            return false;
        }
    };

}
