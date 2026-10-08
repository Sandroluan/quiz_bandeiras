package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela6);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot6);
        RadioButton radioButton25 = findViewById(R.id.radioButton25);
        RadioButton radioButton27 = findViewById(R.id.radioButton27);
        RadioButton radioButton = findViewById(R.id.radioButton);
        RadioButton radioButton28 = findViewById(R.id.radioButton28);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton25, radioButton27, radioButton, radioButton28};
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
            if (radioButton28.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela6.this, tela7.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            finish();
        });
    }
}
