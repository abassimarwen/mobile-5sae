package com.example.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.HomeActivity;
import com.example.app.R;
import com.example.app.entity.Pet;
import com.example.app.entity.Publication;
import com.example.app.entity.Toy;

import java.util.List;

public  class PublicationAdapter extends RecyclerView.Adapter<PublicationAdapter.MyViewHolder> {
    List<Toy> toys;
    Context context;

    public PublicationAdapter(List<Toy> toys, Context context) {
        this.toys = toys;
        this.context = context;
    }

    @NonNull
    @Override
    public PublicationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.toy_item,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicationAdapter.MyViewHolder holder, int position) {
        Intent intent = new Intent(context, HomeActivity.class);
        holder.title.setText(toys.get(position).getTitle());
        holder.desc.setText(toys.get(position).getDescription());
        holder.brand.setText(toys.get(position).getBrand());
        holder.max.setInputType(toys.get(position).getMaxAgeRange());
        holder.min.setInputType(toys.get(position).getMinAgeRange());



        holder.itemView.setOnClickListener(e->{
            intent.putExtra("title",toys.get(position).getTitle());
            intent.putExtra("description",toys.get(position).getDescription());
            intent.putExtra("brand",toys.get(position).getBrand());
            intent.putExtra("maxAgeRange",toys.get(position).getMaxAgeRange());
            intent.putExtra("minAgeRange",toys.get(position).getMinAgeRange());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return toys.size();
    }
    public void notifyChange(List<Toy> toys){
        this.toys = toys;
        this.notifyDataSetChanged();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,desc,brand,max,min;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_title_toy);
            desc = itemView.findViewById(R.id.item_description_toy);
            brand = itemView.findViewById(R.id.brand);
            max = itemView.findViewById(R.id.max_age);
            min = itemView.findViewById(R.id.min_age);
        }}
   
}
