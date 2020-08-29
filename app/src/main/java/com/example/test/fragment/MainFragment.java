package com.example.test.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainFragment extends Fragment implements View.OnTouchListener {

    private ImageButton menu, pause, normal, accelerated, shop;
    private TextView date;
    View view;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        initFragment();

        return view;
    }

    private void initFragment() {
        menu = view.findViewById(R.id.bnt_menu);
        pause = view.findViewById(R.id.bnt_pause);
        normal = view.findViewById(R.id.bnt_normal);
        accelerated = view.findViewById(R.id.bnt_accelerated);
        shop = view.findViewById(R.id.bnt_shop);
        date = view.findViewById(R.id.date);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        date.setText(format.format(new Date()));
        setListeners();
    }

    private void buttonLogic(int id) {
        final int bntNumber = id;
        DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (bntNumber) {
                    case 1:
                        menu.setImageResource(R.mipmap.tb_ic_menu_foreground);
                        break;
                    case 2:
                        shop.setImageResource(R.mipmap.tb_ic_shop_foreground);
                        break;
                    case 3:
                        pause.setImageResource(R.mipmap.tb_ic_pause_foreground);
                        break;
                    case 4:
                        normal.setImageResource(R.mipmap.tb_ic_normal_foreground);
                        break;
                    case 5:
                        accelerated.setImageResource(R.mipmap.tb_ic_accelerated_foreground);
                        break;
                }

            }
        };
        AlertDialog.Builder dialog = new AlertDialog.Builder(view.getContext());
        dialog.setMessage(id + "");
        dialog.setPositiveButton("Ok", myClickListener);
        dialog.create();
        dialog.show();


    }

    private void setListeners() {
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.setImageResource(R.mipmap.tb_ic_menu_clicked_foreground);
                buttonLogic(1);
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop.setImageResource(R.mipmap.tb_ic_shop_clicked_foreground);
                buttonLogic(2);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause.setImageResource(R.mipmap.tb_ic_pause_clicked_foreground);
                buttonLogic(3);
            }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.println(Log.DEBUG, "??????", "|");
                normal.setImageResource(R.mipmap.tb_ic_normal_clicked_foreground);
                buttonLogic(4);
            }
        });
        accelerated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.println(Log.DEBUG, "??????", "|");
                accelerated.setImageResource(R.mipmap.tb_ic_accelerated_clicked_foreground);
                buttonLogic(5);
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int color = v.getDrawingCache(true).getPixel((int) event.getX(), (int) event.getY());
//if (color!="#301E10")
        Log.println(Log.DEBUG, "??????", color + "");
        return true;
    }
}
