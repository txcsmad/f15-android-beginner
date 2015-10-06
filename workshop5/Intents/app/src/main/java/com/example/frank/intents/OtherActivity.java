package com.example.frank.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//This is another activity just like our MainActivity, it extends AppCompatActivity
public class OtherActivity extends AppCompatActivity {

    //since this is a different java class, it has different class variables
    // and can't access class variables from the MainActivity
    private TextView javaTextView;
    private Button javaBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        javaTextView = (TextView) findViewById(R.id.text_view);
        javaBackButton = (Button) findViewById(R.id.back_button);

        //a method from the super class "AppCompatActivity", gets the intent that started this Activity
        Intent i = getIntent();

        //get the data from the intent that we passed in with the key string "data", then reference it
        String s = i.getStringExtra("data");

        //set the text for the TextView within other activity
        javaTextView.setText(s);

        // sets the onClickListener for the backButton, slightly different way of doing it, this is how the auto complete usually fills it in
        // the listener is constructed within the parentheses that the parameter is taken in for setOnClickListener
        javaBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backIntent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_other, menu);
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
