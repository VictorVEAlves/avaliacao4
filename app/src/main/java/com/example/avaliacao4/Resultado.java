package com.example.avaliacao4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        score = (TextView)findViewById(R.id.pontuacao);

        Intent it = getIntent();
        Bundle params = it.getExtras ();
        int resultado = params.getInt("resultado");
        score.setText(String.valueOf(resultado));

    }
}
