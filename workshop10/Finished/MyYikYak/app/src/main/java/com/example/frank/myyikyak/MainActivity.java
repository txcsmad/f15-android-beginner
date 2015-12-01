package com.example.frank.myyikyak;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    ArrayList<String> data;
    ListView feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();

        //TODO findViewByID
        feed = (ListView)findViewById(R.id.feed);

       //TODO create and set adapter
        adapter = new ArrayAdapter<String>(this, R.layout.list_item,R.id.post_text, data);
        feed.setAdapter(adapter);

        refresh();
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
        //TODO handle menu clicks
        if (id == R.id.compose) {
            Intent i = new Intent(getApplicationContext(),ComposeActivity.class);
            startActivity(i, ActivityOptions.makeCustomAnimation(this, R.anim.fade_in, R.anim.nothing).toBundle());
        }

        if(id == R.id.refresh){
            refresh();
        }

        return super.onOptionsItemSelected(item);
    }

    private void refresh() {
        //TODO Make this do stuff
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
        query.orderByDescending("createdAt");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {
                    data.clear();
                    for(ParseObject p: objects){
                        String s = p.getString("content");
                        if(s != null)
                            data.add(s);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(), "Nothing Retrieved",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
