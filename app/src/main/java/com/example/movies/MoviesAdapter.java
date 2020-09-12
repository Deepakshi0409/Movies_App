package com.example.movies;

import android.content.Context;


import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
     private ArrayList<Movies> movie;
     private Context context;
    public MoviesAdapter( Context context) {
        this.context = context;
        movie = new ArrayList<>();
    }

    public void setData(ArrayList<Movies> movie) {
        this.movie = movie;
    }

    @NonNull
    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View articleView = inflater.inflate(R.layout.movies_list_item, parent, false);
        return new MyViewHolder(articleView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MyViewHolder holder, int position) {
        Movies movies = movie.get(position);
        holder.title.setText(movies.title);

        Glide.with(context).load(movies.getImageUrl()).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return movie.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
