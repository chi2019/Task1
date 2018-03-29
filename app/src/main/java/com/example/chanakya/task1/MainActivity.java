package com.example.chanakya.task1;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        switch(screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_LARGE:

                  getSupportFragmentManager()
                          .beginTransaction()
                          .replace(R.id.frameLayout1,new BlankFragment(),"f1")
                          .commit();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout2, new BlankFragment2(),"f2")
                        .commit();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout3, new BlankFragment3(),"f3")
                        .commit();


                break;
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer1, new BlankFragment() , "f1")
                        .commit();

                break;
            case Configuration.SCREENLAYOUT_SIZE_SMALL:

                break;
            default:

        }




    }




}
