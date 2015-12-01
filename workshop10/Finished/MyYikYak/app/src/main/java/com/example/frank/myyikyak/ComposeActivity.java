package com.example.frank.myyikyak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;

public class ComposeActivity extends AppCompatActivity {

    EditText composeEditText;
    Button submitButton;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        //TODO findViewByID
        composeEditText = (EditText)findViewById(R.id.compose_text);
        submitButton = (Button)findViewById(R.id.submit_button);
        //TODO set the listener
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = composeEditText.getText().toString();
                ParseObject submission = new ParseObject("Post");
                composeEditText.setText("");
                submission.put("content", s);
                submission.saveInBackground();
                finish();
                overridePendingTransition(R.anim.nothing, R.anim.fade_out);
            }
        };
        submitButton.setOnClickListener(listener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.nothing, R.anim.fade_out);
    }
}
