package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela5);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot5);
        RadioButton radioButton21 = findViewById(R.id.radioButton21);
        RadioButton radioButton22 = findViewById(R.id.radioButton22);
        RadioButton radioButton23 = findViewById(R.id.radioButton23);
        RadioButton radioButton24 = findViewById(R.id.radioButton24);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton21, radioButton22, radioButton23, radioButton24};
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
            if (radioButton24.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela5.this, tela6.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            // Remove a pergunta atual da pilha para não permitir voltar à pergunta anterior.
            finish();
        });
    }
}
