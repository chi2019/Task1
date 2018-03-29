package com.example.chanakya.task1;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by chanakya on 3/29/2018.
 */

public class MyIntentService extends IntentService{

    ArrayList<String> list = new ArrayList<>();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */



    public MyIntentService(String name) {
        super(name);
    }


    public MyIntentService(){

        super("MyIntent service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        list = intent.getStringArrayListExtra("list");



        Intent i = new Intent();
        i.putStringArrayListExtra("listdata",list);
        i.setAction("android.intent.action.MAIN");
        i.addCategory(Intent.CATEGORY_DEFAULT);

        sendBroadcast(i);



    }


}
