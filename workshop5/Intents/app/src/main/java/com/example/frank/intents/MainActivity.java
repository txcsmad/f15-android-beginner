package com.example.frank.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button javaSubmitButton;
    private EditText javaEditText;
    private View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find XML UI elements and reference them with java variables
        javaEditText = (EditText) findViewById(R.id.edit_text);
        javaSubmitButton = (Button) findViewById(R.id.submit_button);

        //Creating and setting the onClickListener in java, the compiler does the same thing with android:onClick in XML
        listener = new View.OnClickListener() {
            //needs an onClickListener
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), OtherActivity.class);

                //The intent allows you to add more info as a key value pair
                i.putExtra("data", javaEditText.getText().toString());

                //startActivity with the intent we made
                startActivity(i);
            }
        };
        javaSubmitButton.setOnClickListener(listener);
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
