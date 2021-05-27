package com.example.comics.activity.activity.conections;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.comics.activity.activity.model.Hq;

import java.util.ArrayList;
import java.util.List;

public class HqDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public HqDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir (Hq hq){
        ContentValues values = new ContentValues();
        values.put("titulo", hq.getTitulo());
        values.put("valor", hq.getValor());
        values.put("descricao", hq.getDescricao());

        return banco.insert("hq", null, values);

    }

    public List<Hq> obterTodos(){
        List<Hq> hqs = new ArrayList<>();
        Cursor cursor = banco.query("hq", new String[]{"id", "titulo", "valor", "descricao"}, null, null, null,null, null);
        while (cursor.moveToNext()){
            Hq h = new Hq();
            h.setId(cursor.getInt(0));
            h.setTitulo(cursor.getString(1));
            h.setValor(cursor.getString(2));
            h.setDescricao(cursor.getString(3));
            hqs.add(h);
        }
        return hqs;
    }

    public void excluir(Hq h){
         banco.delete("hq","id = ?", new String[]{h.getId().toString()});
    }

    public void atualizar(Hq hq){
        ContentValues values = new ContentValues();
        values.put("titulo", hq.getTitulo());
        values.put("valor", hq.getValor());
        values.put("descricao", hq.getDescricao());
        banco.update("hq", values, "id = ?", new String[]{hq.getId().toString() });

    }

}
