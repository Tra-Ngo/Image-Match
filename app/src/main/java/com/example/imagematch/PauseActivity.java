package com.example.imagematch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PauseActivity extends Activity {

    Button btncontinue;
    Button btnrestart;
    Button btnquit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        setContentView(R.layout.activity_pause);

        btncontinue = (Button) findViewById(R.id.buttonContinue);
        btnrestart = (Button) findViewById(R.id.buttonRestart);
        btnquit = (Button) findViewById(R.id.buttonQuit);

        btnquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("luachon", "3");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnrestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("luachon", "2");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("luachon", "1");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        setFinishOnTouchOutside(false);
    }
}
