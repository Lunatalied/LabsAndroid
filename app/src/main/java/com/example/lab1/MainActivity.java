package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textForLink;
    private Button goLink;
    private TextView textForButton;
    private Button goToActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textForLink = findViewById(R.id.textForLink);
        goLink = findViewById(R.id.goLink);
        textForButton = findViewById(R.id.textForButton);
        goToActivity = findViewById(R.id.goToActivity);

        goToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this, ActivityWithLink.class);
                startActivity(i);
            }
        });


        Bundle arg = getIntent().getExtras();
        if (arg != null){
            textForLink.setText(arg.get("link").toString());
        }


        goLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {D:
                    Uri uriUrl = Uri.parse(textForLink.getText().toString());
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    launchBrowser.addCategory(Intent.CATEGORY_BROWSABLE);
                    if (launchBrowser.resolveActivity(getPackageManager()) != null) {
                        startActivity(launchBrowser);
                    } else {
                        Toast.makeText(getApplicationContext(), "Browser has not found", Toast.LENGTH_LONG).show();
                    }
            }
        });

    }

}

