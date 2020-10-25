package com.project.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner before, after;
    private List<String> list;
    private EditText amount;
    private TextView result;
    double usd = 1;
    double vnd = 23221.17;
    double eur = 0.842985;
    double yen = 104.696;
    double rub = 76.1265;
    double be =vnd;
    double af =vnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        before = findViewById(R.id.spinner_before);
        after = findViewById(R.id.spinner_after);
        amount = findViewById(R.id.edt_amount);
        result = findViewById(R.id.txt_result);

        list = new ArrayList<>();
        list.add("VND");
        list.add("USD");
        list.add("EUR");
        list.add("Yen");
        list.add("RUB");

        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);

        before.setAdapter(spinnerAdapter);
        after.setAdapter(spinnerAdapter);

        before.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                amount.setText("");
                result.setText("");
                switch (position) {
                    case 0:
                        be = vnd;
                        break;
                    case 1:
                        be = usd;
                        break;
                    case 2:
                        be = eur;
                        break;
                    case 3:
                        be = yen;
                        break;
                    case 4:
                        be = rub;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        after.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                amount.setText("");
                result.setText("");
                switch (position) {
                    case 0:
                        af = vnd;
                        break;
                    case 1:
                        af = usd;
                        break;
                    case 2:
                        af = eur;
                        break;
                    case 3:
                        af = yen;
                        break;
                    case 4:
                        af = rub;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double mResult = Double.valueOf(amount.getText().toString()) / be * af;
                result.setText("" + mResult);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}