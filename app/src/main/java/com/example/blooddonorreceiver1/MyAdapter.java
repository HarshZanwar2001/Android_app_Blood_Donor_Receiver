package com.example.blooddonorreceiver1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context , ArrayList<Model> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.Name.setText(model.getName ());
        holder.Email.setText(model.getEmail());
        holder.Blood.setText(model.getBlood ());
        holder.City.setText(model.getCity ());
        holder.Address.setText(model.getAddress ());
        holder.Dob.setText(model.getDob ());
        holder.Gender.setText(model.getGender ());
        holder.Mobileno.setText(model.getMobileno ());
        holder.State.setText(model.getState ());




    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Name , Email, Blood , Gender, City, Mobileno, Address , Dob, State;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Address=itemView.findViewById (R.id.Daddress);
            Name = itemView.findViewById(R.id.Dname);
            Email = itemView.findViewById(R.id.Demail);
            Blood = itemView.findViewById(R.id.Dbloodg);
            City=itemView.findViewById (R.id.Dcity);
            Dob=itemView.findViewById (R.id.Ddob);
            Gender=itemView.findViewById (R.id.Dgender);
            Mobileno=itemView.findViewById (R.id.Dmobile);
            State=itemView.findViewById (R.id.Dstate);

        }
    }
}

