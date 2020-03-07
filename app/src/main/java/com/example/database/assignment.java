package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.*;
import com.example.database.database.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class assignment extends AppCompatActivity {
    TextView coursetitle;
    TextView coursenumber;
  //  protected ListView listviewitems;
    String z;
  //  protected FloatingActionButton actionbutton3;
  //  ArrayList<String> coursesListtext = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
       // listviewitems = findViewById(R.id.listviewitems);
        //actionbutton3 = findViewById(R.id.actionbutton3);
        coursetitle = (TextView) findViewById(R.id.coursetitle);
        coursenumber = (TextView) findViewById(R.id.coursenumber);
        //retrieving the course title and course code from the list array that is passed from main activity
        String temptitle = getIntent().getStringExtra("courset");


        String[] stringsArray = temptitle.split("\n");
        coursetitle.setText(stringsArray[0]);
        coursenumber.setText(stringsArray[1]);
        String level=stringsArray[2];

        String number  = level.replaceAll("[^0-9-.]", "");
       double  y = Double.parseDouble(String.valueOf(number));
       // Toast.makeText(getApplicationContext(), y, Toast.LENGTH_SHORT).show();
        ImageView conatiner=(ImageView) findViewById(R.id.container);

       // new DecimalFormat("##.##").format((y));
        if (y>=70)
        {int imageResource=getResources().getIdentifier("@drawable/full",null,this.getPackageName());
        conatiner.setImageResource(imageResource);
            Toast.makeText(getApplicationContext(), "The Tank is full", Toast.LENGTH_SHORT).show();}
        else if (y>=20 && y<=70)
        {int imageResource=getResources().getIdentifier("@drawable/half",null,this.getPackageName());
            conatiner.setImageResource(imageResource);
            Toast.makeText(getApplicationContext(), "The Tank is half", Toast.LENGTH_SHORT).show();}
        else if (y<20)
        {int imageResource=getResources().getIdentifier("@drawable/empty",null,this.getPackageName());
            conatiner.setImageResource(imageResource);
            Toast.makeText(getApplicationContext(), "The Tank is empty", Toast.LENGTH_SHORT).show();}
    };


}



