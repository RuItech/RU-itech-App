package com.example.ru_itech.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ru_itech.R;
import com.example.ru_itech.Structure.RecyclerStructure;
import com.example.ru_itech.viewMore;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


private final Context mycontext;
final List<RecyclerStructure> items;


    public RecyclerAdapter(Context mycontext, List<RecyclerStructure> items) {
        this.mycontext = mycontext;
        this.items = items;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(mycontext).inflate(R.layout.itemload,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder Holder, int i) {

     final   int image = items.get(i).getImage();
       final String date = items.get(i).getDate();
       final String description = items.get(i).getDecription();
      final  String location = items.get(i).getLocation();
        Holder.SetData(image,location,description,date);


        Holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mycontext, viewMore.class);
                intent.putExtra("image",image);
                intent.putExtra("description",description);
                intent.putExtra("location",location);
                intent.putExtra("date",date);
                mycontext.startActivity(intent);

            }
        });



    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView date;
        private TextView description;
        private TextView location;
        private ImageView image;
        private  CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardview);
           date = itemView.findViewById(R.id.date);
           description = itemView.findViewById(R.id.description);
           location = itemView.findViewById(R.id.location);
           image = itemView.findViewById(R.id.image);




        }

        private void SetData(int Image,String Location,String Desription,String Date){
            image.setImageResource(Image);
            date.setText(Date);
            description.setText(Desription);
            location.setText(Location);


        }
    }



}
