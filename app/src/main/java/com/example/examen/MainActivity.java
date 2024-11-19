package com.example.examen;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private GestureDetectorCompat mDetector;
    private GestureDetectorCompat mDetector2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_custom);
        getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView tituloTextView = findViewById(R.id.titulo); //
        if (tituloTextView != null) {
            tituloTextView.setText("Puesta de sol");  // Set the desired text
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment1 = new Act1FragmentSol();
        fragmentTransaction.add(R.id.frameSol, fragment1);
        fragmentTransaction.commit();
        FrameLayout escenario=findViewById(R.id.frameSol);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
        escenario.setOnTouchListener((v,event)->{
            return mDetector.onTouchEvent(event);
        });

    }

    public void GoToAct1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void GoToAct2(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e){
            ImageView myImageView = findViewById(R.id.sol);
            FrameLayout container = findViewById(R.id.frameSol);
            /*
            *
            * */
            // Animate the ImageView to move down (translationY)
            ObjectAnimator moveDown = ObjectAnimator.ofFloat(myImageView, "translationY", 0f, 590f);
            moveDown.setDuration(3000); // Duration 1.5 seconds
            moveDown.setInterpolator(new LinearInterpolator()); // Optional: smooth movement
            moveDown.start();

            // Animate the background color change of the container
            // Step 2: Animate background color change
            ValueAnimator color1 = ValueAnimator.ofObject(new ArgbEvaluator(),
                    Color.parseColor("#1e7ac7"), Color.parseColor("#817d67"));
            color1.setDuration(50); // Duration for this transition

            ValueAnimator color2 = ValueAnimator.ofObject(new ArgbEvaluator(),
                    Color.parseColor("#817d67"), Color.parseColor("#eb8001"));
            color2.setDuration(50); // Duration for this transition

            ValueAnimator color3 = ValueAnimator.ofObject(new ArgbEvaluator(),
                    Color.parseColor("#eb8001"), Color.parseColor("#05192e"));
            color3.setDuration(100); // Duration for this transition

            // Update the container's background color during the animation
            color1.addUpdateListener(animation -> {
                int color = (int) animation.getAnimatedValue();
                container.setBackgroundColor(color);
            });

            color2.addUpdateListener(animation -> {
                int color = (int) animation.getAnimatedValue();
                container.setBackgroundColor(color);
            });

            color3.addUpdateListener(animation -> {
                int color = (int) animation.getAnimatedValue();
                container.setBackgroundColor(color);
            });

            // Step 3: Combine the color animations into an AnimatorSet to play them sequentially
            AnimatorSet colorSequence = new AnimatorSet();
            colorSequence.playSequentially(color1, color2, color3);
            colorSequence.setDuration(1500); // Total duration for all color transitions
            colorSequence.start();
            return true;
        }
    }
}