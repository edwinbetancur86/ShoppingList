package com.mobileappsandroid.training.shoppinglist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Intent i;
    private ScrollView scrollView;
    private LinearLayout ll = null;
    private List<ShoppingItem> shoppingList;
    //private View.OnClickListener listener;
    private FirebaseDatabase database = null;
    private DatabaseReference myRef = null;
    private RecyclerView recyclerView;
    private MyAdapter mA;
    private ShoppingItem shoppingItem;
    private  int position = 0;
    private Context contexto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shoppingList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rView);
        RecyclerView.LayoutManager lM = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lM);
        contexto=this;
        mA = new MyAdapter(shoppingList, contexto);
        recyclerView.setAdapter(mA);

        //recyclerView.setAdapter(mA);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(layoutManager);




//        if (database == null)
//        {
//            database = FirebaseDatabase.getInstance();
//        }
//
//        if (myRef == null)
//        {
//            myRef = database.getReference("ShopItem");
//        }



            database = FirebaseDatabase.getInstance();
            myRef = database.getReference().child("ShopItem");
            // Read from the database
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    shoppingList.clear();
                    //Iterable<DataSnapshot> value = dataSnapshot.getChildren();

                    mA.cleanArray();
                    mA.notifyDataSetChanged();
                    for (DataSnapshot dataSnapshotChild : dataSnapshot.getChildren()) {

                        shoppingItem = dataSnapshotChild.getValue(ShoppingItem.class);



                    /*listener = new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(MainActivity.this, ButtonActivity.class);
                            i.putExtra("itemName", shoppingItem.getName());
                            i.putExtra("itemDes", shoppingItem.getDes());
                            startActivity(i);
                        }
                    };*/





                        mA.notifyDataSetChanged();
                        shoppingList.add(shoppingItem);
//                        recyclerView.setAdapter(mA);

                    }

                    Log.d("test", String.valueOf(shoppingList.size()));


                }
                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("TAG", "Failed to read value.", error.toException());
                }
            });














        /*if (ll == null)
        {
            ll = new LinearLayout(MainActivity.this);

            ll.setLayoutParams(new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
            ll.setOrientation(LinearLayout.VERTICAL);
            scrollView.addView(ll);
        }


            // Read from the database
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    Iterable<DataSnapshot> value = dataSnapshot.getChildren();


                    for (DataSnapshot dataSnapshotChild : value) {
                        Button b = new Button(MainActivity.this);

                        final ShoppingItem shoppingItem = dataSnapshotChild.getValue(ShoppingItem.class);

                        b.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT));
                        b.setText(shoppingItem.getName());

                        b.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(MainActivity.this, ButtonActivity.class);
                                i.putExtra("itemName", shoppingItem.getName());
                                i.putExtra("itemDes", shoppingItem.getDes());
                                startActivity(i);
                            }
                        });

                        button.add(b);

                        ll.addView(b);


                    }
                }
                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("TAG", "Failed to read value.", error.toException());
                }
            });*/


    }

    @Override
    protected void onStop() {
        super.onStop();
        //shoppingList.clear();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //shoppingList.clear();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //shoppingList.clear();


        /*ll.removeAllViews();

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> value = dataSnapshot.getChildren();


                for (DataSnapshot dataSnapshotChild : value) {
                    Button b = new Button(MainActivity.this);

                    final ShoppingItem shoppingItem = dataSnapshotChild.getValue(ShoppingItem.class);

                    b.setLayoutParams(new LinearLayout.LayoutParams
                            (LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT));
                    b.setText(shoppingItem.getName());

                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(MainActivity.this, ButtonActivity.class);
                            i.putExtra("itemName", shoppingItem.getName());
                            i.putExtra("itemDes", shoppingItem.getDes());
                            startActivity(i);
                        }
                    });

                    button.add(b);

                    ll.addView(b);


                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });*/


    }


    public void goAddShopItem(View view) {

        i = new Intent(this, ShoppingNameDescription.class);
        startActivity(i);

    }


}
