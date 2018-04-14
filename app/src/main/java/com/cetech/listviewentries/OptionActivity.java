package com.cetech.listviewentries;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
    }

    public void goAnimals (View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void goContacts (View view) {
        Intent i = new Intent(this, Contactctivity.class);
        startActivity(i);
    }
}
