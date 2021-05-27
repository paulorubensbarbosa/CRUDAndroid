package com.example.comics.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.comics.R;
import com.example.comics.activity.activity.conections.HqDAO;
import com.example.comics.activity.activity.model.Hq;

public class CadastroActivity extends AppCompatActivity {

    private EditText titulo;
    private EditText valor;
    private EditText descricao;
    private HqDAO dao;
    private Hq hq = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        titulo = findViewById(R.id.editTitulo);
        valor = findViewById(R.id.editValor);
        descricao = findViewById(R.id.editDescricao);
        dao = new HqDAO(this);

        Intent it = getIntent();
        if(it.hasExtra("hq")){
            hq = (Hq) it.getSerializableExtra("hq");
            titulo.setText(hq.getTitulo().toString());
            valor.setText(hq.getValor().toString());
            descricao.setText(hq.getDescricao().toString());
        }

    }

    public void salvar (View view){

        if (hq == null) {

            Hq hq = new Hq();

            hq.setTitulo(titulo.getText().toString());
            hq.setValor(valor.getText().toString());
            hq.setDescricao(descricao.getText().toString());
            long id = dao.inserir(hq);
            Toast.makeText(this, "Hq Inserida com id " + id, Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(getApplicationContext(), ListaActivity.class));
        } else {
            hq.setTitulo(titulo.getText().toString());
            hq.setValor(valor.getText().toString());
            hq.setDescricao(descricao.getText().toString());
            dao.atualizar(hq);
            Toast.makeText(this, "Hq Atualizada ", Toast.LENGTH_SHORT).show();
        }
    }

}
