package com.example.kieran.utschedule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView volleyText;
    private ImageView volleyImage;
    private TextView footballText;
    private ImageView footballImage;

    private ArrayList<String> volleySchedule;
    private ArrayList<String> footballSchedule;

    private View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volleyText = (TextView) findViewById(R.id.volleyball_text);
        volleyImage = (ImageView) findViewById(R.id.volleyball_image);
        footballText = (TextView) findViewById(R.id.football_text);
        footballImage = (ImageView) findViewById(R.id.football_image);

        volleySchedule = new ArrayList<>();
        footballSchedule = new ArrayList<>();

        volleySchedule.add("W 3-0 vs. TCU");
        volleySchedule.add("W 3-0 at West Virginia");
        volleySchedule.add("W 3-0 vs. Iowa State");
        volleySchedule.add("W 3-0 at Baylor");
        volleySchedule.add("W 3-1 vs. Oklahoma");
        volleySchedule.add("10/17 vs. Texas Tech");
        volleySchedule.add("10/21 at Kansas State");
        volleySchedule.add("10/23 vs. Kansas");

        footballSchedule.add("L 3-38 at Notre Dame");
        footballSchedule.add("W 42-28 vs. Rice");
        footballSchedule.add("L 44-45 vs. Cal");
        footballSchedule.add("L 27-30 vs. OSU");
        footballSchedule.add("L 7-50 at TCU");
        footballSchedule.add("W 24-17 vs. Oklahoma");
        footballSchedule.add("10/24 vs. Kansas State");
        footballSchedule.add("10/31 at Iowa State");
        footballSchedule.add("11/7 vs. Kansas");
        footballSchedule.add("11/14 at West Virginia");
        footballSchedule.add("11/26 vs. Texas Tech");
        footballSchedule.add("12/5 at Baylor");

        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ScheduleActivity.class);
                if(v.getId() == R.id.volleyball_text){
                    i.putStringArrayListExtra("data", volleySchedule);
                } else {
                    i.putStringArrayListExtra("data", footballSchedule);
                }
                startActivity(i);
            }
        };

        volleyText.setOnClickListener(listener);
        footballText.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
