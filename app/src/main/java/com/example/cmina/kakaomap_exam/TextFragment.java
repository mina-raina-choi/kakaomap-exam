package com.example.cmina.kakaomap_exam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {
    TextView text, vers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment, container, false);
        text = (TextView) view.findViewById(R.id.textView);
        vers = (TextView) view.findViewById(R.id.textView2);
        
        return  view;
    }

    public void change(String txt, String txt1) {
        text.setText(txt);
        vers.setText(txt1);
    }
}
