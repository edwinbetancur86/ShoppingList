package com.mobileappsandroid.training.shoppinglist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobileappsandroid.training.shoppinglist.ButtonActivity;
import com.mobileappsandroid.training.shoppinglist.R;
import com.mobileappsandroid.training.shoppinglist.ShoppingItem;

import java.util.List;

/**
 * Created by ferna on 2/9/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyVH> {
    private List<ShoppingItem> mData;
    private Context context;
    private LayoutInflater inflater;
    private Button button;



    public MyAdapter(List<ShoppingItem> mData, Context context) {
        this.mData = mData;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        MyVH holder = new MyVH(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyVH holder, int position) {
        ShoppingItem current = mData.get(position);
        button = new Button(context);
        button.setText(current.getName());
        holder.linearLayout.addView(button);
        Log.d("onBind", current.getName());
        //holder.setData(current, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void cleanArray(){
        this.mData.clear();
    }


    public class MyVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        //private Button button;
        private ShoppingItem currentItem;
        private int position;
        private Intent i;
        private LinearLayout linearLayout;



        public MyVH(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linLayout);
            //button = new Button(context);
        }

        public void setData(ShoppingItem current, int position)
        {
            //this.button.setText(current.getName());
            i = new Intent(context, ButtonActivity.class);
            i.putExtra("itemName",current.getName());
            i.putExtra("itemDes", current.getDes());
            //linearLayout.addView(button);
            //this.name.setText(current.getName());
            //this.des.setText(current.getDes());
            this.currentItem = current;
            this.position = position;
        }

        public void setListeners(){
        button.setOnClickListener(MyVH.this);
            //shopItemButton.setOnClickListener(MyViewHolder.this);

        }

        @Override
        public void onClick(View v) {

            context.startActivity(i);
        }

    }


}
