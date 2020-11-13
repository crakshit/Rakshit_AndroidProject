package com.example.rakshit_project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<Product> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent myIntent = getIntent();

//        mDataset = new ArrayList<String>();
//        mDataset.add("Bill Gates");
//        mDataset.add("Bill Gates");
//        mDataset.add("Bill Gates");
//        mDataset.add("Bill Gates");

        mDataset=new ArrayList<>();
        recyclerView = findViewById(R.id.productRecycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mDataset.add(new Product(R.drawable.sanmarcos,"San Marcos","This coffee is sourced from a cooperative located in Ocotepeque’s Sensenti valley, known as the Beneficio San Marcos. Like most coffee producing regions in Honduras, smallholder farmers are organized into coops to benefit from shared access to resources, infrastructure, certifications.", "milk chocolate, dates, sugary plum", (float) 19.2));
        mDataset.add(new Product(R.drawable.jerico,"Jericó","This coffee is sourced from a collective of 19 independent farmers located in Jericó, in the colombian department of Antioquia. The small town has a rich coffee culture but limited access to resources. As such, these 19 dedicated farmers came together to collectively produce a consistent, high-quality naturally processed coffee, known as the Naturals Community Project. Each farmer produces their own cherries, but they all work together to hand-select, soak and sun-dry their lots.", "strawberry, raspberry jam, chocolate",(float) 19.2));
        mDataset.add(new Product(R.drawable.cosmicgoose,"Cosmic Goose","This coffee is sourced from family-owned farms organized around ASEMPROGROPE, an organization operating within the department of Tolima, Colombia. On average, each producer cultivates coffee on 1.5 hectares of land and relies on the income from coffee production for a living. The current president of ASEMPROGROPE is a woman focused on improving the participation of women in the organization.", "dried fig, yellow plum, chocolate",(float) 19.2));
        mDataset.add(new Product(R.drawable.decaf,"Decaf","The Sugar Cane Process, which originates in Colombia where sugar cane grows in abundance, avoids disrupting the bean’s cellular structure and even enhances the sweetness of the final cup, removing roughly 97% of the caffeine content. Due to the fermented molasses from the sugar cane, this process creates beans with a pleasant, clean, and sweet flavour.", "toffee, hazelnut, golden raisin",(float) 19.2));
        //mDataset.add(new Product(R.drawable.decaf,"Coffee","This is coffee.", (float) 19.2));



        mAdapter = new MyAdapter(mDataset, ProductActivity.this);
        recyclerView.setAdapter(mAdapter);

    }
}
