package com.mobileappsandroid.training.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ButtonActivity extends AppCompatActivity {

    private TextView textViewName;
    private EditText editTextDes;
    private FirebaseDatabase database = null;
    private Intent i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        editTextDes = (EditText) findViewById(R.id.editTextDes1);
        textViewName = (TextView) findViewById(R.id.textViewName1);
        textViewName = (TextView) findViewById(R.id.textViewName1);
        editTextDes = (EditText) findViewById(R.id.editTextDes1);

        if (database == null)
        {
            database = FirebaseDatabase.getInstance();
        }

        i = getIntent();

        textViewName.setText(i.getStringExtra("itemName"));

        editTextDes.setText(i.getStringExtra("itemDes"));

    }


    public void saveDes(View view) {


        database.getReference("ShopItem")
                .child(i.getStringExtra("itemName"))
                .child("des").setValue(editTextDes.getText()
                .toString());

        finish();

    }

    public void deleteItem(View view) {

        database.getReference("ShopItem").child(i.getStringExtra("itemName"))
                .addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().removeValue();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("TodoApp", "getUser:onCancelled", databaseError.toException());
                    }
                });

        finish();

    }


}