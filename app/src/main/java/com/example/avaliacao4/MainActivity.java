package com.example.avaliacao4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText input;
    TextView resposta;
    Button btnEnviar;

    int jogadas = 0;
    int pontos = 0;

    Integer[] imgId = {R.drawable.img1, R.drawable.img2
            , R.drawable.img3, R.drawable.img4, R.drawable.img5
            , R.drawable.img6, R.drawable.img7, R.drawable.img8
            , R.drawable.img9, R.drawable.img10};

    String[] cidades = {"São Paulo", "Rio de Janeiro", "Curitiba",
    "Salvador", "Brasilia", "Paris", "Tóquio", "Barcelona",
    "Las Vegas", "Montreal"};

    int inicial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        input = (EditText)findViewById(R.id.input);
        resposta = (TextView) findViewById(R.id.msgResposta);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        inicial = new Random().nextInt(9);

        imageView.setImageResource(imgId[inicial]);
        resposta.setText("");

    }

    public void joga(View view){
        String inputStr = input.getText().toString().trim();

        //busca se a cidade é valida
        for(int i = 0; i < cidades.length; i++){
            if(cidades[i].equals(inputStr)){ //achou a cidade no vetor
                System.out.println("achou a cidade no vetor");
                if(i == inicial){ //acertou a cidade
                   pontos = pontos+25;
                   resposta.setText("Você acertou!");
                }else{
                    resposta.setText("Você errou!");
                }
            }
        }

        inicial = new Random().nextInt(9);
        imageView.setImageResource(imgId[inicial]);

        jogadas++;

        if(jogadas == 4){
            Intent it = new Intent(this, Resultado.class);
            Bundle params = new Bundle();
            params.putInt("resultado", pontos);
            it.putExtras(params);
            startActivity(it);
        }

    }

}
