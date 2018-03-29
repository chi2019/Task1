package com.example.chanakya.task1;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    TextView tv;
    Bundle bundle;
    String result;
    Button button;
    ArrayList<String> list;


    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
           result = getArguments().getString("data");
           Log.i("result",result);
        }


    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View  v = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        // this.v = v;
        tv = (TextView) v.findViewById(R.id.textView);

        if(result != null) {
            tv.setText(result);
        }

        list = new ArrayList<>();

        list.add("hi");
        list.add("hello");
        list.add("hate");
        list.add("hi");
        list.add("hello");
        list.add("hate");
        list.add("hi");
        list.add("hello");
        list.add("hate");

        button = v.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     Intent intent = new Intent(getContext(),MyIntentService.class);
                          intent.putStringArrayListExtra("list",list);


                int screenSize = getResources().getConfiguration().screenLayout &
                        Configuration.SCREENLAYOUT_SIZE_MASK;


                switch(screenSize) {
                    case Configuration.SCREENLAYOUT_SIZE_LARGE:
                        getContext().startService(intent);
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayout3,new BlankFragment3())
                                .commit();
                        break;
                    case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                        getContext().startService(intent);
                            getFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.fragmentContainer1,new BlankFragment3())
                                    .commit();

                        break;


                }
            }
        });


        return v;
    }






}
