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

        String nome = getIntent().getStringExtra("nome");
        int pontos = getIntent().getIntExtra("pontos", 0);

        TextView txtNome = findViewById(R.id.txtNomeRanking);
        TextView txtPontos = findViewById(R.id.txtPontosRanking);
        Button btnNovamente = findViewById(R.id.btnResponderNovamente);
        Button btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);

        txtNome.setText(nome);
        txtPontos.setText(String.valueOf(pontos));

        btnNovamente.setOnClickListener(v -> {
            Intent it = new Intent(RankingActivity.this, tela2.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", 0);
            startActivity(it);
            finish();
        });

        btnTelaPrincipal.setOnClickListener(v -> {
            Intent it = new Intent(RankingActivity.this, MainActivity.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(it);
            finish();
        });
    }
}
