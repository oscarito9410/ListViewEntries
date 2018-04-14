package com.cetech.listviewentries;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listAnimals;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAnimals = (ListView) findViewById(R.id.list_animals);
        listAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView <?> adapterView, View view, int position, long ld) {

                String animal = getResources().getStringArray(R.array.animales)[position];


                MediaPlayer player=MediaPlayer.create
                         (MainActivity.this,
                                 R.raw.dog);
                player.start();
            }
        });
    }
}
