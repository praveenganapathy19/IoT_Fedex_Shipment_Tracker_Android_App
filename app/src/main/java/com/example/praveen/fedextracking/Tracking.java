package com.example.praveen.fedextracking;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tracking extends AppCompatActivity {

    DatabaseHelper myDb;
    Button btnTracking;
    EditText txtTrack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);

        myDb = new DatabaseHelper(this);
        txtTrack=(EditText)findViewById(R.id.txtTrack);
        btnTracking=(Button)findViewById(R.id.btnTracking);
        viewAll();
    }
//Return dialog after returning the shipment details based on the tracking ID given
    public void viewAll() {
        btnTracking.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Cursor res = myDb.getAllData(txtTrack.getText().toString());
                        //Log.d("res", "res is : "+res.getCount());

                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","No Shipment Detail found!");
                            txtTrack.setText("");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Source :"+ res.getString(1)+"\n");
                            buffer.append("Destination :"+ res.getString(2)+"\n");
                            buffer.append("Sent on :"+ res.getString(3)+"\n");
                            buffer.append("Status : Reached "+ res.getString(4)+" at "+res.getString(5)+"\n");
                            buffer.append("Weight :"+ res.getString(6)+"\n");
                            buffer.append("Total Packets :"+ res.getString(7)+"\n\n");

                        }

                        // Show all data
                        showMessage("Shipment details",buffer.toString());
                        txtTrack.setText("");
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
