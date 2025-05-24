package com.example.projetopdm1_giovana_cassia_java;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CurrencyResultActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_result);

        textViewResult = findViewById(R.id.textViewResult);

        double value = getIntent().getDoubleExtra("value", 0);
        String fromCurrency = getIntent().getStringExtra("from");
        String toCurrency = getIntent().getStringExtra("to");

        // Taxas de conversão fictícias
        double rate = getConversionRate(fromCurrency, toCurrency);
        double convertedValue = value * rate;

        String result = String.format("%.2f %s = %.2f %s",
                value, fromCurrency, convertedValue, toCurrency);
        textViewResult.setText(result);
    }

    private double getConversionRate(String from, String to) {
        // Taxas de conversão simplificadas
        if (from.equals(to)) return 1;

        if (from.equals("Real (BRL)") && to.equals("Dólar (USD)")) return 0.19;
        if (from.equals("Dólar (USD)") && to.equals("Real (BRL)")) return 5.25;
        if (from.equals("Real (BRL)") && to.equals("Euro (EUR)")) return 0.18;
        if (from.equals("Euro (EUR)") && to.equals("Real (BRL)")) return 5.60;
        if (from.equals("Dólar (USD)") && to.equals("Euro (EUR)")) return 0.95;
        if (from.equals("Euro (EUR)") && to.equals("Dólar (USD)")) return 1.05;

        return 1;
    }
    public void voltarTela(View view) {
        finish(); // Fecha a activity atual e volta para a anterior
    }
}