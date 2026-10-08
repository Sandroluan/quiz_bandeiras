package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela11);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot11);
        RadioButton radioButton37 = findViewById(R.id.radioButton37);
        RadioButton radioButton38 = findViewById(R.id.radioButton38);
        RadioButton radioButton39 = findViewById(R.id.radioButton39);
        RadioButton radioButton40 = findViewById(R.id.radioButton40);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton37, radioButton38, radioButton39, radioButton40};
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
            if (radioButton38.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela11.this, RankingActivity.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            finish();
        });
    }
}
