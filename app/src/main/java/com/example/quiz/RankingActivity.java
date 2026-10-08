package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        String nome = getIntent().getStringExtra("nome");  //pega o nome do jogador desde a primeira tela com o import intent
        int pontos = getIntent().getIntExtra("pontos", 0); //o mesmo so que com os  pontos

        TextView txtNome = findViewById(R.id.txtNomeRanking);
        TextView txtPontos = findViewById(R.id.txtPontosRanking);
        Button btnNovamente = findViewById(R.id.btnResponderNovamente); //ligacoes do java com o XML usando o R.id
        Button btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);

        txtNome.setText(nome); //exibe o nome e os pontos na tela
        txtPontos.setText(String.valueOf(pontos));

        btnNovamente.setOnClickListener(v -> { //botao para jogar de novo
            Intent it = new Intent(RankingActivity.this, tela2.class); //aqui ele pega o caminho da tela2 e volta tela2 é o inicio do quiz
            it.putExtra("nome", nome);
            it.putExtra("pontos", 0);
            startActivity(it);
            finish();
        });

        btnTelaPrincipal.setOnClickListener(v -> { //botao para ir para o menu
            Intent it = new Intent(RankingActivity.this, MainActivity.class);//caminho para o menu
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(it);
            finish();
        });
    }
}
