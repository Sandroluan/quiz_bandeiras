package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        Button btnResponder = findViewById(R.id.Botaot2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);
        RadioButton radioButton4 = findViewById(R.id.radioButton4);
        RadioButton radioButton5 = findViewById(R.id.radioButton5);
        RadioButton radioButton6 = findViewById(R.id.radioButton6);

        btnResponder.setEnabled(false);

        RadioButton[] alternativas = {radioButton3, radioButton4, radioButton5, radioButton6}; //lista(array) de alternativa
        for (RadioButton alternativa : alternativas) { //adiciona evento de clique para cada alternativa
            alternativa.setOnClickListener(v -> {
                for (RadioButton item : alternativas) {
                    if (item != v) { //aqui ele desmarca usando a variavel 'v' que é a alternativa clicada
                        item.setChecked(false);
                    }
                }
                btnResponder.setEnabled(true); //dentro do primeiro for ele habilita o botao de continuar
            });
        }

        btnResponder.setOnClickListener(v -> {
            int novaPontuacao = pontos;
            if (radioButton3.isChecked()) {
                novaPontuacao++;
            }

            Intent it = new Intent(tela2.this, tela3.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", novaPontuacao);
            startActivity(it);

            finish();//finaliza a tela atual removendo da pilha de telas
        });
    }
}
