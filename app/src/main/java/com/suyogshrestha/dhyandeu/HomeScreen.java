package com.suyogshrestha.dhyandeu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;


public class HomeScreen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Toolbar toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        CardView addtimer = findViewById(R.id.addTaskID);
        addtimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,Timer.class);
                startActivity(intent);
            }
        });


        CardView tasklist = findViewById(R.id.ListTaskID);
        tasklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,TaskList.class);
                startActivity(intent);
            }
        });

        CardView taskprogress = findViewById(R.id.ListProgress);
        taskprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,GraphGeneration.class);
                startActivity(intent);
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.settings:
                Intent settings = new Intent(this,SettingsActivity.class);
                startActivity(settings);
                break;
            case R.id.contact:
                Toast.makeText(getApplicationContext(),"Contact N/A",Toast.LENGTH_LONG).show();
                break;
            case R.id.about:
                Toast.makeText(getApplicationContext(),"About us",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}