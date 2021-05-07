package com.example.imagematch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Layout;
import android.text.Layout.Directions;
import android.util.LayoutDirection;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SelectedActivity extends Activity {

    TextView point;
    TextView time;
    LinearLayout lnimage;
    ArrayList<String> khoanh;
    ArrayList<String> anhsudung;
    int dem = 0;
    Object imvold = new Object();
    String a, b;
    ArrayList<ImageView> listimageview;
    int sohang;
    int socot;
    ImageButton btnpause;
    int REQUEST_CODE_PAUSE = 1;
    long t2, tim1 = 35000, tim2 = 45000, tim3 = 60000, tim4 = 75000, tim5 = 90000;
    int tong;
    double tong2;
    double tong3 = 0;
    int tong4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        setContentView(R.layout.activity_selected);

        point = (TextView) findViewById(R.id.textViewDiem);
        time = (TextView) findViewById(R.id.textViewThoiGian);
        lnimage = (LinearLayout) findViewById(R.id.linearLayout);
        btnpause = (ImageButton) findViewById(R.id.imageButton);

        final Intent intent1 = getIntent();
        if (intent1.getStringExtra("levelchon2").equals(getResources().getString(R.string.l1))) {
            sohang = 4;
            socot = 4;
            anhSuDung1();
            t2 = 35;
            tong = 16;
            tong2 = 8;
        }
        else if (intent1.getStringExtra("levelchon2").equals(getResources().getString(R.string.l2))) {
            sohang = 5;
            socot = 4;
            anhSuDung2();
            t2 = 45;
            tong = 20;
            tong2 = 10;
        }
        else if (intent1.getStringExtra("levelchon2").equals(getResources().getString(R.string.l3))) {
            sohang = 6;
            socot = 4;
            anhSuDung3();
            t2 = 60;
            tong = 24;
            tong2 = 12;
        }
        else if (intent1.getStringExtra("levelchon2").equals(getResources().getString(R.string.l4))) {
            sohang = 6;
            socot = 5;
            anhSuDung4();
            t2 = 75;
            tong = 30;
            tong2 = 15;
        }
        else if (intent1.getStringExtra("levelchon2").equals(getResources().getString(R.string.l5))) {
            sohang = 6;
            socot = 6;
            anhSuDung5();
            t2 = 90;
            tong = 36;
            tong2 = 18;
        }
        else {
            sohang = 4;
            socot = 4;
            anhSuDung1();
            t2 = 35;
            tong = 16;
            tong2 = 8;
        }
        drawView();
        setImage();

        setCountDownTimer();
        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishCountDownTimer();
                Intent intent = new Intent(SelectedActivity.this, PauseActivity.class);
                startActivityForResult(intent, REQUEST_CODE_PAUSE);
            }
        });
    }

    private void khoAnh() {
        String[] A = getResources().getStringArray(R.array.list_name);
        khoanh = new ArrayList<>(Arrays.asList(A));
    }

    private void anhSuDung1() {
        khoAnh();
        Random rd = new Random();
        int r = rd.nextInt(18);
        anhsudung = new ArrayList<>();
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        Collections.shuffle(anhsudung);
    }

    private void anhSuDung2() {
        khoAnh();
        Random rd = new Random();
        int r = rd.nextInt(18);
        anhsudung = new ArrayList<>();
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        anhsudung.add(khoanh.get(r+8));
        anhsudung.add(khoanh.get(r+9));
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        anhsudung.add(khoanh.get(r+8));
        anhsudung.add(khoanh.get(r+9));
        Collections.shuffle(anhsudung);
    }

    private void anhSuDung3() {
        khoAnh();
        Random rd = new Random();
        int r = rd.nextInt(18);
        anhsudung = new ArrayList<>();
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        anhsudung.add(khoanh.get(r+8));
        anhsudung.add(khoanh.get(r+9));
        anhsudung.add(khoanh.get(r+10));
        anhsudung.add(khoanh.get(r+11));
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        anhsudung.add(khoanh.get(r+8));
        anhsudung.add(khoanh.get(r+9));
        anhsudung.add(khoanh.get(r+10));
        anhsudung.add(khoanh.get(r+11));
        Collections.shuffle(anhsudung);
    }

    private void anhSuDung4() {
        khoAnh();
        Random rd = new Random();
        int r = rd.nextInt(18);
        anhsudung = new ArrayList<>();
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        anhsudung.add(khoanh.get(r+8));
        anhsudung.add(khoanh.get(r+9));
        anhsudung.add(khoanh.get(r+10));
        anhsudung.add(khoanh.get(r+11));
        anhsudung.add(khoanh.get(r+12));
        anhsudung.add(khoanh.get(r+13));
        anhsudung.add(khoanh.get(r+14));
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        anhsudung.add(khoanh.get(r+8));
        anhsudung.add(khoanh.get(r+9));
        anhsudung.add(khoanh.get(r+10));
        anhsudung.add(khoanh.get(r+11));
        anhsudung.add(khoanh.get(r+12));
        anhsudung.add(khoanh.get(r+13));
        anhsudung.add(khoanh.get(r+14));
        Collections.shuffle(anhsudung);
    }

    private void anhSuDung5() {
        khoAnh();
        Random rd = new Random();
        int r = rd.nextInt(18);
        anhsudung = new ArrayList<>();
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        anhsudung.add(khoanh.get(r+8));
        anhsudung.add(khoanh.get(r+9));
        anhsudung.add(khoanh.get(r+10));
        anhsudung.add(khoanh.get(r+11));
        anhsudung.add(khoanh.get(r+12));
        anhsudung.add(khoanh.get(r+13));
        anhsudung.add(khoanh.get(r+14));
        anhsudung.add(khoanh.get(r+15));
        anhsudung.add(khoanh.get(r+16));
        anhsudung.add(khoanh.get(r+17));
        anhsudung.add(khoanh.get(r));
        anhsudung.add(khoanh.get(r+1));
        anhsudung.add(khoanh.get(r+2));
        anhsudung.add(khoanh.get(r+3));
        anhsudung.add(khoanh.get(r+4));
        anhsudung.add(khoanh.get(r+5));
        anhsudung.add(khoanh.get(r+6));
        anhsudung.add(khoanh.get(r+7));
        anhsudung.add(khoanh.get(r+8));
        anhsudung.add(khoanh.get(r+9));
        anhsudung.add(khoanh.get(r+10));
        anhsudung.add(khoanh.get(r+11));
        anhsudung.add(khoanh.get(r+12));
        anhsudung.add(khoanh.get(r+13));
        anhsudung.add(khoanh.get(r+14));
        anhsudung.add(khoanh.get(r+15));
        anhsudung.add(khoanh.get(r+16));
        anhsudung.add(khoanh.get(r+17));
        Collections.shuffle(anhsudung);
    }

    private void drawView() {
        listimageview = new ArrayList<>();
        for (int i=1; i<=sohang; i++) {
            LinearLayout h = new LinearLayout(this);
            h.setOrientation(LinearLayout.HORIZONTAL);
            h.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1));
            h.setWeightSum(socot);
            for (int j=1; j<=socot; j++) {
                final ImageView imageView = new ImageView(this);
                Resources s = getResources();
                int px2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, s.getDisplayMetrics());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                layoutParams.setMargins(px2, px2, px2, px2);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(R.drawable.images);
                //final int vitri = socot * (i - 1) + j - 1;
                listimageview.add(imageView);
                h.addView(imageView);
            }
            lnimage.addView(h);
        }
    }

    private void batNut() {
        if (socot == 4 && sohang == 4) {
            listimageview.get(0).setEnabled(true);
            listimageview.get(1).setEnabled(true);
            listimageview.get(2).setEnabled(true);
            listimageview.get(3).setEnabled(true);
            listimageview.get(4).setEnabled(true);
            listimageview.get(5).setEnabled(true);
            listimageview.get(6).setEnabled(true);
            listimageview.get(7).setEnabled(true);
            listimageview.get(8).setEnabled(true);
            listimageview.get(9).setEnabled(true);
            listimageview.get(10).setEnabled(true);
            listimageview.get(11).setEnabled(true);
            listimageview.get(12).setEnabled(true);
            listimageview.get(13).setEnabled(true);
            listimageview.get(14).setEnabled(true);
            listimageview.get(15).setEnabled(true);
        }
        else if (sohang == 5 && socot == 4) {
            listimageview.get(0).setEnabled(true);
            listimageview.get(1).setEnabled(true);
            listimageview.get(2).setEnabled(true);
            listimageview.get(3).setEnabled(true);
            listimageview.get(4).setEnabled(true);
            listimageview.get(5).setEnabled(true);
            listimageview.get(6).setEnabled(true);
            listimageview.get(7).setEnabled(true);
            listimageview.get(8).setEnabled(true);
            listimageview.get(9).setEnabled(true);
            listimageview.get(10).setEnabled(true);
            listimageview.get(11).setEnabled(true);
            listimageview.get(12).setEnabled(true);
            listimageview.get(13).setEnabled(true);
            listimageview.get(14).setEnabled(true);
            listimageview.get(15).setEnabled(true);
            listimageview.get(16).setEnabled(true);
            listimageview.get(17).setEnabled(true);
            listimageview.get(18).setEnabled(true);
            listimageview.get(19).setEnabled(true);
        }
        else if (socot == 4 && sohang == 6) {
            listimageview.get(0).setEnabled(true);
            listimageview.get(1).setEnabled(true);
            listimageview.get(2).setEnabled(true);
            listimageview.get(3).setEnabled(true);
            listimageview.get(4).setEnabled(true);
            listimageview.get(5).setEnabled(true);
            listimageview.get(6).setEnabled(true);
            listimageview.get(7).setEnabled(true);
            listimageview.get(8).setEnabled(true);
            listimageview.get(9).setEnabled(true);
            listimageview.get(10).setEnabled(true);
            listimageview.get(11).setEnabled(true);
            listimageview.get(12).setEnabled(true);
            listimageview.get(13).setEnabled(true);
            listimageview.get(14).setEnabled(true);
            listimageview.get(15).setEnabled(true);
            listimageview.get(16).setEnabled(true);
            listimageview.get(17).setEnabled(true);
            listimageview.get(18).setEnabled(true);
            listimageview.get(19).setEnabled(true);
            listimageview.get(20).setEnabled(true);
            listimageview.get(21).setEnabled(true);
            listimageview.get(22).setEnabled(true);
            listimageview.get(23).setEnabled(true);
        }
        else if (sohang == 6 && socot == 5) {
            listimageview.get(0).setEnabled(true);
            listimageview.get(1).setEnabled(true);
            listimageview.get(2).setEnabled(true);
            listimageview.get(3).setEnabled(true);
            listimageview.get(4).setEnabled(true);
            listimageview.get(5).setEnabled(true);
            listimageview.get(6).setEnabled(true);
            listimageview.get(7).setEnabled(true);
            listimageview.get(8).setEnabled(true);
            listimageview.get(9).setEnabled(true);
            listimageview.get(10).setEnabled(true);
            listimageview.get(11).setEnabled(true);
            listimageview.get(12).setEnabled(true);
            listimageview.get(13).setEnabled(true);
            listimageview.get(14).setEnabled(true);
            listimageview.get(15).setEnabled(true);
            listimageview.get(16).setEnabled(true);
            listimageview.get(17).setEnabled(true);
            listimageview.get(18).setEnabled(true);
            listimageview.get(19).setEnabled(true);
            listimageview.get(20).setEnabled(true);
            listimageview.get(21).setEnabled(true);
            listimageview.get(22).setEnabled(true);
            listimageview.get(23).setEnabled(true);
            listimageview.get(24).setEnabled(true);
            listimageview.get(25).setEnabled(true);
            listimageview.get(26).setEnabled(true);
            listimageview.get(27).setEnabled(true);
            listimageview.get(28).setEnabled(true);
            listimageview.get(29).setEnabled(true);
        }
        else if (socot == 6 && sohang == 6) {
            listimageview.get(0).setEnabled(true);
            listimageview.get(1).setEnabled(true);
            listimageview.get(2).setEnabled(true);
            listimageview.get(3).setEnabled(true);
            listimageview.get(4).setEnabled(true);
            listimageview.get(5).setEnabled(true);
            listimageview.get(6).setEnabled(true);
            listimageview.get(7).setEnabled(true);
            listimageview.get(8).setEnabled(true);
            listimageview.get(9).setEnabled(true);
            listimageview.get(10).setEnabled(true);
            listimageview.get(11).setEnabled(true);
            listimageview.get(12).setEnabled(true);
            listimageview.get(13).setEnabled(true);
            listimageview.get(14).setEnabled(true);
            listimageview.get(15).setEnabled(true);
            listimageview.get(16).setEnabled(true);
            listimageview.get(17).setEnabled(true);
            listimageview.get(18).setEnabled(true);
            listimageview.get(19).setEnabled(true);
            listimageview.get(20).setEnabled(true);
            listimageview.get(21).setEnabled(true);
            listimageview.get(22).setEnabled(true);
            listimageview.get(23).setEnabled(true);
            listimageview.get(24).setEnabled(true);
            listimageview.get(25).setEnabled(true);
            listimageview.get(26).setEnabled(true);
            listimageview.get(27).setEnabled(true);
            listimageview.get(28).setEnabled(true);
            listimageview.get(29).setEnabled(true);
            listimageview.get(30).setEnabled(true);
            listimageview.get(31).setEnabled(true);
            listimageview.get(32).setEnabled(true);
            listimageview.get(33).setEnabled(true);
            listimageview.get(34).setEnabled(true);
            listimageview.get(35).setEnabled(true);
        }
    }

    private void choiLai() {
        if (socot == 4 && sohang == 4) {
            listimageview.get(0).setImageResource(R.drawable.images);
            listimageview.get(1).setImageResource(R.drawable.images);
            listimageview.get(2).setImageResource(R.drawable.images);
            listimageview.get(3).setImageResource(R.drawable.images);
            listimageview.get(4).setImageResource(R.drawable.images);
            listimageview.get(5).setImageResource(R.drawable.images);
            listimageview.get(6).setImageResource(R.drawable.images);
            listimageview.get(7).setImageResource(R.drawable.images);
            listimageview.get(8).setImageResource(R.drawable.images);
            listimageview.get(9).setImageResource(R.drawable.images);
            listimageview.get(10).setImageResource(R.drawable.images);
            listimageview.get(11).setImageResource(R.drawable.images);
            listimageview.get(12).setImageResource(R.drawable.images);
            listimageview.get(13).setImageResource(R.drawable.images);
            listimageview.get(14).setImageResource(R.drawable.images);
            listimageview.get(15).setImageResource(R.drawable.images);
            listimageview.get(0).setVisibility(View.VISIBLE);
            listimageview.get(1).setVisibility(View.VISIBLE);
            listimageview.get(2).setVisibility(View.VISIBLE);
            listimageview.get(3).setVisibility(View.VISIBLE);
            listimageview.get(4).setVisibility(View.VISIBLE);
            listimageview.get(5).setVisibility(View.VISIBLE);
            listimageview.get(6).setVisibility(View.VISIBLE);
            listimageview.get(7).setVisibility(View.VISIBLE);
            listimageview.get(8).setVisibility(View.VISIBLE);
            listimageview.get(9).setVisibility(View.VISIBLE);
            listimageview.get(10).setVisibility(View.VISIBLE);
            listimageview.get(11).setVisibility(View.VISIBLE);
            listimageview.get(12).setVisibility(View.VISIBLE);
            listimageview.get(13).setVisibility(View.VISIBLE);
            listimageview.get(14).setVisibility(View.VISIBLE);
            listimageview.get(15).setVisibility(View.VISIBLE);
            anhSuDung1();
            t2 = 35;
            tong = 16;
            tong2 = 8;
            tong3 = 0;
            tong4 = 0;
            countDownTimer1.start();
        }
        else if (sohang == 5 && socot == 4) {
            listimageview.get(0).setImageResource(R.drawable.images);
            listimageview.get(1).setImageResource(R.drawable.images);
            listimageview.get(2).setImageResource(R.drawable.images);
            listimageview.get(3).setImageResource(R.drawable.images);
            listimageview.get(4).setImageResource(R.drawable.images);
            listimageview.get(5).setImageResource(R.drawable.images);
            listimageview.get(6).setImageResource(R.drawable.images);
            listimageview.get(7).setImageResource(R.drawable.images);
            listimageview.get(8).setImageResource(R.drawable.images);
            listimageview.get(9).setImageResource(R.drawable.images);
            listimageview.get(10).setImageResource(R.drawable.images);
            listimageview.get(11).setImageResource(R.drawable.images);
            listimageview.get(12).setImageResource(R.drawable.images);
            listimageview.get(13).setImageResource(R.drawable.images);
            listimageview.get(14).setImageResource(R.drawable.images);
            listimageview.get(15).setImageResource(R.drawable.images);
            listimageview.get(16).setImageResource(R.drawable.images);
            listimageview.get(17).setImageResource(R.drawable.images);
            listimageview.get(18).setImageResource(R.drawable.images);
            listimageview.get(19).setImageResource(R.drawable.images);
            listimageview.get(0).setVisibility(View.VISIBLE);
            listimageview.get(1).setVisibility(View.VISIBLE);
            listimageview.get(2).setVisibility(View.VISIBLE);
            listimageview.get(3).setVisibility(View.VISIBLE);
            listimageview.get(4).setVisibility(View.VISIBLE);
            listimageview.get(5).setVisibility(View.VISIBLE);
            listimageview.get(6).setVisibility(View.VISIBLE);
            listimageview.get(7).setVisibility(View.VISIBLE);
            listimageview.get(8).setVisibility(View.VISIBLE);
            listimageview.get(9).setVisibility(View.VISIBLE);
            listimageview.get(10).setVisibility(View.VISIBLE);
            listimageview.get(11).setVisibility(View.VISIBLE);
            listimageview.get(12).setVisibility(View.VISIBLE);
            listimageview.get(13).setVisibility(View.VISIBLE);
            listimageview.get(14).setVisibility(View.VISIBLE);
            listimageview.get(15).setVisibility(View.VISIBLE);
            listimageview.get(16).setVisibility(View.VISIBLE);
            listimageview.get(17).setVisibility(View.VISIBLE);
            listimageview.get(18).setVisibility(View.VISIBLE);
            listimageview.get(19).setVisibility(View.VISIBLE);
            anhSuDung2();
            t2 = 45;
            tong = 20;
            tong2 = 10;
            tong3 = 0;
            tong4 = 0;
            countDownTimer2.start();
        }
        else if (socot == 4 && sohang == 6) {
            listimageview.get(0).setImageResource(R.drawable.images);
            listimageview.get(1).setImageResource(R.drawable.images);
            listimageview.get(2).setImageResource(R.drawable.images);
            listimageview.get(3).setImageResource(R.drawable.images);
            listimageview.get(4).setImageResource(R.drawable.images);
            listimageview.get(5).setImageResource(R.drawable.images);
            listimageview.get(6).setImageResource(R.drawable.images);
            listimageview.get(7).setImageResource(R.drawable.images);
            listimageview.get(8).setImageResource(R.drawable.images);
            listimageview.get(9).setImageResource(R.drawable.images);
            listimageview.get(10).setImageResource(R.drawable.images);
            listimageview.get(11).setImageResource(R.drawable.images);
            listimageview.get(12).setImageResource(R.drawable.images);
            listimageview.get(13).setImageResource(R.drawable.images);
            listimageview.get(14).setImageResource(R.drawable.images);
            listimageview.get(15).setImageResource(R.drawable.images);
            listimageview.get(16).setImageResource(R.drawable.images);
            listimageview.get(17).setImageResource(R.drawable.images);
            listimageview.get(18).setImageResource(R.drawable.images);
            listimageview.get(19).setImageResource(R.drawable.images);
            listimageview.get(20).setImageResource(R.drawable.images);
            listimageview.get(21).setImageResource(R.drawable.images);
            listimageview.get(22).setImageResource(R.drawable.images);
            listimageview.get(23).setImageResource(R.drawable.images);
            listimageview.get(0).setVisibility(View.VISIBLE);
            listimageview.get(1).setVisibility(View.VISIBLE);
            listimageview.get(2).setVisibility(View.VISIBLE);
            listimageview.get(3).setVisibility(View.VISIBLE);
            listimageview.get(4).setVisibility(View.VISIBLE);
            listimageview.get(5).setVisibility(View.VISIBLE);
            listimageview.get(6).setVisibility(View.VISIBLE);
            listimageview.get(7).setVisibility(View.VISIBLE);
            listimageview.get(8).setVisibility(View.VISIBLE);
            listimageview.get(9).setVisibility(View.VISIBLE);
            listimageview.get(10).setVisibility(View.VISIBLE);
            listimageview.get(11).setVisibility(View.VISIBLE);
            listimageview.get(12).setVisibility(View.VISIBLE);
            listimageview.get(13).setVisibility(View.VISIBLE);
            listimageview.get(14).setVisibility(View.VISIBLE);
            listimageview.get(15).setVisibility(View.VISIBLE);
            listimageview.get(16).setVisibility(View.VISIBLE);
            listimageview.get(17).setVisibility(View.VISIBLE);
            listimageview.get(18).setVisibility(View.VISIBLE);
            listimageview.get(19).setVisibility(View.VISIBLE);
            listimageview.get(20).setVisibility(View.VISIBLE);
            listimageview.get(21).setVisibility(View.VISIBLE);
            listimageview.get(22).setVisibility(View.VISIBLE);
            listimageview.get(23).setVisibility(View.VISIBLE);
            anhSuDung3();
            t2 = 60;
            tong = 24;
            tong2 = 12;
            tong3 = 0;
            tong4 = 0;
            countDownTimer3.start();
        }
        else if (sohang == 6 && socot == 5) {
            listimageview.get(0).setImageResource(R.drawable.images);
            listimageview.get(1).setImageResource(R.drawable.images);
            listimageview.get(2).setImageResource(R.drawable.images);
            listimageview.get(3).setImageResource(R.drawable.images);
            listimageview.get(4).setImageResource(R.drawable.images);
            listimageview.get(5).setImageResource(R.drawable.images);
            listimageview.get(6).setImageResource(R.drawable.images);
            listimageview.get(7).setImageResource(R.drawable.images);
            listimageview.get(8).setImageResource(R.drawable.images);
            listimageview.get(9).setImageResource(R.drawable.images);
            listimageview.get(10).setImageResource(R.drawable.images);
            listimageview.get(11).setImageResource(R.drawable.images);
            listimageview.get(12).setImageResource(R.drawable.images);
            listimageview.get(13).setImageResource(R.drawable.images);
            listimageview.get(14).setImageResource(R.drawable.images);
            listimageview.get(15).setImageResource(R.drawable.images);
            listimageview.get(16).setImageResource(R.drawable.images);
            listimageview.get(17).setImageResource(R.drawable.images);
            listimageview.get(18).setImageResource(R.drawable.images);
            listimageview.get(19).setImageResource(R.drawable.images);
            listimageview.get(20).setImageResource(R.drawable.images);
            listimageview.get(21).setImageResource(R.drawable.images);
            listimageview.get(22).setImageResource(R.drawable.images);
            listimageview.get(23).setImageResource(R.drawable.images);
            listimageview.get(24).setImageResource(R.drawable.images);
            listimageview.get(25).setImageResource(R.drawable.images);
            listimageview.get(26).setImageResource(R.drawable.images);
            listimageview.get(27).setImageResource(R.drawable.images);
            listimageview.get(28).setImageResource(R.drawable.images);
            listimageview.get(29).setImageResource(R.drawable.images);
            listimageview.get(0).setVisibility(View.VISIBLE);
            listimageview.get(1).setVisibility(View.VISIBLE);
            listimageview.get(2).setVisibility(View.VISIBLE);
            listimageview.get(3).setVisibility(View.VISIBLE);
            listimageview.get(4).setVisibility(View.VISIBLE);
            listimageview.get(5).setVisibility(View.VISIBLE);
            listimageview.get(6).setVisibility(View.VISIBLE);
            listimageview.get(7).setVisibility(View.VISIBLE);
            listimageview.get(8).setVisibility(View.VISIBLE);
            listimageview.get(9).setVisibility(View.VISIBLE);
            listimageview.get(10).setVisibility(View.VISIBLE);
            listimageview.get(11).setVisibility(View.VISIBLE);
            listimageview.get(12).setVisibility(View.VISIBLE);
            listimageview.get(13).setVisibility(View.VISIBLE);
            listimageview.get(14).setVisibility(View.VISIBLE);
            listimageview.get(15).setVisibility(View.VISIBLE);
            listimageview.get(16).setVisibility(View.VISIBLE);
            listimageview.get(17).setVisibility(View.VISIBLE);
            listimageview.get(18).setVisibility(View.VISIBLE);
            listimageview.get(19).setVisibility(View.VISIBLE);
            listimageview.get(20).setVisibility(View.VISIBLE);
            listimageview.get(21).setVisibility(View.VISIBLE);
            listimageview.get(22).setVisibility(View.VISIBLE);
            listimageview.get(23).setVisibility(View.VISIBLE);
            listimageview.get(24).setVisibility(View.VISIBLE);
            listimageview.get(25).setVisibility(View.VISIBLE);
            listimageview.get(26).setVisibility(View.VISIBLE);
            listimageview.get(27).setVisibility(View.VISIBLE);
            listimageview.get(28).setVisibility(View.VISIBLE);
            listimageview.get(29).setVisibility(View.VISIBLE);
            anhSuDung4();
            t2 = 75;
            tong = 30;
            tong2 = 15;
            tong3 = 0;
            tong4 = 0;
            countDownTimer4.start();
        }
        else if (socot == 6 && sohang == 6) {
            listimageview.get(0).setImageResource(R.drawable.images);
            listimageview.get(1).setImageResource(R.drawable.images);
            listimageview.get(2).setImageResource(R.drawable.images);
            listimageview.get(3).setImageResource(R.drawable.images);
            listimageview.get(4).setImageResource(R.drawable.images);
            listimageview.get(5).setImageResource(R.drawable.images);
            listimageview.get(6).setImageResource(R.drawable.images);
            listimageview.get(7).setImageResource(R.drawable.images);
            listimageview.get(8).setImageResource(R.drawable.images);
            listimageview.get(9).setImageResource(R.drawable.images);
            listimageview.get(10).setImageResource(R.drawable.images);
            listimageview.get(11).setImageResource(R.drawable.images);
            listimageview.get(12).setImageResource(R.drawable.images);
            listimageview.get(13).setImageResource(R.drawable.images);
            listimageview.get(14).setImageResource(R.drawable.images);
            listimageview.get(15).setImageResource(R.drawable.images);
            listimageview.get(16).setImageResource(R.drawable.images);
            listimageview.get(17).setImageResource(R.drawable.images);
            listimageview.get(18).setImageResource(R.drawable.images);
            listimageview.get(19).setImageResource(R.drawable.images);
            listimageview.get(20).setImageResource(R.drawable.images);
            listimageview.get(21).setImageResource(R.drawable.images);
            listimageview.get(22).setImageResource(R.drawable.images);
            listimageview.get(23).setImageResource(R.drawable.images);
            listimageview.get(24).setImageResource(R.drawable.images);
            listimageview.get(25).setImageResource(R.drawable.images);
            listimageview.get(26).setImageResource(R.drawable.images);
            listimageview.get(27).setImageResource(R.drawable.images);
            listimageview.get(28).setImageResource(R.drawable.images);
            listimageview.get(29).setImageResource(R.drawable.images);
            listimageview.get(30).setImageResource(R.drawable.images);
            listimageview.get(31).setImageResource(R.drawable.images);
            listimageview.get(32).setImageResource(R.drawable.images);
            listimageview.get(33).setImageResource(R.drawable.images);
            listimageview.get(34).setImageResource(R.drawable.images);
            listimageview.get(35).setImageResource(R.drawable.images);
            listimageview.get(0).setVisibility(View.VISIBLE);
            listimageview.get(1).setVisibility(View.VISIBLE);
            listimageview.get(2).setVisibility(View.VISIBLE);
            listimageview.get(3).setVisibility(View.VISIBLE);
            listimageview.get(4).setVisibility(View.VISIBLE);
            listimageview.get(5).setVisibility(View.VISIBLE);
            listimageview.get(6).setVisibility(View.VISIBLE);
            listimageview.get(7).setVisibility(View.VISIBLE);
            listimageview.get(8).setVisibility(View.VISIBLE);
            listimageview.get(9).setVisibility(View.VISIBLE);
            listimageview.get(10).setVisibility(View.VISIBLE);
            listimageview.get(11).setVisibility(View.VISIBLE);
            listimageview.get(12).setVisibility(View.VISIBLE);
            listimageview.get(13).setVisibility(View.VISIBLE);
            listimageview.get(14).setVisibility(View.VISIBLE);
            listimageview.get(15).setVisibility(View.VISIBLE);
            listimageview.get(16).setVisibility(View.VISIBLE);
            listimageview.get(17).setVisibility(View.VISIBLE);
            listimageview.get(18).setVisibility(View.VISIBLE);
            listimageview.get(19).setVisibility(View.VISIBLE);
            listimageview.get(20).setVisibility(View.VISIBLE);
            listimageview.get(21).setVisibility(View.VISIBLE);
            listimageview.get(22).setVisibility(View.VISIBLE);
            listimageview.get(23).setVisibility(View.VISIBLE);
            listimageview.get(24).setVisibility(View.VISIBLE);
            listimageview.get(25).setVisibility(View.VISIBLE);
            listimageview.get(26).setVisibility(View.VISIBLE);
            listimageview.get(27).setVisibility(View.VISIBLE);
            listimageview.get(28).setVisibility(View.VISIBLE);
            listimageview.get(29).setVisibility(View.VISIBLE);
            listimageview.get(30).setVisibility(View.VISIBLE);
            listimageview.get(31).setVisibility(View.VISIBLE);
            listimageview.get(32).setVisibility(View.VISIBLE);
            listimageview.get(33).setVisibility(View.VISIBLE);
            listimageview.get(34).setVisibility(View.VISIBLE);
            listimageview.get(35).setVisibility(View.VISIBLE);
            anhSuDung5();
            t2 = 90;
            tong = 36;
            tong2 = 18;
            tong3 = 0;
            tong4 = 0;
            countDownTimer5.start();
        }
    }

    private void kT(String p, final ImageView pic) {
        if (dem == 2) {
            if (p.equals(a)) {
                if (tong == 2) {
                    point.setText("100");
                    ImageView img = (ImageView) imvold;
                    img.setVisibility(View.INVISIBLE);
                    pic.setVisibility(View.INVISIBLE);
                    dem = 0;
                    batNut();
                    tong = tong - 2;
                }
                else {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ImageView img = (ImageView) imvold;
                            img.setVisibility(View.INVISIBLE);
                            pic.setVisibility(View.INVISIBLE);
                            dem = 0;
                            batNut();
                            tong3 += (100.0 / tong2);
                            tong4 = (int) tong3;
                            point.setText(tong4 + "");
                            tong = tong - 2;
                        }
                    }, 500);
                }
            }
            else {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img = (ImageView) imvold;
                        img.setImageResource(R.drawable.images);
                        pic.setImageResource(R.drawable.images);
                        dem = 0;
                        batNut();
                    }
                }, 500);
            }
        }
    }

    private void setImage() {
        if (sohang == 4 && socot == 4) {
            listimageview.get(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(0), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(0).setImageResource(idhinh);
                        a = anhsudung.get(0);
                        imvold = listimageview.get(0);
                        listimageview.get(0).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(0).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(0), listimageview.get(0));
                }
            });
            listimageview.get(1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(1), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(1).setImageResource(idhinh);
                        a = anhsudung.get(1);
                        imvold = listimageview.get(1);
                        listimageview.get(1).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(1).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(1), listimageview.get(1));
                }
            });
            listimageview.get(2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(2), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(2).setImageResource(idhinh);
                        a = anhsudung.get(2);
                        imvold = listimageview.get(2);
                        listimageview.get(2).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(2).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(2), listimageview.get(2));
                }
            });
            listimageview.get(3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(3), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(3).setImageResource(idhinh);
                        a = anhsudung.get(3);
                        imvold = listimageview.get(3);
                        listimageview.get(3).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(3).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(3), listimageview.get(3));
                }
            });
            listimageview.get(4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(4), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(4).setImageResource(idhinh);
                        a = anhsudung.get(4);
                        imvold = listimageview.get(4);
                        listimageview.get(4).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(4).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(4), listimageview.get(4));
                }
            });
            listimageview.get(5).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(5), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(5).setImageResource(idhinh);
                        a = anhsudung.get(5);
                        imvold = listimageview.get(5);
                        listimageview.get(5).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(5).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(5), listimageview.get(5));
                }
            });
            listimageview.get(6).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(6), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(6).setImageResource(idhinh);
                        a = anhsudung.get(6);
                        imvold = listimageview.get(6);
                        listimageview.get(6).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(6).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(6), listimageview.get(6));
                }
            });
            listimageview.get(7).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(7), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(7).setImageResource(idhinh);
                        a = anhsudung.get(7);
                        imvold = listimageview.get(7);
                        listimageview.get(7).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(7).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(7), listimageview.get(7));
                }
            });
            listimageview.get(8).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(8), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(8).setImageResource(idhinh);
                        a = anhsudung.get(8);
                        imvold = listimageview.get(8);
                        listimageview.get(8).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(8).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(8), listimageview.get(8));
                }
            });
            listimageview.get(9).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(9), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(9).setImageResource(idhinh);
                        a = anhsudung.get(9);
                        imvold = listimageview.get(9);
                        listimageview.get(9).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(9).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(9), listimageview.get(9));
                }
            });
            listimageview.get(10).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(10), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(10).setImageResource(idhinh);
                        a = anhsudung.get(10);
                        imvold = listimageview.get(10);
                        listimageview.get(10).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(10).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(10), listimageview.get(10));
                }
            });
            listimageview.get(11).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(11), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(11).setImageResource(idhinh);
                        a = anhsudung.get(11);
                        imvold = listimageview.get(11);
                        listimageview.get(11).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(11).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(11), listimageview.get(11));
                }
            });
            listimageview.get(12).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(12), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(12).setImageResource(idhinh);
                        a = anhsudung.get(12);
                        imvold = listimageview.get(12);
                        listimageview.get(12).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(12).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(12), listimageview.get(12));
                }
            });
            listimageview.get(13).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(13), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(13).setImageResource(idhinh);
                        a = anhsudung.get(13);
                        imvold = listimageview.get(13);
                        listimageview.get(13).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(13).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(13), listimageview.get(13));
                }
            });
            listimageview.get(14).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(14), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(14).setImageResource(idhinh);
                        a = anhsudung.get(14);
                        imvold = listimageview.get(14);
                        listimageview.get(14).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(14).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(14), listimageview.get(14));
                }
            });
            listimageview.get(15).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(15), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(15).setImageResource(idhinh);
                        a = anhsudung.get(15);
                        imvold = listimageview.get(15);
                        listimageview.get(15).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(15).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(15), listimageview.get(15));
                }
            });
        }
        else if (socot == 4 && sohang == 5) {
            listimageview.get(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(0), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(0).setImageResource(idhinh);
                        a = anhsudung.get(0);
                        imvold = listimageview.get(0);
                        listimageview.get(0).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(0).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(0), listimageview.get(0));
                }
            });
            listimageview.get(1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(1), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(1).setImageResource(idhinh);
                        a = anhsudung.get(1);
                        imvold = listimageview.get(1);
                        listimageview.get(1).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(1).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(1), listimageview.get(1));
                }
            });
            listimageview.get(2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(2), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(2).setImageResource(idhinh);
                        a = anhsudung.get(2);
                        imvold = listimageview.get(2);
                        listimageview.get(2).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(2).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(2), listimageview.get(2));
                }
            });
            listimageview.get(3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(3), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(3).setImageResource(idhinh);
                        a = anhsudung.get(3);
                        imvold = listimageview.get(3);
                        listimageview.get(3).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(3).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(3), listimageview.get(3));
                }
            });
            listimageview.get(4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(4), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(4).setImageResource(idhinh);
                        a = anhsudung.get(4);
                        imvold = listimageview.get(4);
                        listimageview.get(4).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(4).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(4), listimageview.get(4));
                }
            });
            listimageview.get(5).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(5), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(5).setImageResource(idhinh);
                        a = anhsudung.get(5);
                        imvold = listimageview.get(5);
                        listimageview.get(5).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(5).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(5), listimageview.get(5));
                }
            });
            listimageview.get(6).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(6), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(6).setImageResource(idhinh);
                        a = anhsudung.get(6);
                        imvold = listimageview.get(6);
                        listimageview.get(6).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(6).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(6), listimageview.get(6));
                }
            });
            listimageview.get(7).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(7), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(7).setImageResource(idhinh);
                        a = anhsudung.get(7);
                        imvold = listimageview.get(7);
                        listimageview.get(7).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(7).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(7), listimageview.get(7));
                }
            });
            listimageview.get(8).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(8), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(8).setImageResource(idhinh);
                        a = anhsudung.get(8);
                        imvold = listimageview.get(8);
                        listimageview.get(8).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(8).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(8), listimageview.get(8));
                }
            });
            listimageview.get(9).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(9), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(9).setImageResource(idhinh);
                        a = anhsudung.get(9);
                        imvold = listimageview.get(9);
                        listimageview.get(9).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(9).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(9), listimageview.get(9));
                }
            });
            listimageview.get(10).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(10), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(10).setImageResource(idhinh);
                        a = anhsudung.get(10);
                        imvold = listimageview.get(10);
                        listimageview.get(10).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(10).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(10), listimageview.get(10));
                }
            });
            listimageview.get(11).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(11), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(11).setImageResource(idhinh);
                        a = anhsudung.get(11);
                        imvold = listimageview.get(11);
                        listimageview.get(11).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(11).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(11), listimageview.get(11));
                }
            });
            listimageview.get(12).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(12), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(12).setImageResource(idhinh);
                        a = anhsudung.get(12);
                        imvold = listimageview.get(12);
                        listimageview.get(12).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(12).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(12), listimageview.get(12));
                }
            });
            listimageview.get(13).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(13), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(13).setImageResource(idhinh);
                        a = anhsudung.get(13);
                        imvold = listimageview.get(13);
                        listimageview.get(13).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(13).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(13), listimageview.get(13));
                }
            });
            listimageview.get(14).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(14), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(14).setImageResource(idhinh);
                        a = anhsudung.get(14);
                        imvold = listimageview.get(14);
                        listimageview.get(14).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(14).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(14), listimageview.get(14));
                }
            });
            listimageview.get(15).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(15), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(15).setImageResource(idhinh);
                        a = anhsudung.get(15);
                        imvold = listimageview.get(15);
                        listimageview.get(15).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(15).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(15), listimageview.get(15));
                }
            });
            listimageview.get(16).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(16), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(16).setImageResource(idhinh);
                        a = anhsudung.get(16);
                        imvold = listimageview.get(16);
                        listimageview.get(16).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(16).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(16), listimageview.get(16));
                }
            });
            listimageview.get(17).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(17), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(17).setImageResource(idhinh);
                        a = anhsudung.get(17);
                        imvold = listimageview.get(17);
                        listimageview.get(17).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(17).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(17), listimageview.get(17));
                }
            });
            listimageview.get(18).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(18), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(18).setImageResource(idhinh);
                        a = anhsudung.get(18);
                        imvold = listimageview.get(18);
                        listimageview.get(18).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(18).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(18), listimageview.get(18));
                }
            });
            listimageview.get(19).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(19), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(19).setImageResource(idhinh);
                        a = anhsudung.get(19);
                        imvold = listimageview.get(19);
                        listimageview.get(19).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(19).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(19), listimageview.get(19));
                }
            });
        }
        else if (sohang == 6 && socot == 4) {
            listimageview.get(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(0), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(0).setImageResource(idhinh);
                        a = anhsudung.get(0);
                        imvold = listimageview.get(0);
                        listimageview.get(0).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(0).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(0), listimageview.get(0));
                }
            });
            listimageview.get(1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(1), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(1).setImageResource(idhinh);
                        a = anhsudung.get(1);
                        imvold = listimageview.get(1);
                        listimageview.get(1).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(1).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(1), listimageview.get(1));
                }
            });
            listimageview.get(2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(2), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(2).setImageResource(idhinh);
                        a = anhsudung.get(2);
                        imvold = listimageview.get(2);
                        listimageview.get(2).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(2).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(2), listimageview.get(2));
                }
            });
            listimageview.get(3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(3), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(3).setImageResource(idhinh);
                        a = anhsudung.get(3);
                        imvold = listimageview.get(3);
                        listimageview.get(3).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(3).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(3), listimageview.get(3));
                }
            });
            listimageview.get(4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(4), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(4).setImageResource(idhinh);
                        a = anhsudung.get(4);
                        imvold = listimageview.get(4);
                        listimageview.get(4).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(4).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(4), listimageview.get(4));
                }
            });
            listimageview.get(5).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(5), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(5).setImageResource(idhinh);
                        a = anhsudung.get(5);
                        imvold = listimageview.get(5);
                        listimageview.get(5).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(5).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(5), listimageview.get(5));
                }
            });
            listimageview.get(6).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(6), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(6).setImageResource(idhinh);
                        a = anhsudung.get(6);
                        imvold = listimageview.get(6);
                        listimageview.get(6).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(6).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(6), listimageview.get(6));
                }
            });
            listimageview.get(7).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(7), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(7).setImageResource(idhinh);
                        a = anhsudung.get(7);
                        imvold = listimageview.get(7);
                        listimageview.get(7).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(7).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(7), listimageview.get(7));
                }
            });
            listimageview.get(8).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(8), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(8).setImageResource(idhinh);
                        a = anhsudung.get(8);
                        imvold = listimageview.get(8);
                        listimageview.get(8).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(8).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(8), listimageview.get(8));
                }
            });
            listimageview.get(9).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(9), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(9).setImageResource(idhinh);
                        a = anhsudung.get(9);
                        imvold = listimageview.get(9);
                        listimageview.get(9).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(9).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(9), listimageview.get(9));
                }
            });
            listimageview.get(10).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(10), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(10).setImageResource(idhinh);
                        a = anhsudung.get(10);
                        imvold = listimageview.get(10);
                        listimageview.get(10).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(10).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(10), listimageview.get(10));
                }
            });
            listimageview.get(11).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(11), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(11).setImageResource(idhinh);
                        a = anhsudung.get(11);
                        imvold = listimageview.get(11);
                        listimageview.get(11).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(11).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(11), listimageview.get(11));
                }
            });
            listimageview.get(12).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(12), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(12).setImageResource(idhinh);
                        a = anhsudung.get(12);
                        imvold = listimageview.get(12);
                        listimageview.get(12).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(12).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(12), listimageview.get(12));
                }
            });
            listimageview.get(13).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(13), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(13).setImageResource(idhinh);
                        a = anhsudung.get(13);
                        imvold = listimageview.get(13);
                        listimageview.get(13).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(13).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(13), listimageview.get(13));
                }
            });
            listimageview.get(14).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(14), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(14).setImageResource(idhinh);
                        a = anhsudung.get(14);
                        imvold = listimageview.get(14);
                        listimageview.get(14).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(14).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(14), listimageview.get(14));
                }
            });
            listimageview.get(15).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(15), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(15).setImageResource(idhinh);
                        a = anhsudung.get(15);
                        imvold = listimageview.get(15);
                        listimageview.get(15).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(15).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(15), listimageview.get(15));
                }
            });
            listimageview.get(16).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(16), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(16).setImageResource(idhinh);
                        a = anhsudung.get(16);
                        imvold = listimageview.get(16);
                        listimageview.get(16).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(16).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(16), listimageview.get(16));
                }
            });
            listimageview.get(17).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(17), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(17).setImageResource(idhinh);
                        a = anhsudung.get(17);
                        imvold = listimageview.get(17);
                        listimageview.get(17).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(17).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(17), listimageview.get(17));
                }
            });
            listimageview.get(18).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(18), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(18).setImageResource(idhinh);
                        a = anhsudung.get(18);
                        imvold = listimageview.get(18);
                        listimageview.get(18).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(18).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(18), listimageview.get(18));
                }
            });
            listimageview.get(19).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(19), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(19).setImageResource(idhinh);
                        a = anhsudung.get(19);
                        imvold = listimageview.get(19);
                        listimageview.get(19).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(19).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(19), listimageview.get(19));
                }
            });
            listimageview.get(20).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(20), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(20).setImageResource(idhinh);
                        a = anhsudung.get(20);
                        imvold = listimageview.get(20);
                        listimageview.get(20).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(20).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(20), listimageview.get(20));
                }
            });
            listimageview.get(21).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(21), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(21).setImageResource(idhinh);
                        a = anhsudung.get(21);
                        imvold = listimageview.get(21);
                        listimageview.get(21).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(21).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(21), listimageview.get(21));
                }
            });
            listimageview.get(22).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(22), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(22).setImageResource(idhinh);
                        a = anhsudung.get(22);
                        imvold = listimageview.get(22);
                        listimageview.get(22).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(22).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(22), listimageview.get(22));
                }
            });
            listimageview.get(23).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(23), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(23).setImageResource(idhinh);
                        a = anhsudung.get(23);
                        imvold = listimageview.get(23);
                        listimageview.get(23).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(23).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(23), listimageview.get(23));
                }
            });
        }
        else if (socot == 5 && sohang == 6) {
            listimageview.get(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(0), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(0).setImageResource(idhinh);
                        a = anhsudung.get(0);
                        imvold = listimageview.get(0);
                        listimageview.get(0).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(0).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(0), listimageview.get(0));
                }
            });
            listimageview.get(1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(1), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(1).setImageResource(idhinh);
                        a = anhsudung.get(1);
                        imvold = listimageview.get(1);
                        listimageview.get(1).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(1).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(1), listimageview.get(1));
                }
            });
            listimageview.get(2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(2), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(2).setImageResource(idhinh);
                        a = anhsudung.get(2);
                        imvold = listimageview.get(2);
                        listimageview.get(2).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(2).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(2), listimageview.get(2));
                }
            });
            listimageview.get(3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(3), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(3).setImageResource(idhinh);
                        a = anhsudung.get(3);
                        imvold = listimageview.get(3);
                        listimageview.get(3).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(3).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(3), listimageview.get(3));
                }
            });
            listimageview.get(4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(4), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(4).setImageResource(idhinh);
                        a = anhsudung.get(4);
                        imvold = listimageview.get(4);
                        listimageview.get(4).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(4).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(4), listimageview.get(4));
                }
            });
            listimageview.get(5).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(5), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(5).setImageResource(idhinh);
                        a = anhsudung.get(5);
                        imvold = listimageview.get(5);
                        listimageview.get(5).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(5).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(5), listimageview.get(5));
                }
            });
            listimageview.get(6).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(6), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(6).setImageResource(idhinh);
                        a = anhsudung.get(6);
                        imvold = listimageview.get(6);
                        listimageview.get(6).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(6).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(6), listimageview.get(6));
                }
            });
            listimageview.get(7).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(7), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(7).setImageResource(idhinh);
                        a = anhsudung.get(7);
                        imvold = listimageview.get(7);
                        listimageview.get(7).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(7).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(7), listimageview.get(7));
                }
            });
            listimageview.get(8).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(8), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(8).setImageResource(idhinh);
                        a = anhsudung.get(8);
                        imvold = listimageview.get(8);
                        listimageview.get(8).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(8).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(8), listimageview.get(8));
                }
            });
            listimageview.get(9).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(9), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(9).setImageResource(idhinh);
                        a = anhsudung.get(9);
                        imvold = listimageview.get(9);
                        listimageview.get(9).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(9).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(9), listimageview.get(9));
                }
            });
            listimageview.get(10).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(10), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(10).setImageResource(idhinh);
                        a = anhsudung.get(10);
                        imvold = listimageview.get(10);
                        listimageview.get(10).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(10).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(10), listimageview.get(10));
                }
            });
            listimageview.get(11).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(11), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(11).setImageResource(idhinh);
                        a = anhsudung.get(11);
                        imvold = listimageview.get(11);
                        listimageview.get(11).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(11).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(11), listimageview.get(11));
                }
            });
            listimageview.get(12).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(12), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(12).setImageResource(idhinh);
                        a = anhsudung.get(12);
                        imvold = listimageview.get(12);
                        listimageview.get(12).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(12).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(12), listimageview.get(12));
                }
            });
            listimageview.get(13).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(13), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(13).setImageResource(idhinh);
                        a = anhsudung.get(13);
                        imvold = listimageview.get(13);
                        listimageview.get(13).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(13).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(13), listimageview.get(13));
                }
            });
            listimageview.get(14).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(14), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(14).setImageResource(idhinh);
                        a = anhsudung.get(14);
                        imvold = listimageview.get(14);
                        listimageview.get(14).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(14).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(14), listimageview.get(14));
                }
            });
            listimageview.get(15).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(15), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(15).setImageResource(idhinh);
                        a = anhsudung.get(15);
                        imvold = listimageview.get(15);
                        listimageview.get(15).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(15).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(15), listimageview.get(15));
                }
            });
            listimageview.get(16).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(16), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(16).setImageResource(idhinh);
                        a = anhsudung.get(16);
                        imvold = listimageview.get(16);
                        listimageview.get(16).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(16).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(16), listimageview.get(16));
                }
            });
            listimageview.get(17).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(17), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(17).setImageResource(idhinh);
                        a = anhsudung.get(17);
                        imvold = listimageview.get(17);
                        listimageview.get(17).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(17).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(17), listimageview.get(17));
                }
            });
            listimageview.get(18).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(18), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(18).setImageResource(idhinh);
                        a = anhsudung.get(18);
                        imvold = listimageview.get(18);
                        listimageview.get(18).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(18).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(18), listimageview.get(18));
                }
            });
            listimageview.get(19).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(19), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(19).setImageResource(idhinh);
                        a = anhsudung.get(19);
                        imvold = listimageview.get(19);
                        listimageview.get(19).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(19).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(19), listimageview.get(19));
                }
            });
            listimageview.get(20).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(20), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(20).setImageResource(idhinh);
                        a = anhsudung.get(20);
                        imvold = listimageview.get(20);
                        listimageview.get(20).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(20).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(20), listimageview.get(20));
                }
            });
            listimageview.get(21).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(21), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(21).setImageResource(idhinh);
                        a = anhsudung.get(21);
                        imvold = listimageview.get(21);
                        listimageview.get(21).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(21).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(21), listimageview.get(21));
                }
            });
            listimageview.get(22).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(22), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(22).setImageResource(idhinh);
                        a = anhsudung.get(22);
                        imvold = listimageview.get(22);
                        listimageview.get(22).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(22).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(22), listimageview.get(22));
                }
            });
            listimageview.get(23).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(23), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(23).setImageResource(idhinh);
                        a = anhsudung.get(23);
                        imvold = listimageview.get(23);
                        listimageview.get(23).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(23).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(23), listimageview.get(23));
                }
            });
            listimageview.get(24).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(24), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(24).setImageResource(idhinh);
                        a = anhsudung.get(24);
                        imvold = listimageview.get(24);
                        listimageview.get(24).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(24).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(24), listimageview.get(24));
                }
            });
            listimageview.get(25).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(25), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(25).setImageResource(idhinh);
                        a = anhsudung.get(25);
                        imvold = listimageview.get(25);
                        listimageview.get(25).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(25).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(25), listimageview.get(25));
                }
            });
            listimageview.get(26).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(26), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(26).setImageResource(idhinh);
                        a = anhsudung.get(26);
                        imvold = listimageview.get(26);
                        listimageview.get(26).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(26).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(26), listimageview.get(26));
                }
            });
            listimageview.get(27).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(27), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(27).setImageResource(idhinh);
                        a = anhsudung.get(27);
                        imvold = listimageview.get(27);
                        listimageview.get(27).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(27).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(27), listimageview.get(27));
                }
            });
            listimageview.get(28).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(28), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(28).setImageResource(idhinh);
                        a = anhsudung.get(28);
                        imvold = listimageview.get(28);
                        listimageview.get(28).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(28).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(28), listimageview.get(28));
                }
            });
            listimageview.get(29).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(29), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(29).setImageResource(idhinh);
                        a = anhsudung.get(29);
                        imvold = listimageview.get(29);
                        listimageview.get(29).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(29).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(29), listimageview.get(29));
                }
            });
        }
        else if (sohang == 6 && socot == 6) {
            listimageview.get(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(0), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(0).setImageResource(idhinh);
                        a = anhsudung.get(0);
                        imvold = listimageview.get(0);
                        listimageview.get(0).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(0).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(0), listimageview.get(0));
                }
            });
            listimageview.get(1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(1), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(1).setImageResource(idhinh);
                        a = anhsudung.get(1);
                        imvold = listimageview.get(1);
                        listimageview.get(1).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(1).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(1), listimageview.get(1));
                }
            });
            listimageview.get(2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(2), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(2).setImageResource(idhinh);
                        a = anhsudung.get(2);
                        imvold = listimageview.get(2);
                        listimageview.get(2).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(2).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(2), listimageview.get(2));
                }
            });
            listimageview.get(3).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(3), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(3).setImageResource(idhinh);
                        a = anhsudung.get(3);
                        imvold = listimageview.get(3);
                        listimageview.get(3).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(3).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(3), listimageview.get(3));
                }
            });
            listimageview.get(4).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(4), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(4).setImageResource(idhinh);
                        a = anhsudung.get(4);
                        imvold = listimageview.get(4);
                        listimageview.get(4).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(4).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(4), listimageview.get(4));
                }
            });
            listimageview.get(5).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(5), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(5).setImageResource(idhinh);
                        a = anhsudung.get(5);
                        imvold = listimageview.get(5);
                        listimageview.get(5).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(5).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(5), listimageview.get(5));
                }
            });
            listimageview.get(6).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(6), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(6).setImageResource(idhinh);
                        a = anhsudung.get(6);
                        imvold = listimageview.get(6);
                        listimageview.get(6).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(6).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(6), listimageview.get(6));
                }
            });
            listimageview.get(7).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(7), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(7).setImageResource(idhinh);
                        a = anhsudung.get(7);
                        imvold = listimageview.get(7);
                        listimageview.get(7).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(7).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(7), listimageview.get(7));
                }
            });
            listimageview.get(8).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(8), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(8).setImageResource(idhinh);
                        a = anhsudung.get(8);
                        imvold = listimageview.get(8);
                        listimageview.get(8).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(8).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(8), listimageview.get(8));
                }
            });
            listimageview.get(9).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(9), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(9).setImageResource(idhinh);
                        a = anhsudung.get(9);
                        imvold = listimageview.get(9);
                        listimageview.get(9).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(9).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(9), listimageview.get(9));
                }
            });
            listimageview.get(10).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(10), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(10).setImageResource(idhinh);
                        a = anhsudung.get(10);
                        imvold = listimageview.get(10);
                        listimageview.get(10).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(10).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(10), listimageview.get(10));
                }
            });
            listimageview.get(11).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(11), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(11).setImageResource(idhinh);
                        a = anhsudung.get(11);
                        imvold = listimageview.get(11);
                        listimageview.get(11).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(11).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(11), listimageview.get(11));
                }
            });
            listimageview.get(12).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(12), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(12).setImageResource(idhinh);
                        a = anhsudung.get(12);
                        imvold = listimageview.get(12);
                        listimageview.get(12).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(12).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(12), listimageview.get(12));
                }
            });
            listimageview.get(13).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(13), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(13).setImageResource(idhinh);
                        a = anhsudung.get(13);
                        imvold = listimageview.get(13);
                        listimageview.get(13).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(13).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(13), listimageview.get(13));
                }
            });
            listimageview.get(14).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(14), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(14).setImageResource(idhinh);
                        a = anhsudung.get(14);
                        imvold = listimageview.get(14);
                        listimageview.get(14).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(14).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(14), listimageview.get(14));
                }
            });
            listimageview.get(15).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(15), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(15).setImageResource(idhinh);
                        a = anhsudung.get(15);
                        imvold = listimageview.get(15);
                        listimageview.get(15).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(15).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(15), listimageview.get(15));
                }
            });
            listimageview.get(16).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(16), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(16).setImageResource(idhinh);
                        a = anhsudung.get(16);
                        imvold = listimageview.get(16);
                        listimageview.get(16).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(16).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(16), listimageview.get(16));
                }
            });
            listimageview.get(17).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(17), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(17).setImageResource(idhinh);
                        a = anhsudung.get(17);
                        imvold = listimageview.get(17);
                        listimageview.get(17).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(17).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(17), listimageview.get(17));
                }
            });
            listimageview.get(18).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(18), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(18).setImageResource(idhinh);
                        a = anhsudung.get(18);
                        imvold = listimageview.get(18);
                        listimageview.get(18).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(18).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(18), listimageview.get(18));
                }
            });
            listimageview.get(19).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(19), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(19).setImageResource(idhinh);
                        a = anhsudung.get(19);
                        imvold = listimageview.get(19);
                        listimageview.get(19).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(19).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(19), listimageview.get(19));
                }
            });
            listimageview.get(20).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(20), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(20).setImageResource(idhinh);
                        a = anhsudung.get(20);
                        imvold = listimageview.get(20);
                        listimageview.get(20).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(20).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(20), listimageview.get(20));
                }
            });
            listimageview.get(21).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(21), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(21).setImageResource(idhinh);
                        a = anhsudung.get(21);
                        imvold = listimageview.get(21);
                        listimageview.get(21).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(21).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(21), listimageview.get(21));
                }
            });
            listimageview.get(22).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(22), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(22).setImageResource(idhinh);
                        a = anhsudung.get(22);
                        imvold = listimageview.get(22);
                        listimageview.get(22).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(22).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(22), listimageview.get(22));
                }
            });
            listimageview.get(23).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(23), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(23).setImageResource(idhinh);
                        a = anhsudung.get(23);
                        imvold = listimageview.get(23);
                        listimageview.get(23).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(23).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(23), listimageview.get(23));
                }
            });
            listimageview.get(24).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(24), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(24).setImageResource(idhinh);
                        a = anhsudung.get(24);
                        imvold = listimageview.get(24);
                        listimageview.get(24).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(24).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(24), listimageview.get(24));
                }
            });
            listimageview.get(25).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(25), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(25).setImageResource(idhinh);
                        a = anhsudung.get(25);
                        imvold = listimageview.get(25);
                        listimageview.get(25).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(25).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(25), listimageview.get(25));
                }
            });
            listimageview.get(26).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(26), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(26).setImageResource(idhinh);
                        a = anhsudung.get(26);
                        imvold = listimageview.get(26);
                        listimageview.get(26).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(26).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(26), listimageview.get(26));
                }
            });
            listimageview.get(27).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(27), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(27).setImageResource(idhinh);
                        a = anhsudung.get(27);
                        imvold = listimageview.get(27);
                        listimageview.get(27).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(27).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(27), listimageview.get(27));
                }
            });
            listimageview.get(28).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(28), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(28).setImageResource(idhinh);
                        a = anhsudung.get(28);
                        imvold = listimageview.get(28);
                        listimageview.get(28).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(28).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(28), listimageview.get(28));
                }
            });
            listimageview.get(29).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(29), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(29).setImageResource(idhinh);
                        a = anhsudung.get(29);
                        imvold = listimageview.get(29);
                        listimageview.get(29).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(29).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(29), listimageview.get(29));
                }
            });
            listimageview.get(30).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(30), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(30).setImageResource(idhinh);
                        a = anhsudung.get(30);
                        imvold = listimageview.get(30);
                        listimageview.get(30).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(30).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(30), listimageview.get(30));
                }
            });
            listimageview.get(31).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(31), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(31).setImageResource(idhinh);
                        a = anhsudung.get(31);
                        imvold = listimageview.get(31);
                        listimageview.get(31).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(31).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(31), listimageview.get(31));
                }
            });
            listimageview.get(32).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(32), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(32).setImageResource(idhinh);
                        a = anhsudung.get(32);
                        imvold = listimageview.get(32);
                        listimageview.get(32).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(32).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(32), listimageview.get(32));
                }
            });
            listimageview.get(33).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(33), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(33).setImageResource(idhinh);
                        a = anhsudung.get(33);
                        imvold = listimageview.get(33);
                        listimageview.get(33).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(33).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(33), listimageview.get(33));
                }
            });
            listimageview.get(34).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(34), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(34).setImageResource(idhinh);
                        a = anhsudung.get(34);
                        imvold = listimageview.get(34);
                        listimageview.get(34).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(34).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(34), listimageview.get(34));
                }
            });
            listimageview.get(35).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int idhinh = getResources().getIdentifier(anhsudung.get(35), "drawable", getPackageName());
                    if (dem == 0) {
                        listimageview.get(35).setImageResource(idhinh);
                        a = anhsudung.get(35);
                        imvold = listimageview.get(35);
                        listimageview.get(35).setEnabled(false);
                    }
                    else if (dem == 1) {
                        listimageview.get(35).setImageResource(idhinh);
                    }
                    dem++;
                    kT(anhsudung.get(35), listimageview.get(35));
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PAUSE && resultCode == RESULT_OK && data != null) {
            b = data.getStringExtra("luachon");
            if (b.equals("3")) {
                finish();
            }
            else if (b.equals("2")) {
                point.setText("0");
                finishCountDownTimer();
                choiLai();
            }
            else if (b.equals("1")) {
                setCountDownTimer();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setCountDownTimer() {
        if (socot == 4 && sohang == 4) {
            countDownTimer1.start();
        }
        else if (sohang == 5 && socot == 4) {
            countDownTimer2.start();
        }
        else if (socot == 4 && sohang == 6) {
            countDownTimer3.start();
        }
        else if (sohang == 6 && socot == 5) {
            countDownTimer4.start();
        }
        else if (socot == 6 && sohang == 6) {
            countDownTimer5.start();
        }
    }

    CountDownTimer countDownTimer1 = new CountDownTimer(tim1, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            time.setText((t2/60) + ":" + (t2%60));
            t2--;
            tim1 -= 1000;
            if (tong == 0) {
                countDownTimer1.cancel();
                final Dialog dialog1 = new Dialog(SelectedActivity.this);
                dialog1.setContentView(R.layout.custom_dialog);
                dialog1.setCanceledOnTouchOutside(false);
                Button rs1 = (Button) dialog1.findViewById(R.id.rs1);
                Button rs2 = (Button) dialog1.findViewById(R.id.q1);
                rs1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choiLai();
                        point.setText("0");
                        dialog1.cancel();
                        getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                    }
                });
                rs2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                dialog1.show();
            }
        }
        @Override
        public void onFinish() {
            final Dialog dialog2 = new Dialog(SelectedActivity.this);
            dialog2.setContentView(R.layout.custom_dialog_2);
            dialog2.setCanceledOnTouchOutside(false);
            Button rs2 = (Button) dialog2.findViewById(R.id.rs2);
            Button q2 = (Button) dialog2.findViewById(R.id.q2);
            rs2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choiLai();
                    point.setText("0");
                    dialog2.cancel();
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                }
            });
            q2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            dialog2.show();
        }
    };

    CountDownTimer countDownTimer2 = new CountDownTimer(tim2, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            time.setText((t2/60) + ":" + (t2%60));
            t2--;
            tim2 -= 1000;
            if (tong == 0) {
                countDownTimer2.cancel();
                final Dialog dialog1 = new Dialog(SelectedActivity.this);
                dialog1.setContentView(R.layout.custom_dialog);
                dialog1.setCanceledOnTouchOutside(false);
                Button rs1 = (Button) dialog1.findViewById(R.id.rs1);
                Button rs2 = (Button) dialog1.findViewById(R.id.q1);
                rs1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choiLai();
                        point.setText("0");
                        dialog1.cancel();
                        getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                    }
                });
                rs2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                dialog1.show();
            }
        }
        @Override
        public void onFinish() {
            final Dialog dialog2 = new Dialog(SelectedActivity.this);
            dialog2.setContentView(R.layout.custom_dialog_2);
            dialog2.setCanceledOnTouchOutside(false);
            Button rs2 = (Button) dialog2.findViewById(R.id.rs2);
            Button q2 = (Button) dialog2.findViewById(R.id.q2);
            rs2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choiLai();
                    point.setText("0");
                    dialog2.cancel();
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                }
            });
            q2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            dialog2.show();
        }
    };

    CountDownTimer countDownTimer3 = new CountDownTimer(tim3, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            time.setText((t2/60) + ":" + (t2%60));
            t2--;
            tim3 -= 1000;
            if (tong == 0) {
                countDownTimer3.cancel();
                final Dialog dialog1 = new Dialog(SelectedActivity.this);
                dialog1.setContentView(R.layout.custom_dialog);
                dialog1.setCanceledOnTouchOutside(false);
                Button rs1 = (Button) dialog1.findViewById(R.id.rs1);
                Button rs2 = (Button) dialog1.findViewById(R.id.q1);
                rs1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choiLai();
                        point.setText("0");
                        dialog1.cancel();
                        getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                    }
                });
                rs2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                dialog1.show();
            }
        }
        @Override
        public void onFinish() {
            final Dialog dialog2 = new Dialog(SelectedActivity.this);
            dialog2.setContentView(R.layout.custom_dialog_2);
            dialog2.setCanceledOnTouchOutside(false);
            Button rs2 = (Button) dialog2.findViewById(R.id.rs2);
            Button q2 = (Button) dialog2.findViewById(R.id.q2);
            rs2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choiLai();
                    point.setText("0");
                    dialog2.cancel();
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                }
            });
            q2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            dialog2.show();
        }
    };

    CountDownTimer countDownTimer4 = new CountDownTimer(tim4, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            time.setText((t2/60) + ":" + (t2%60));
            t2--;
            tim4 -= 1000;
            if (tong == 0) {
                countDownTimer4.cancel();
                final Dialog dialog1 = new Dialog(SelectedActivity.this);
                dialog1.setContentView(R.layout.custom_dialog);
                dialog1.setCanceledOnTouchOutside(false);
                Button rs1 = (Button) dialog1.findViewById(R.id.rs1);
                Button rs2 = (Button) dialog1.findViewById(R.id.q1);
                rs1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choiLai();
                        point.setText("0");
                        dialog1.cancel();
                        getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                    }
                });
                rs2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                dialog1.show();
            }
        }
        @Override
        public void onFinish() {
            final Dialog dialog2 = new Dialog(SelectedActivity.this);
            dialog2.setContentView(R.layout.custom_dialog_2);
            dialog2.setCanceledOnTouchOutside(false);
            Button rs2 = (Button) dialog2.findViewById(R.id.rs2);
            Button q2 = (Button) dialog2.findViewById(R.id.q2);
            rs2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choiLai();
                    point.setText("0");
                    dialog2.cancel();
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                }
            });
            q2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            dialog2.show();
        }
    };

    CountDownTimer countDownTimer5 = new CountDownTimer(tim5, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            time.setText((t2/60) + ":" + (t2%60));
            t2--;
            tim5 -= 1000;
            if (tong == 0) {
                countDownTimer5.cancel();
                final Dialog dialog1 = new Dialog(SelectedActivity.this);
                dialog1.setContentView(R.layout.custom_dialog);
                dialog1.setCanceledOnTouchOutside(false);
                Button rs1 = (Button) dialog1.findViewById(R.id.rs1);
                Button rs2 = (Button) dialog1.findViewById(R.id.q1);
                rs1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        choiLai();
                        point.setText("0");
                        dialog1.cancel();
                        getWindow().getDecorView().setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                    }
                });
                rs2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                dialog1.show();
            }
        }
        @Override
        public void onFinish() {
            final Dialog dialog2 = new Dialog(SelectedActivity.this);
            dialog2.setContentView(R.layout.custom_dialog_2);
            dialog2.setCanceledOnTouchOutside(false);
            Button rs2 = (Button) dialog2.findViewById(R.id.rs2);
            Button q2 = (Button) dialog2.findViewById(R.id.q2);
            rs2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choiLai();
                    point.setText("0");
                    dialog2.cancel();
                    getWindow().getDecorView().setSystemUiVisibility(
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                }
            });
            q2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            dialog2.show();
        }
    };

    private void finishCountDownTimer() {
        if (socot == 4 && sohang == 4) {
            countDownTimer1.cancel();
        }
        else if (sohang == 5 && socot == 4) {
            countDownTimer2.cancel();
        }
        else if (socot == 4 && sohang == 6) {
            countDownTimer3.cancel();
        }
        else if (sohang == 6 && socot == 5) {
            countDownTimer4.cancel();
        }
        else if (socot == 6 && sohang == 6) {
            countDownTimer5.cancel();
        }
    }
}