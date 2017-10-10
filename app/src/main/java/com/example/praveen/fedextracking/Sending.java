package com.example.praveen.fedextracking;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.LinkedList;

import no.wtw.android.dijkstra.model.Vertex;


public class Sending extends AppCompatActivity {

    DatabaseHelper myDb;
    Button btnSend;
    Spinner sourceSpinner,destSpinner;
    EditText editWeight,editTotPacket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending);


        myDb = new DatabaseHelper(this);

        editWeight=(EditText)findViewById(R.id.editText);
        editTotPacket=(EditText)findViewById(R.id.editText2);
        btnSend=(Button)findViewById(R.id.btnSend);
        sourceSpinner=(Spinner)findViewById(R.id.spinner4);
        destSpinner=(Spinner)findViewById(R.id.spinner5);
        AddData();
    }

    //On clicking the Send button, packet is created with all the details, returning the tracking ID for reference
    public  void AddData() {

        btnSend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlgorithmLink al=new AlgorithmLink(sourceSpinner.getSelectedItem().toString(),destSpinner.getSelectedItem().toString());

                        Backthread bt=new Backthread();
                        LinkedList<Vertex> linkvertex;
                        int linkWeight;
                        String ID="";
                        boolean isInserted = myDb.insertData(sourceSpinner.getSelectedItem().toString(),
                                destSpinner.getSelectedItem().toString(),
                                editWeight.getText().toString(),
                                editTotPacket.getText().toString());
                        Cursor res = myDb.getID();

                        if(isInserted == true) {
                            while (res.moveToNext()) {
                                packetCreateMessage("Shipment created", "Shipment initiated with Tracking No.: " + res.getString(0));
                                ID=res.getString(0);
                            }
                            sourceSpinner.setSelection(0);
                            destSpinner.setSelection(0);
                            editWeight.setText("");
                            editTotPacket.setText("");
                        }
                        else
                            packetCreateMessage("Error","Shipment not created!  ");

                        linkvertex=al.linkPath();
                        linkWeight=al.linkWeight();

                        bt.execute(linkvertex,linkWeight,Sending.this,ID);

                    }
                }
        );
    }

    //for displaying the alert dialog box
    public void packetCreateMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
