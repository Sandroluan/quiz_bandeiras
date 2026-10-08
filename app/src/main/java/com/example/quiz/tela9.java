package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela9);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot9);
        RadioButton radioButton29 = findViewById(R.id.radioButton29);
        RadioButton radioButton30 = findViewById(R.id.radioButton30);
        RadioButton radioButton31 = findViewById(R.id.radioButton31);
        RadioButton radioButton32 = findViewById(R.id.radioButton32);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton29, radioButton30, radioButton31, radioButton32};
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
            if (radioButton31.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela9.this, tela10.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            finish();
        });
    }
}
