package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot4);
        RadioButton radioButton17 = findViewById(R.id.radioButton17);
        RadioButton radioButton18 = findViewById(R.id.radioButton18);
        RadioButton radioButton19 = findViewById(R.id.radioButton19);
        RadioButton radioButton20 = findViewById(R.id.radioButton20);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton17, radioButton18, radioButton19, radioButton20};
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
            if (radioButton19.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela4.this, tela5.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            // Remove a pergunta atual da pilha para não permitir voltar à pergunta anterior.
            finish();
        });
    }
}
