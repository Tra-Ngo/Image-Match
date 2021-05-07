package com.example.imagematch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends Activity {

    ListView listlevel;
    ArrayList<String> manglevel;
    String luachon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);

        listlevel = (ListView) findViewById(R.id.listViewLevel);

        manglevel = new ArrayList<>();
        manglevel.add(getResources().getString(R.string.l1));
        manglevel.add(getResources().getString(R.string.l2));
        manglevel.add(getResources().getString(R.string.l3));
        manglevel.add(getResources().getString(R.string.l4));
        manglevel.add(getResources().getString(R.string.l5));

        ArrayAdapter adapter = new ArrayAdapter(LevelActivity.this, android.R.layout.simple_list_item_1, manglevel);
        listlevel.setAdapter(adapter);

        listlevel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                luachon = manglevel.get(position);
                Intent intent = new Intent();
                intent.putExtra("levelchon", luachon);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
