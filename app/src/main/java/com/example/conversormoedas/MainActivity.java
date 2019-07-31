package com.example.conversormoedas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editValue;
    TextView textDollar;
    TextView textEuro;
    Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        editValue =  findViewById(R.id.edit_value);
        textDollar =  findViewById(R.id.text_dollar);
        textEuro =  findViewById(R.id.text_euro);
        buttonCalculate = findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonCalculaConversao();
            }
        });

    this.clearValues();

    Intent intent = new Intent(this, ConversorActivity.class);
    startActivity(intent);

    }

    private void buttonCalculaConversao() {
        try {
            Conversor dollar = new Conversor(Double.valueOf(editValue.getText().toString()), new Moeda("USD", 3.78));
            textDollar.setText(String.valueOf("$" + String.format("%.2f", dollar.Converte()))+ dollar.getMoeda());

            Conversor euro = new Conversor(Double.valueOf(editValue.getText().toString()), new Moeda("Euro", 4.29));
            textEuro.setText(String.valueOf("Euro" + String.format("%.2f", euro.Converte()))+ euro.getMoeda());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void clearValues() {
       textDollar.setText("");
        textEuro.setText("");
    }
}
