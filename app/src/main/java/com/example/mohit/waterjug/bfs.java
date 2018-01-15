package com.example.mohit.waterjug;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mohit on 24-10-2017.
 */

public class bfs extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        //TextView textView8=(TextView)rootView.findViewById(R.id.textView8);
        String a = " Create a variable called NODELIST and set it to the initial state\n" +
                " Until a goal state is reached or NODELIST is empty\n" +
                "    a Remove the first element from NODELIST and call it E If NODELIST was empty  quit\n" +
                "    b For each way that each rule can match the state descibed in E do\n" +
                "        i Apply the rule to generate a new state\n" +
                "        ii If the new state is a goal state  quit  and return this state\n" +
                "        iii Otherwise  add the new state to the end of NODELIST";


        //textView8.setText(a.toString());
        return rootView;
    }
}
