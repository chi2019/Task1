package com.example.chanakya.task1;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    Button button;

    public BlankFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View   v = inflater.inflate(R.layout.fragment_blank, container, false);

        button =  v.findViewById(R.id.buttonF1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // comm.sendData("hello");

                Bundle bundle = new Bundle();
                bundle.putString("data","hello");

                BlankFragment2 fragment2 = new BlankFragment2();


                int screenSize = getResources().getConfiguration().screenLayout &
                        Configuration.SCREENLAYOUT_SIZE_MASK;


                switch(screenSize) {
                    case Configuration.SCREENLAYOUT_SIZE_LARGE:
                        fragment2.setArguments(bundle);
                               getFragmentManager()
                                       .beginTransaction()
                                       .replace(R.id.frameLayout2,fragment2)
                                       .commit();

                        break;
                    case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                        fragment2.setArguments(bundle);

                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer1,fragment2)
                                .commit();
                        break;


                }

            }
        });


        return v;
    }


}
