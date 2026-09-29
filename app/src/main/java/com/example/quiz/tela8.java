package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela8);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot8);
        RadioButton radioButton10 = findViewById(R.id.radioButton10);
        RadioButton radioButton11 = findViewById(R.id.radioButton11);
        RadioButton radioButton12 = findViewById(R.id.radioButton12);
        RadioButton radioButton26 = findViewById(R.id.radioButton26);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton10, radioButton11, radioButton12, radioButton26};
        for (RadioButton alternativa : alternativas) {
            alternativa.setOnClickListener(v -> {
                // Mantém apenas uma alternativa marcada por vez.
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
            if (radioButton10.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela8.this, tela9.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            // Remove a pergunta atual da pilha para não permitir voltar à pergunta anterior.
            finish();
        });
    }
}
