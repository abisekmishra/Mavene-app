package com.infiniteapps.mavene;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton addFab = null;
    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFab = this.findViewById(R.id.addFab);
        listView = this.findViewById(R.id.listView);

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),SecondActivity.class);
                intent.putExtra("EXTRA_MESSAGE","Hello this is your new page");
                startActivity(intent);

            }
        });

        ArrayList<String> nameList = new ArrayList<>();
        String[] strings = new String[]{"abc","fsf","fsfds","ffewew","sdgsg","adasd","fdsfds","fsdf","fsf","fsfsd","fsdf","fdsfdsf","sfdsf","fsfsdf","srewrwer","jghjg","jghjg","dsfsf",
                "jgj","ghjghj","rewrw","fsdfsdf","gfgf","dfdf","uyuyu",};
        for (String i:strings) {
            nameList.add(i);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,nameList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String itemName = adapterView.getItemAtPosition(position).toString();
                String itemPosition = Integer.toString(position);

                Intent intent = new Intent(view.getContext(),SecondActivity.class);
                intent.putExtra("ITEM_NAME",itemName);
                intent.putExtra("ITEM_POSITION",itemPosition);
                startActivity(intent);
            }
        });

    }



}
