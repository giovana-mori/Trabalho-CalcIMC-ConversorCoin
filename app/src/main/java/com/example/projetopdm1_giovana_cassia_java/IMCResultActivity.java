package com.example.projetopdm1_giovana_cassia_java;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IMCResultActivity extends AppCompatActivity {
    private TextView textViewResult, textViewClassification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_result);

        textViewResult = findViewById(R.id.textViewResult);
        textViewClassification = findViewById(R.id.textViewClassification);

        double weight = getIntent().getDoubleExtra("weight", 0);
        double height = getIntent().getDoubleExtra("height", 0);

        double imc = weight / (height * height);
        String classification = getIMCClassification(imc);

        textViewResult.setText(String.format("Seu IMC: %.2f", imc));
        textViewClassification.setText(classification);
    }

    private String getIMCClassification(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        else if (imc < 25) return "Peso normal";
        else if (imc < 30) return "Sobrepeso";
        else if (imc < 35) return "Obesidade grau I";
        else if (imc < 40) return "Obesidade grau II";
        else return "Obesidade grau III";
    }
}