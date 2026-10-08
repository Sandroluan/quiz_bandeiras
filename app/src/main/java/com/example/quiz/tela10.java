package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela10);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot10);
        RadioButton radioButton33 = findViewById(R.id.radioButton33);
        RadioButton radioButton34 = findViewById(R.id.radioButton34);
        RadioButton radioButton35 = findViewById(R.id.radioButton35);
        RadioButton radioButton36 = findViewById(R.id.radioButton36);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton33, radioButton34, radioButton35, radioButton36};
        for (RadioButton alternativa : alternativas) {
            alternativa.setOnClickListener(v -> {
                for (RadioButton item : alternativas) {
                    if (item != v) {
                        item.setChecked(false);
                    }
                }
                btnResponder.setEnabled(true);
            });
        }

        btnResponder.setOnClickListener(v -> {
            int novaPontuacao = pontos;
            if (radioButton34.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela10.this, tela11.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            finish();
        });
    }
}
