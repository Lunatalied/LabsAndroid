package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import kotlin.experimental.ExperimentalTypeInference;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mealsListResycler;
    private Button buttonAddMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mealsListResycler = findViewById(R.id.recycleView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mealsListResycler.setLayoutManager(layoutManager);

        mealsListResycler.setHasFixedSize(true);

        buttonAddMeal = findViewById(R.id.buttonAddMeal);
        buttonAddMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddNewMealActivity.class);
                startActivity(intent);
            }
        });


        getMeals();
    }



    private void getMeals() {
        class GetMeals extends AsyncTask<Void, Void, List<Meals>> {

            @Override
            protected List<Meals> doInBackground(Void... voids) {
                AppDatabase database = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase();


                database.baseDao().insert(new Base(1, "????????"));
                database.baseDao().insert(new Base(2, "????????"));
                database.baseDao().insert(new Base(3, "??????????"));
                database.baseDao().insert(new Base(4, "??????????"));


                database.cuisineDao().insert(new Cuisine(1, "??????????????"));
                database.cuisineDao().insert(new Cuisine(2, "??????????????????????"));
                database.cuisineDao().insert(new Cuisine(3, "??????????????????"));


                database.mealTimeDao().insert(new MealTime(1, "??????????????"));
                database.mealTimeDao().insert(new MealTime(2, "????????"));
                database.mealTimeDao().insert(new MealTime(3, "????????"));
                database.mealTimeDao().insert(new MealTime(4, "??????????????"));

                database.typeDao().insert(new Type(1, "??????"));
                database.typeDao().insert(new Type(2, "??????????????"));
                database.typeDao().insert(new Type(3, "??????????????"));
                database.typeDao().insert(new Type(4, "????????????"));
                database.typeDao().insert(new Type(5, "??????????"));



                List<Meals> mealsList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .mealsDao()
                        .getAll();

                return mealsList;
            }

            @Override
            protected void onPostExecute(List<Meals> meals) {
                super.onPostExecute(meals);
                MealsAdapter adapter = new MealsAdapter(MainActivity.this, meals);
                mealsListResycler.setAdapter(adapter);
            }
        }

        GetMeals gm = new GetMeals();
        gm.execute();
    }

}



