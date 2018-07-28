package com.example.cmina.kakaomap_exam;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuFragment extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;

    static View.OnClickListener myOnclickListener;

    static String[] AndroidOS = new String[] { "Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb","Ice Cream SandWich","Jelly Bean","KitKat" };
    static String[] Version = new String[ ] {"1.5","1.6","2.0-2.1","2.2","2.3","3.0-3.2","4.0","4.1-4.3","4.4"};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View menuVeiw = inflater.inflate(R.layout.menu_fragment, container,false);

//        myOnclickListener = new MyOnClickListener(this.getActivity());

        recyclerView = (RecyclerView) menuVeiw.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new CustomAdapter(new ArrayList<String>(Arrays.asList(AndroidOS)),
                new ArrayList<String>(Arrays.asList(Version)), this.getActivity());
        recyclerView.setAdapter(adapter);

        return menuVeiw;
    }

    private class MyOnClickListener implements View.OnClickListener {
        private final Context context;

        private  MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            Log.i("myonclick", "click");
            this.setItem(view);
        }

        private void setItem(View view) {
            int selectedPosition = recyclerView.getChildAdapterPosition(view);

            TextFragment textFragment = (TextFragment) getFragmentManager().findFragmentById(R.id.textFragment);
            textFragment.change(AndroidOS[selectedPosition],"Version : "+Version[selectedPosition]);
        }
    }
}
