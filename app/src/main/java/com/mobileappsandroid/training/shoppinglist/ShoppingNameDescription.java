package com.mobileappsandroid.training.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ShoppingNameDescription extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextDes;

    private DatabaseReference myRef = null;
    private FirebaseDatabase database = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_name_description);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDes = (EditText) findViewById(R.id.editTextDes);


        if (database == null)
        {
            database = FirebaseDatabase.getInstance();
        }

        if (myRef == null)
        {
            // The string argument is the parent preference
            myRef = database.getReference("ShopItem");
        }


    }

    public void saveItem(View view) {


        ShoppingItem shoppingItem = new ShoppingItem
                (editTextName.getText().toString(),
                        editTextDes.getText().toString());

        myRef = myRef.child(editTextName.getText().toString());

        myRef.setValue(shoppingItem);

        finish();

    }


}