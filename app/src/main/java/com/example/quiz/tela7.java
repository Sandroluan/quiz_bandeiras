package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela7);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot7);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton7 = findViewById(R.id.radioButton7);
        RadioButton radioButton8 = findViewById(R.id.radioButton8);
        RadioButton radioButton9 = findViewById(R.id.radioButton9);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton2, radioButton7, radioButton8, radioButton9};
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
            if (radioButton9.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela7.this, tela8.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            // Remove a pergunta atual da pilha para não permitir voltar à pergunta anterior.
            finish();
        });
    }
}
