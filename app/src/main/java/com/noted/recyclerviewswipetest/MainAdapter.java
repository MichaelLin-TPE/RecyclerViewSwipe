package com.noted.recyclerviewswipetest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<String> dataArrayList;

    public MainAdapter(){

    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final String name = dataArrayList.get(position);
        holder.tvName.setText(name);
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public void setData(ArrayList<String> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    public void removeItem(int position) {
        dataArrayList.remove(position);
        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;

        private ConstraintLayout touchArea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.item_text);
            touchArea = itemView.findViewById(R.id.touch_area);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(String name);
    }

}
