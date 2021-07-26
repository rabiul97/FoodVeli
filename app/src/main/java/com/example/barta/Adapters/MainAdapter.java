package com.example.barta.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barta.DetailActivity;
import com.example.barta.Models.MainModel;
import com.example.barta.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>{

    ArrayList <MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MainAdapter.viewholder holder, int position) {

      final  MainModel model = list.get(position);
      holder.foodimage.setImageResource(model.getImage());
      holder.mainName.setText(model.getName());
      holder.price.setText(model.getPrice());
      holder.description.setText(model.getDescription());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(context , DetailActivity.class);
              intent.putExtra("image", model.getImage());
              intent.putExtra("price" ,model.getPrice());
              intent.putExtra("desc" ,model.getDescription());
              intent.putExtra("name" , model.getName());

              context.startActivity(intent);


          }
      });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView foodimage;
        TextView mainName,price,description;



        public viewholder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            foodimage = itemView.findViewById(R.id.orderimage);
            mainName = itemView.findViewById(R.id.orderitemName);
            price = itemView.findViewById(R.id.orderPrice);
           description= itemView.findViewById(R.id.description);
        }
    }

}


