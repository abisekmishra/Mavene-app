package com.infiniteapps.mavene;

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
        textView.setText("You clicked "+getIntent().getStringExtra("ITEM_POSITION")+" at "+getIntent().getStringExtra("ITEM_NAME"));

    }
}
