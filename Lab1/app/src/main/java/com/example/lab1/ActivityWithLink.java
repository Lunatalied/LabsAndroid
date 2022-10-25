package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityWithLink extends AppCompatActivity {

    private EditText inputLink;
    private Button saveLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_link);

        saveLink = findViewById(R.id.saveLink);
        saveLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLink = findViewById(R.id.inputLink);

                String link = inputLink.getText().toString();
                Intent intent = new Intent(ActivityWithLink.this, MainActivity.class);
                intent.putExtra("link", link);
                startActivity(intent);
            }
        });
    }

}