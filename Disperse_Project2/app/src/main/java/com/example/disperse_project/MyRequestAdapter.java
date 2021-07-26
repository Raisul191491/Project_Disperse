package com.example.disperse_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRequestAdapter extends RecyclerView.Adapter<MyRequestAdapter.MyViewHolder> {

    ArrayList<requests> mList;
    Context context;

    public MyRequestAdapter(Context context, ArrayList<requests> mList) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyRequestAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.personal_requests, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRequestAdapter.MyViewHolder holder, int position) {

        requests Requests = mList.get(position);

        holder.classes.setText(Requests.getClasses());
        holder.days.setText(Requests.getDays());
        holder.location.setText(Requests.getLocation());
        holder.salary.setText(Requests.getSalary());
        holder.subject.setText(Requests.getSubject());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView subject, classes, days, salary, location;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            classes = itemView.findViewById(R.id.class_name);
            days = itemView.findViewById(R.id.day);
            location = itemView.findViewById(R.id.location_name);
            salary = itemView.findViewById(R.id.salary);
            subject = itemView.findViewById(R.id.subject);

        }
    }
}
