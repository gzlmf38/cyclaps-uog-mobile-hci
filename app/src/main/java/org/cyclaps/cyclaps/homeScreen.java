package org.cyclaps.cyclaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class homeScreen extends AppCompatActivity {

    private BottomNavigationView navigation = null;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    navigation.getMenu().getItem(0).setChecked(true);
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_race:
                    mTextMessage.setText("Race");
                    navigation.getMenu().getItem(1).setChecked(true);
                    startActivity(new Intent(homeScreen.this, raceScreen.class));
                    return true;
                case R.id.navigation_hunt:
                    mTextMessage.setText("Hunt");
                    return true;
                case R.id.navigation_leaderboard:
                    mTextMessage.setText("Leaderboard");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

}
