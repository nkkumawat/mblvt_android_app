package com.example.sonu.mbltrust;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.phoneNumber;

public class todayThought extends Activity {

    TextView thought_text ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_thought);
        thought_text = (TextView)findViewById(R.id.thought_text);
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
        new dataFetching(this , thought_text).execute();
    }
}
