package com.example.lab3;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealsAdapter.MealsViewHolder>{


        private Context mCtx;
        private List<Meals> mealsList;

        public MealsAdapter(Context mCtx, List<Meals> mealsList) {
            this.mCtx = mCtx;
            this.mealsList = mealsList;
        }

        @Override
        public MealsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mCtx).inflate(R.layout.recipe_item, parent, false);
            return new MealsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MealsViewHolder holder, int position) {
            Meals m = mealsList.get(position);
            holder.textViewName.setText(m.getNameMeal());
            holder.textViewKkal.setText(m.getKkal().toString());
        }

        @Override
        public int getItemCount() {
            return mealsList.size();
        }

        class MealsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView textViewName, textViewKkal;

            public MealsViewHolder(View itemView) {
                super(itemView);

                textViewName = itemView.findViewById(R.id.recipe_name);
                textViewKkal = itemView.findViewById(R.id.recipe_kkal);


                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                Meals meal = mealsList.get(getAdapterPosition());

                Intent intent = new Intent(mCtx, DeleteUpdateMealActivity.class);
                intent.putExtra("meal", meal);

                mCtx.startActivity(intent);
            }
        }
    }
