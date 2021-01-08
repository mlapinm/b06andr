package com.example.b601201frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LittleFragment extends Fragment {
    private String text;
    private int number;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.little_fragment, container, false);
        TextView textView = v.findViewById(R.id.textView);

        if(getArguments() != null){
            text = getArguments().getString("argText");
            number = getArguments().getInt("argNumber");
        }

        textView.setText(text + " : " + number);
        return v;
    }
}
