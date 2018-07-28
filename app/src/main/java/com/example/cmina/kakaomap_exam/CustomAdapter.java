package com.example.cmina.kakaomap_exam;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<String> dataList;
    private ArrayList<String> versionList;
    Context context;

    int currPosition;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView androidOSTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.androidOSTextView = (TextView)itemView.findViewById(R.id.androidOS);
        }
    }


    public CustomAdapter(ArrayList<String> data, ArrayList<String> version, Context context) {
        this.dataList = data;
        this.versionList = version;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        view.setOnClickListener(MenuFragment.myOnclickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        TextView androidOSTextView = holder.androidOSTextView;
        androidOSTextView.setText(dataList.get(position));


        holder.androidOSTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("cardview onclick", "click" + position);
                currPosition = position;
            }
        });

        this.setItem(position);

        if(currPosition == position)
            androidOSTextView.setBackgroundColor(Color.parseColor("#567845"));
        else
            androidOSTextView.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    private void setItem(int position) {
        android.support.v4.app.FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();

        TextFragment textFragment = (TextFragment) fragmentManager.findFragmentById(R.id.textFragment);
        textFragment.change(dataList.get(position),"Version : "+versionList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
