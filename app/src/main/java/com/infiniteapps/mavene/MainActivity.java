package com.infiniteapps.mavene;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
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



    }



}
