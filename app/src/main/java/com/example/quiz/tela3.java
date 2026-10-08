package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot3);
        RadioButton radioButton13 = findViewById(R.id.radioButton13);
        RadioButton radioButton14 = findViewById(R.id.radioButton14);
        RadioButton radioButton15 = findViewById(R.id.radioButton15);
        RadioButton radioButton16 = findViewById(R.id.radioButton16);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton13, radioButton14, radioButton15, radioButton16};
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
            if (radioButton13.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela3.this, tela4.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            finish();
        });
    }
}
