package com.example.frank.counter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // declare variables so that we can interact with the  UI elements we declared in XML
    TextView numberText;
    int count;

//     "Called when the activity is first created. This is where you should do all of your normal static set up: create views,
//     bind data to lists, etc. This method also provides you with a Bundle containing the activity's previously frozen state,
//     if there was one." -from developer.android.com

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting the variables we declared so they reference the correct UI elements
        // Note: the "findViewById" method returns a View, but our variables were declared as subclasses
        // of the "View" class (TextView, and Button) so we need to cast them
        numberText = (TextView) findViewById(R.id.numberText);
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

    // When the user clicks the button, Android will call the method with the name specified in android:onClick.
    // The "View v" passed into the method is a reference to the UI element that was clicked.
    public void incrementNumber(View v) {
        count++;
        // since we have a variable that references numberText, we can use TextView methods with the object
        // the + "" after count is so we can pass a string as a paramter into the setText method
        numberText.setText(count + "");
    }

    public void reset(View v) {
        // pretty much the same thing as the incrementNumber method, but it sets the count back to 0
        count = 0;
        numberText.setText(count + "");
    }
}
