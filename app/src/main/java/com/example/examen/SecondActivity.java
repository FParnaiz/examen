package com.example.examen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.second_activity);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_custom);
        getSupportActionBar().setElevation(0);
        TextView tituloTextView = findViewById(R.id.titulo); //
        if (tituloTextView != null) {
            tituloTextView.setText("ExamFragmets");  // Set the desired text
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment1 = new Act2Fragment1();
        Fragment fragment2 = new Act2Fragment2();
        Fragment fragment3 = new Act2Fragment3();
        fragmentTransaction.add(R.id.frame1, fragment1);
        fragmentTransaction.add(R.id.frame2, fragment2);
        fragmentTransaction.add(R.id.frame3, fragment3);
        fragmentTransaction.commit();
    }
    public void GoToAct1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void GoToAct2(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
    public void ChangeColor(View view){
        /*
        * I have never used seekbar so i had to search hot to get the value of the seekbar
        * and go to define the min value and the max value.
        * Also i'm used to set color using hex code and becuse we are suing seekbar to set the color
        * in rgb i need to serach how to set the color using rgb code
        * */
        SeekBar seekBarRed = findViewById(R.id.act2_frg3_red);
        SeekBar seekBarGreen = findViewById(R.id.act2_frg3_green);
        SeekBar seekBarBlue = findViewById(R.id.sact2_frg3_blue);
        int red = seekBarRed.getProgress();
        int green = seekBarGreen.getProgress();
        int blue = seekBarBlue.getProgress();
        TextView textView  = findViewById(R.id.act2_frg2_textView);
        int color = Color.rgb(red, green, blue);
        textView.setTextColor(color);

    }
    public void ChangeText(View view){
        TextView textView  = findViewById(R.id.act2_frg2_textView);
        EditText editText = findViewById(R.id.act2_frg1_editText);
        SeekBar seekBar = findViewById(R.id.act2_frg1_seekbar_size);
        textView.setText(editText.getText().toString());
        textView.setTextSize(seekBar.getProgress());
    }
}
