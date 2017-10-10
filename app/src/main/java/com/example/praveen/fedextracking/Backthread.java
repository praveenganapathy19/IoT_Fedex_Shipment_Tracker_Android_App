package com.example.praveen.fedextracking;

import android.content.Context;
import android.os.AsyncTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import no.wtw.android.dijkstra.model.Vertex;

/**
 * Created by Praveen on 10/09/2017.
 */

//Asynchronous task with delay of 10s between each cycle
public class Backthread extends AsyncTask<Object,Void,Void> {
    DatabaseHelper myDb;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;

    @Override
    protected Void doInBackground(Object... params) {
        myDb = new DatabaseHelper((Context) params[2]);

        int linkWeight= (int) params[1];
        String ID=(String) params[3];
        LinkedList<Vertex> linkVertex= (LinkedList<Vertex>) params[0];

        for(int i=0;i<=linkWeight;i++)
        {
            date = new Date();
            myDb.updateData(ID,linkVertex.get(i).toString(),dateFormat.format(date));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return null;
    }
}
