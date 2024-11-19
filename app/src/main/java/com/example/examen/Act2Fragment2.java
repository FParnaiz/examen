package com.example.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Act2Fragment2 extends Fragment {
    public Act2Fragment2 () {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.act2_fragment2, container, false);

        // Initialize the TextView using the view from the fragment's layout
        TextView textView = view.findViewById(R.id.act2_frg2_textView);

        // Optionally, you can change the text programmatically
        // textView.setText("Updated Text");

        // Return the inflated view
        return view;

    }
}
