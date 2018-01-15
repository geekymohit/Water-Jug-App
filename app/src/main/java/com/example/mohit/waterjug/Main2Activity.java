package com.example.mohit.waterjug;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle intent =getIntent().getExtras();
        int jug1 = intent.getInt("jug1");
        int jug2 = intent.getInt("jug2");
        int jug3 = intent.getInt("jug3");
        TextView editText = (TextView) findViewById(R.id.textView12);
        WaterJugBFS waterJugBFS = new WaterJugBFS();
        waterJugBFS.letsRoll(jug1,jug2,jug3);
        System.out.println(waterJugBFS.finalPath);

        editText.setText("J1   J2\n\n" + waterJugBFS.finalPath.toString() +"\n GOAL STATE  \n\n\n" );

    }
}
