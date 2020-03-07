package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.database.database.Config;
import com.example.database.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;
public class insertassignfrag extends DialogFragment {

    protected EditText assigntile;
    protected EditText assigngrade;
    protected Button savebutton;
    protected Button cancelbutton;

    @Nullable


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

    View view=inflater.inflate(R.layout.fragment_assignment,container,true);

        assigntile= view.findViewById(R.id.assigntile);
        assigngrade=view.findViewById(R.id.assigngrade);
         savebutton=view.findViewById(R.id.savebutton);
        cancelbutton=view.findViewById(R.id.cancelbutton);
        savebutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String titleR = assigntile.getText().toString();

        String codeR = assigngrade.getText().toString();
        Double coded=Double.valueOf(codeR);
       //Here I was trying to get the arguments that i have passed from the assignment which are the course title and course code. So I will add to them the assignment number and assignment grade and send it as a
        //course the database to add it or modify the course.

        // Bundle b2=getArguments();
        //String myStr = getArguments().getString("coursecode");
       // String codee=b2.getString("coursecode");
       // Toast toast = Toast.makeText(getActivity(), myStr, Toast.LENGTH_SHORT);

       // String myValue = this.getArguments().getString("message");
//        String titlec=b3.getString("coursetitle");


        //The save button will call the update function in the database and send the whole course to it
        //DatabaseHelper dbhelper = new DatabaseHelper(getActivity());
        //dbhelper.updateCourse(new Course(titlec,codee,titleR,coded));

           //((assignment)getActivity()).loadlistview();//back to the assignment page

           // getDialog().dismiss();

        }

});
        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
getDialog().dismiss();
            }
        });


    return view;
    }
}
