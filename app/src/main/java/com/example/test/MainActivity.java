package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MotionEvent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.test.fragment.MainFragment;

public class MainActivity extends AppCompatActivity  implements View.OnTouchListener{
    private MainFragment mainFragment;

    private FrameLayout conteiner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        conteiner = findViewById(R.id.fragment_container);
        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(conteiner.getId(), mainFragment).commit();

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int color = v.getDrawingCache(true).getPixel((int) event.getX(), (int) event.getY());
//if (color!="#301E10")

        Log.println(Log.DEBUG, "??????", color + "");
        return true;
    }
}