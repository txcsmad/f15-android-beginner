package com.example.kieran.fall2015_recyclerviews.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kieran.fall2015_recyclerviews.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /* Naming conventions:
    Class - capitalize the first letter of every word "ThisIsAClass"
    Object - camel case "thisIsAnObject"
    XML - separate words with underscores, all lowercase "this_is_an_xml_object"
    Constant - All caps separated with underscores "THIS_IS_A_CONSTANT"
     */

    private EditText javaEditText;
    private RecyclerView javaRecyclerView;

    private RecyclerListAdapter adapter;

    private ArrayList<String> listItemArrayList;
    private ArrayList<Boolean> checkedListItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItemArrayList = new ArrayList<>();
        checkedListItems = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            listItemArrayList.add(i + "");
            checkedListItems.add(false);
        }

        //reference all of the XML UI elements in java
        javaRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        javaEditText = (EditText) findViewById(R.id.edit_text);

        //create an adapter for the ListView
        adapter = new RecyclerListAdapter(listItemArrayList, checkedListItems);
        //"plug in" the adapter to the ListView
        javaRecyclerView.setAdapter(adapter);

        javaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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

    //called when the button is clicked
    public void addToList(View v) {
        //get the text from the EditText, but the getText() method returns an "Editable" object
        //so we call the instance method toString() to convert it into a data type we can work with
        String editTextString = javaEditText.getText().toString();
        //add the String that we just got the ArrayList that we have plugged into the ArrayAdapter
        listItemArrayList.add(editTextString);
        checkedListItems.add(false);
        //clear out the EditText again for future submissions
        javaEditText.setText("");
        //notify the adapter that the data set has changed so that we can update it with the new item we added
        adapter.notifyDataSetChanged();

        //have a Toast (remember this thing from workshop 1?) indicating the button has been clicked
        Toast t = Toast.makeText(getApplicationContext(), "new item added", Toast.LENGTH_SHORT);
        t.show();
    }

    public void checkItem(View v){
        v.getId();
    }
}