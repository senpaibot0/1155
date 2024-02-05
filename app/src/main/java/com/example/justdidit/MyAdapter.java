package com.example.justdidit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<String> titles;

    LayoutInflater inflater;

    public MyAdapter(Context ctx, List<String>titles ){
        this.titles = titles;
        this.inflater = LayoutInflater.from(ctx);
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tacheTitle);
        }
    }
}
