package com.example.projetopdm1_giovana_cassia_java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {
    private Button buttonIMC, buttonCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        buttonIMC = findViewById(R.id.buttonIMC);
        buttonCurrency = findViewById(R.id.buttonCurrency);

        buttonIMC.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuActivity.this, IMCInputActivity.class);
            startActivity(intent);
        });

        buttonCurrency.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuActivity.this, CurrencyInputActivity.class);
            startActivity(intent);
        });
    }
}