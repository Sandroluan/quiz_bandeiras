package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private Button btnIniciar;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editTextText12);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnSair = findViewById(R.id.btnSair);

        // só inicia apos o user colocar o nome
        btnIniciar.setEnabled(false);

        editNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnIniciar.setEnabled(!s.toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        btnIniciar.setOnClickListener(v -> {
            String nome = editNome.getText().toString().trim();

            Intent it = new Intent(MainActivity.this, tela2.class);
            it.putExtra("nome", nome);
            it.putExtra("pontos", 0);
            startActivity(it);
        });

        btnSair.setOnClickListener(v -> finish());
    }
}
