package com.example.week1_2ndmission;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.User;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.UserViewHolder>{

    private ArrayList<User> listUser;
    private Context context;
    
    public UserRVAdapter(ArrayList<User> listUser){
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.card_nama.setText(listUser.get(position).getNama());
        holder.card_umur.setText(String.valueOf(listUser.get(position).getUmur()));
        holder.card_kota.setText(listUser.get(position).getKota());

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView card_nama, card_umur, card_kota;
        private CardView detail_card;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            card_nama = itemView.findViewById(R.id.card_nama);
            card_umur = itemView.findViewById(R.id.card_umur);
            card_kota = itemView.findViewById(R.id.card_kota);
            detail_card = itemView.findViewById(R.id.detail_card);

            detail_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("profile", listUser.get(getAdapterPosition()));
                    intent.putExtra("index", getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}
