package com.example.examen;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Act2Fragment1 extends Fragment {
    public Act2Fragment1 () {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.act2_fragment1, container, false);

        // Initialize the views
        EditText editText = view.findViewById(R.id.act2_frg1_editText);
        SeekBar seekBar = view.findViewById(R.id.act2_frg1_seekbar_size);
        return view;
    }

}
