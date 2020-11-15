package com.example.rakshit_project1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Product> mDataset;
    Context context;


    public MyAdapter(List<Product> mDataset, Context context) {
        this.mDataset = mDataset;
        this.context = context;
    }

    public MyAdapter(List<Product> mDataset) {
        this.mDataset = mDataset;
    }

/*
    public MyAdapter(List<Product> myDataset)
    {
        this.mDataset = myDataset;
    }
*/

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView product_image;
        TextView product_name, product_flavours, product_price;
        ConstraintLayout product_layout;

        public MyViewHolder (View productView) {
            super(productView);
            product_name = productView.findViewById(R.id.product_name);
            product_flavours = productView.findViewById(R.id.product_flavours);
            product_price = productView.findViewById(R.id.product_price);
            product_image = productView.findViewById(R.id.product_image);
            product_layout = productView.findViewById(R.id.product_layout);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        final Product product = mDataset.get(position);
        holder.product_name.setText(product.getItem_name());
        holder.product_flavours.setText(product.getItem_flavours());
        holder.product_price.setText(String.valueOf(product.getPrice()));
        holder.product_image.setImageResource(product.getImage());


        holder.product_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("image",product.getImage());
                intent.putExtra("flavours",product.getItem_flavours());
                intent.putExtra("price",String.valueOf(product.getPrice()));
                intent.putExtra("description",product.getItem_description());
                intent.putExtra("name",product.getItem_name());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return mDataset.size();
    }

}
