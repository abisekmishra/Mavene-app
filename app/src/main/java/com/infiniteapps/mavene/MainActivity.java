package com.infiniteapps.mavene;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    int numberOfItems;
    int numberOfViewHolders;
    ItemListerner listerner;

    public interface ItemListerner{
        void onClick(int position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView top;
        TextView bottom;

        public MyViewHolder(View itemView) {
            super(itemView);

            top = (TextView)itemView.findViewById(R.id.textViewTop);
            bottom = (TextView)itemView.findViewById(R.id.textViewBelow);

            itemView.setOnClickListener(this);
        }

        public void bind(int position){
            top.setText(String.valueOf(position));
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listerner.onClick(position);
        }
    }

    public MyAdapter(int numberOfItems,ItemListerner listerner) {
        this.numberOfItems = numberOfItems;
        this.numberOfViewHolders =0;
        this.listerner = listerner;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        viewHolder.bottom.setText(String.valueOf(numberOfViewHolders));
        viewHolder.itemView.setBackgroundColor(ColorUtils.getViewHolderBackgroundColorFromInstance(parent.getContext(),numberOfViewHolders));
        numberOfViewHolders++;

        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberOfItems;
    }

}

public class MainActivity extends AppCompatActivity {

    public static final int NUMBER_OF_ITEMS = 100;

    private View secondView;
    private TextView expFabText;
    private TextView splitFabText;

    private FloatingActionButton addFab;
    private FloatingActionButton expFab;
    private FloatingActionButton splitFab;

    private boolean isCLicked = false;

    private Animation scaleup;
    private Animation scaledown;
    private Animation rotateClock;
    private  Animation rotateAclock;
    private Animation fadeIn;
    private  Animation fadeout;

    private RecyclerView listView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondView = this.findViewById(R.id.secondView);
        expFabText = this.findViewById(R.id.expFabText);
        splitFabText = this.findViewById(R.id.splitFabText);
        addFab = this.findViewById(R.id.addFab);
        listView = this.findViewById(R.id.recycleView);
        expFab = findViewById(R.id.expFab);
        splitFab = findViewById(R.id.splitFab);

        scaleup = AnimationUtils.loadAnimation(this,R.anim.scaleup);
        scaledown = AnimationUtils.loadAnimation(this,R.anim.scaledown);
        rotateClock = AnimationUtils.loadAnimation(this,R.anim.rotateclock);
        rotateAclock = AnimationUtils.loadAnimation(this,R.anim.rotateaclock);
        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fadein);
        fadeout = AnimationUtils.loadAnimation(this,R.anim.fadeout);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        MyAdapter.ItemListerner listener = new MyAdapter.ItemListerner() {
            @Override
            public void onClick(int position) {
                Toast mToast = null;
                if(mToast != null)
                    mToast.cancel();
                mToast = Toast.makeText(getApplicationContext(),"Clicked on " + String.valueOf(position),Toast.LENGTH_LONG);
                mToast.show();
            }
        };


        adapter = new MyAdapter(NUMBER_OF_ITEMS,listener);
        listView.setLayoutManager(layoutManager);
        listView.setHasFixedSize(true);
        listView.setAdapter(adapter);


        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();

            }
        });

        secondView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCLicked)
                    animateFab();
            }
        });
    }

    void animateFab(){
        if(isCLicked){

            addFab.startAnimation(rotateAclock);
            secondView.startAnimation(fadeout);
            expFab.startAnimation(scaledown);
            splitFab.startAnimation(scaledown);
            expFabText.startAnimation(scaledown);
            splitFabText.startAnimation(scaledown);

            isCLicked = false;
            expFab.setClickable(false);
            splitFab.setClickable(false);
            secondView.setClickable(false);


        }else{

            addFab.startAnimation(rotateClock);
            secondView.startAnimation(fadeIn);
            expFab.startAnimation(scaleup);
            splitFab.startAnimation(scaleup);
            expFabText.startAnimation(scaleup);
            splitFabText.startAnimation(scaleup);

            isCLicked = true;
            expFab.setClickable(true);
            splitFab.setClickable(true);
            secondView.setClickable(true);
        }
    }
}
