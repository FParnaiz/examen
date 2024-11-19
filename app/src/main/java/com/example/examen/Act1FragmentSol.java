package com.example.examen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

public class Act1FragmentSol extends Fragment {
    public Act1FragmentSol () {
        // Required empty public constructor
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.act1_fragmentsol, container, false);

        // Initialize the views
        ImageView imageView = view.findViewById(R.id.sol);
        return view;
    }
}
