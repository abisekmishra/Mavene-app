package com.infiniteapps.mavene;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    TextView textView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.helloText);
        Intent intent =  this.getIntent();
        if(intent.getStringExtra("EXTRA_MESSAGE") == null) {
            textView.setText("You clicked " + intent.getStringExtra("ITEM_POSITION") + " at " + intent.getStringExtra("ITEM_NAME"));
        }else{
            textView.setText(intent.getStringExtra("EXTRA_MESSAGE"));
        }

    }
}
