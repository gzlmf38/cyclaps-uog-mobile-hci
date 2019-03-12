package org.cyclaps.cyclaps;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homeScreen extends AppCompatActivity {

    private BottomNavigationView navigation = null;

    private TextView mTextMessage;

    private Button bt_setting;

    private Button btn_history;

    private Button btn_collection;

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
                    navigation.getMenu().getItem(3).setChecked(true);
                    startActivity(new Intent(homeScreen.this, leaderboardScreen.class));
                    return true;

            }
            return false;
        }
    };

    private class myOnClickListener implements View.OnClickListener{

        private String flag = null;

        private myOnClickListener(String name){
            this.flag = name;
        }
        @Override
        public void onClick(View v) {
            if(this.flag=="setting"){
                startActivity(new Intent(homeScreen.this, setting.class));
            }
            else if(this.flag=="history"){
                startActivity(new Intent(homeScreen.this, history.class));
            }
            else if(this.flag=="collection"){
                startActivity(new Intent(homeScreen.this, collection.class));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getSupportActionBar().hide();
        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bt_setting = (Button) findViewById(R.id.btn_setting);
        bt_setting.setOnClickListener(new myOnClickListener("setting"));
        btn_history = (Button) findViewById(R.id.btn_history);
        btn_history.setOnClickListener(new myOnClickListener("history"));
        btn_collection = (Button) findViewById(R.id.btn_collection);
        btn_collection.setOnClickListener(new myOnClickListener("collection"));
    }
}
