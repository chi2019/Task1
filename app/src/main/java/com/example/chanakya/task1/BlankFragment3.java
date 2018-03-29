package com.example.chanakya.task1;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {

    MyBroadCastReciever myBroadCastReciever;
    ListView listView;
    ArrayList<String > list;
    ArrayAdapter<String> adapter;

    public BlankFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);

        listView = v.findViewById(R.id.listView);


        myBroadCastReciever = new MyBroadCastReciever();

        IntentFilter intentFilter = new IntentFilter("android.intent.action.MAIN");
                     intentFilter.addCategory(Intent.CATEGORY_DEFAULT);

                      getActivity().registerReceiver(myBroadCastReciever,intentFilter);


        return v;
    }


     public class MyBroadCastReciever extends BroadcastReceiver{

         @Override
         public void onReceive(Context context, Intent intent) {


             list = new ArrayList<>();
             list = intent.getStringArrayListExtra("listdata");

           Log.e("list",list.get(0).toString());

           adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list);
           listView.setAdapter(adapter);

         }

     }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        getActivity().unregisterReceiver(myBroadCastReciever);
    }
}

