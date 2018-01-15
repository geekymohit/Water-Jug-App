package com.example.mohit.waterjug;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int jugcap1,jugcap2,reqjugcap;
    EditText editText,editText2,editText3;
    RelativeLayout relativeLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = (EditText)findViewById(R.id.editText);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativelayout1);
        editText2 = (EditText)findViewById(R.id.editText2);

        editText3 = (EditText)findViewById(R.id.editText3);

        Button button = (Button)findViewById(R.id.button);

        //relativeLayout.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


                    if(editText.getText().toString()==null || editText2.getText().toString()==null || editText3.getText().toString()==null)
                    {
                        Toast.makeText(getApplicationContext(),"SOME INFORNMATION IS MISSING , TRY AGAIN ! ",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        jugcap1 = Integer.valueOf(editText.getText().toString());
                        jugcap2 = Integer.parseInt(editText2.getText().toString());
                        reqjugcap = Integer.parseInt(editText3.getText().toString());
                            WaterJugBFS waterJugBFS = new WaterJugBFS();
                            waterJugBFS.letsRoll(jugcap1,jugcap2,reqjugcap);
                            if(waterJugBFS.flag == 1 )
                            {
                                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                                intent.putExtra("jug1",jugcap1);
                                intent.putExtra("jug2",jugcap2);
                                intent.putExtra("jug3",reqjugcap);
                                startActivity(intent);

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"NOT POSSIBLE , TRY USING OTHER VALUES ",Toast.LENGTH_LONG).show();
                            }
                    }


                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /*@Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                }).create().show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.dfs) {
            relativeLayout.setVisibility(View.VISIBLE);

        } else if (id == R.id.introduction) {
            relativeLayout.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
            startActivity(intent);

        } else if (id == R.id.version) {
            relativeLayout.setVisibility(View.INVISIBLE);
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("VERSION")
                    .setMessage("This is version 1 of this app water jug ")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
