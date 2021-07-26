package com.example.disperse_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<reqs> list;

    public MyAdapter(Context context, ArrayList<reqs> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.teachers,parent, false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {

        reqs user = list.get(position);
        holder.fSubject.setText(user.getfSubject());
        holder.fClass.setText(user.getfClass());
        holder.fSalary.setText(user.getfSalary());
        holder.fLocation.setText(user.getfLocation());
        holder.fDay.setText(user.getfDay());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fSubject, fClass, fSalary, fDay, fLocation;

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);

            fSubject = itemView.findViewById(R.id.subject);
            fClass = itemView.findViewById(R.id.class_);
            fSalary = itemView.findViewById(R.id.salary);
            fDay = itemView.findViewById(R.id.day);
            fLocation = itemView.findViewById(R.id.location);
        }
    }
}
