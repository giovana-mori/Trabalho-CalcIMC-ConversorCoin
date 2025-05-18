package com.example.projetopdm1_giovana_cassia_java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IMCInputActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_input);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(v -> {
            if (editTextWeight.getText().toString().isEmpty() ||
                    editTextHeight.getText().toString().isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            double weight = Double.parseDouble(editTextWeight.getText().toString());
            double height = Double.parseDouble(editTextHeight.getText().toString());

            Intent intent = new Intent(IMCInputActivity.this, IMCResultActivity.class);
            intent.putExtra("weight", weight);
            intent.putExtra("height", height);
            startActivity(intent);
        });
    }
}