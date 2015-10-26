package com.example.kieran.fragmentlesson;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private ListView listView;
    private ArrayList<String> planets;
    private ArrayAdapter<String> adapter;
    private DrawerClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        listView = (ListView) findViewById(R.id.drawer_list_view);

        String[] temp = getResources().getStringArray(R.array.planets_array);
        planets = new ArrayList<>(Arrays.asList(temp));

        adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.drawer_list_item, R.id.list_item_text, planets);
        listView.setAdapter(adapter);

        listener = new DrawerClickListener();
        listView.setOnItemClickListener(listener);
    }

    public class DrawerClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //TODO Do Fun things with Fragments
            Toast.makeText(getApplicationContext(), planets.get(position), Toast.LENGTH_LONG).show();
            drawerLayout.closeDrawer(listView);
        }
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
