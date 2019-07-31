package com.example.conversormoedas;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConversorActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textValorDollar;
    private TextView textValorEuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        TextView prettyText = (TextView) findViewById(R.id.textView4);
        TextView prettyText1 = (TextView) findViewById(R.id.textView5);
        TextView prettyText2 = (TextView) findViewById(R.id.textView6);
        TextView prettyText3 = (TextView) findViewById(R.id.edit_valor);

        TextView prettyText4 = (TextView) findViewById(R.id.button_calcula);
        TextView prettyText5 = (TextView) findViewById(R.id.text_valor_dollar);
        TextView prettyText6 = (TextView) findViewById(R.id.text_valor_euro);

        Typeface font = Typeface.createFromAsset(getAssets(), "Margarine-Regular.ttf");
        prettyText.setTypeface(font);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "Margarine-Regular.ttf");
        prettyText1.setTypeface(font);
        Typeface font2 = Typeface.createFromAsset(getAssets(), "Margarine-Regular.ttf");
        prettyText2.setTypeface(font);
        Typeface font3 = Typeface.createFromAsset(getAssets(), "Margarine-Regular.ttf");
        prettyText3.setTypeface(font);

        Typeface font4 = Typeface.createFromAsset(getAssets(), "Margarine-Regular.ttf");
        prettyText4.setTypeface(font);
        Typeface font5 = Typeface.createFromAsset(getAssets(), "Margarine-Regular.ttf");
        prettyText5.setTypeface(font);
        Typeface font6 = Typeface.createFromAsset(getAssets(), "Margarine-Regular.ttf");
        prettyText6.setTypeface(font);


        editValor = (EditText) findViewById(R.id.edit_valor);
        textValorDollar = findViewById(R.id.text_valor_dollar);
        textValorEuro = findViewById(R.id.text_valor_euro);
        final Button buttonCancula = findViewById(R.id.button_calcula);

        buttonCancula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCalculaConversao();
            }
        });

    }

    private void buttonCalculaConversao() {
        try {
            Conversor conversor = new Conversor(Double.valueOf(editValor.getText().toString()), new Moeda("USD", 3.78));
            textValorDollar.setText(String.valueOf("$ " + String.format("%.2f", conversor.Converte())));

            Conversor conversorEuro = new Conversor(Double.valueOf(editValor.getText().toString()), new Moeda("Euro", 4.29));
            textValorEuro.setText(String.valueOf("Euro " + String.format("%.2f", conversorEuro.Converte())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
