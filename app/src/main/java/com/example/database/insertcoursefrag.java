package com.example.database;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.widget.Toast;
import com.example.database.database.DatabaseHelper;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class insertcoursefrag extends DialogFragment {

    protected EditText coursetitle;
    protected EditText coursecode;
    protected Button savebutton;
    protected Button cancelbutton;

    protected RadioGroup radioGroup;
    @Nullable

int idradio=-1;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);

        coursetitle = view.findViewById(R.id.coursetitle);
        coursecode = view.findViewById(R.id.coursecode);
        savebutton = view.findViewById(R.id.savebutton);
        cancelbutton = view.findViewById(R.id.cancelbutton);



        savebutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        //i will add a full course with no assignment nor grade and later on i will modify the assignment name with the new name and the new grade
//try{

      String title = coursetitle.getText().toString();
        String code = coursecode.getText().toString();
        DatabaseHelper dbhelper = new DatabaseHelper(getActivity());
        Toast.makeText(getActivity(), "the radio value before if " + idradio, Toast.LENGTH_SHORT).show();
        if (!(title.equals("") || code.equals("")))
        {

            { if(idradio>0)
            { if (idradio==1)
            {double m;
            double r = Double.parseDouble(String.valueOf(code));
                m=r*2.14;
                String tmpStr11 = String.valueOf(m);
                Toast.makeText(getActivity(), "the tank height in Centim is " + tmpStr11, Toast.LENGTH_SHORT).show();
                dbhelper.insertCourse(new Course(title,tmpStr11));
                 ((MainActivity)getActivity()).coursesListtext.clear();//clears the array so it wont be repeated
                ((MainActivity)getActivity()).coursesListtextinch.clear();
            ((MainActivity)getActivity()).loadlistview();

            getDialog().dismiss();
            }
            else if(idradio==2)
            {

                dbhelper.insertCourse(new Course(title,code));
                ((MainActivity)getActivity()).coursesListtext.clear();//clears the array so it wont be repeated
                ((MainActivity)getActivity()).coursesListtextinch.clear();
                ((MainActivity)getActivity()).loadlistview();

                getDialog().dismiss();

            }
       }}
        }
}

});
        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        getDialog().dismiss();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch(checkedId) {
                    case R.id.radio_one:

                        idradio=1;
                        break;
                    case R.id.radio_two:
                        // Fragment 2
                        idradio=2;
                        break;
                }
                Toast.makeText(getActivity(), "Selected Radio Button: " + idradio, Toast.LENGTH_SHORT).show();}
        });


    return view;
    }

}
