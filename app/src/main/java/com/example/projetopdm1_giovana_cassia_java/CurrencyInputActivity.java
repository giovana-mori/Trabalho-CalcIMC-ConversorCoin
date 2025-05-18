package com.example.projetopdm1_giovana_cassia_java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CurrencyInputActivity extends AppCompatActivity {
    private EditText editTextValue;
    private Spinner spinnerFrom, spinnerTo;
    private Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_input);

        editTextValue = findViewById(R.id.editTextValue);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        buttonConvert = findViewById(R.id.buttonConvert);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        buttonConvert.setOnClickListener(v -> {
            if (editTextValue.getText().toString().isEmpty()) {
                Toast.makeText(this, "Digite um valor", Toast.LENGTH_SHORT).show();
                return;
            }

            double value = Double.parseDouble(editTextValue.getText().toString());
            String fromCurrency = spinnerFrom.getSelectedItem().toString();
            String toCurrency = spinnerTo.getSelectedItem().toString();

            Intent intent = new Intent(CurrencyInputActivity.this, CurrencyResultActivity.class);
            intent.putExtra("value", value);
            intent.putExtra("from", fromCurrency);
            intent.putExtra("to", toCurrency);
            startActivity(intent);
        });
    }
}