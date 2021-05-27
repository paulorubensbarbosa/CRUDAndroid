package com.example.comics.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.comics.R;

public class DetalhesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Intent intent = getIntent();
        String parametro = (String) intent.getSerializableExtra("titulo");
        String parametroValor = (String) intent.getSerializableExtra("valor");
        String parametroDescricao = (String) intent.getSerializableExtra("descricao");




        TextView titulo = (TextView) findViewById(R.id.txt_titulo);
        TextView valor = (TextView) findViewById(R.id.txt_valor);
        TextView descricao = (TextView) findViewById(R.id.txt_descricao);

        titulo.setText(parametro);
        valor.setText(parametroValor);
        descricao.setText(parametroDescricao);


    }
}
