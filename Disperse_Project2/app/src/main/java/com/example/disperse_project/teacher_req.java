package com.example.disperse_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class teacher_req extends AppCompatActivity {

    RecyclerView mRecyclerView;
    DatabaseReference mDatabaseReference;
    MyAdapter mMyAdapter;
    ArrayList<reqs> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_req);

        mRecyclerView = findViewById(R.id.teacher_list);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users");
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        mMyAdapter = new MyAdapter(this,list);
        mRecyclerView.setAdapter(mMyAdapter);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    reqs user = dataSnapshot.getValue(reqs.class);
                    list.add(user);
                }

                mMyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}