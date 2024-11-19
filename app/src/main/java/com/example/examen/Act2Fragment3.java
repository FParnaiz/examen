package com.example.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

public class Act2Fragment3 extends Fragment {
    public Act2Fragment3 () {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.act2_fragment3, container, false);

        // Initialize the views

        SeekBar seekBarRed = view.findViewById(R.id.act2_frg3_red);
        SeekBar seekBarGreen = view.findViewById(R.id.act2_frg3_green);
        SeekBar seekBarBlue = view.findViewById(R.id.sact2_frg3_blue);
        return view;
    }
}
