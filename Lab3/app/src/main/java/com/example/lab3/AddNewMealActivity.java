package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddNewMealActivity extends AppCompatActivity {

    private Spinner baseSpinner, cuisineSpinner, mealTimeSpinner, typeSpinner;
    private EditText nameEditText;
    private EditText kkalEditText;

    private Button createMeal;

    private int selectedBase, selectedCuisine, selectedMealTime, selectedType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_meal);

        baseSpinner = findViewById(R.id.baseSpinner);
        cuisineSpinner = findViewById(R.id.cuisineSpinner);
        mealTimeSpinner = findViewById(R.id.mealTimeSpinner);
        typeSpinner = findViewById(R.id.typeSpinner);
        nameEditText = findViewById(R.id.nameEditText);
        kkalEditText = findViewById(R.id.kkalEditText);

        getDataForSpinners();

        createMeal = findViewById(R.id.createMeal);
        createMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMeal();
            }
        });

        baseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                selectedBase = selectedItemPosition + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        cuisineSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                selectedCuisine = selectedItemPosition + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mealTimeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                selectedMealTime = selectedItemPosition + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                selectedType = selectedItemPosition + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void saveMeal(){
        String name = ((EditText)findViewById(R.id.nameEditText)).getText().toString().trim();
        int kkal = Integer.parseInt(((EditText)findViewById(R.id.kkalEditText)).getText().toString().trim());

        if (name.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Название блюда не заполнено", Toast.LENGTH_LONG).show();
            return;
        }

        if (kkal == 0) {
            Toast.makeText(getApplicationContext(), "Калории не заполнены", Toast.LENGTH_LONG).show();
            return;
        }

        class creatingNewMeal extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                int baseId = selectedBase;
                int cuisineId = selectedCuisine;
                int mealTimeId = selectedMealTime;
                int typeId = selectedType;

                Meals newMeal = new Meals();
                newMeal.setNameMeal(name);
                newMeal.setKkal(kkal);
                newMeal.setBase(baseId);
                newMeal.setMealTime(mealTimeId);
                newMeal.setCuisine(cuisineId);
                newMeal.setType(typeId);

                DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .mealsDao()
                        .insert(newMeal);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Created", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(AddNewMealActivity.this, MainActivity.class));
            }
        }
        creatingNewMeal cm = new creatingNewMeal();
        cm.execute();
    }

    private void getDataForSpinners() {
        class fillSpinners extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {


                List<Base> baseList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .baseDao()
                        .getAll();

                List<Cuisine> cuisineList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .cuisineDao()
                        .getAll();

                List<MealTime> mealTimeList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .mealTimeDao()
                        .getAll();

                List<Type> typeList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .typeDao()
                        .getAll();

                List<String> baseData = new ArrayList<String>();
                List<String> cuisineData = new ArrayList<String>();
                List<String> mealTimeData = new ArrayList<String>();
                List<String> typeData = new ArrayList<String>();

                for (Iterator<Base> i = baseList.iterator(); i.hasNext(); ) {
                    Base p = i.next();
                    baseData.add(p.getMainIngredient());
                }

                for (Iterator<Cuisine> i = cuisineList.iterator(); i.hasNext(); ) {
                    Cuisine p = i.next();
                    cuisineData.add(p.getTypeCuisine());
                }

                for (Iterator<MealTime> i = mealTimeList.iterator(); i.hasNext(); ) {
                    MealTime p = i.next();
                    mealTimeData.add(p.getMealtime());
                }

                for (Iterator<Type> i = typeList.iterator(); i.hasNext(); ) {
                    Type p = i.next();
                    typeData.add(p.getType());
                }

                ArrayAdapter<String> baseDataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, baseData);
                baseDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                baseSpinner.setAdapter(baseDataAdapter);

                ArrayAdapter<String> cuisineDataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, cuisineData);
                cuisineDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                cuisineSpinner.setAdapter(cuisineDataAdapter);

                ArrayAdapter<String> mealTimeDataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, mealTimeData);
                mealTimeDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mealTimeSpinner.setAdapter(mealTimeDataAdapter);

                ArrayAdapter<String> typeDataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, typeData);
                typeDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                typeSpinner.setAdapter(typeDataAdapter);

                return null;
            }

        }

        fillSpinners fs = new fillSpinners();
        fs.execute();
    }
}