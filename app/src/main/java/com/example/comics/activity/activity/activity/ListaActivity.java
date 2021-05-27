package com.example.comics.activity.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.comics.R;
import com.example.comics.activity.activity.adapter.HqAdapter;
import com.example.comics.activity.activity.conections.HqDAO;
import com.example.comics.activity.activity.model.Hq;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private ListView listView;
    private HqDAO dao;
    private List<Hq> hqs;
    private List<Hq> hqsFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = findViewById(R.id.lista_hqs);
        dao = new HqDAO(this);
        hqs = dao.obterTodos();
        hqsFiltrados.addAll(hqs);

        //ArrayAdapter<Hq> adaptador = new ArrayAdapter<Hq>(this, android.R.layout.simple_list_item_1, hqsFiltrados);
        HqAdapter adaptador = new HqAdapter(this, hqsFiltrados);
        listView.setAdapter(adaptador);

        registerForContextMenu(listView);


        //Exibir detalhes
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaActivity.this, DetalhesActivity.class);

                intent.putExtra("titulo", hqs.get(position).getTitulo());
                intent.putExtra("valor", hqs.get(position).getValor());
                intent.putExtra("descricao", hqs.get(position).getDescricao());
                startActivity(intent);

               // Toast.makeText(ListaActivity.this, "item: " + hqs.get(position).getTitulo() , Toast.LENGTH_SHORT).show();
            }
        });

     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_cadastro_search,menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                procuraHq(newText);
                System.out.println("Digitou: "+newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contexto, menu);

    }

    public void procuraHq(String titulo){
        hqsFiltrados.clear();
        for(Hq a : hqs){
            if(a.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                hqsFiltrados.add(a);
            }
        }
        listView.invalidateViews();
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = ( AdapterView.AdapterContextMenuInfo ) item.getMenuInfo();
        final Hq hqExcluir = hqsFiltrados.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Deseja realmente excluir essa HQ?")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hqsFiltrados.remove(hqExcluir);
                        hqs.remove(hqExcluir);
                        dao.excluir(hqExcluir);
                        listView.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    public void detalhar(){

    }


    public void cadastrar(MenuItem item){
        startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
    }


    public void atualizar(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo = ( AdapterView.AdapterContextMenuInfo ) item.getMenuInfo();
        final Hq hqAtualizar = hqsFiltrados.get(menuInfo.position);

        Intent it = new Intent(this, CadastroActivity.class);
        it.putExtra("hq", hqAtualizar );
        startActivity(it);

    }

    @Override
    public void onResume(){
        super.onResume();
        hqs = dao.obterTodos();
        hqsFiltrados.clear();
        hqsFiltrados.addAll(hqs);
        listView.invalidateViews();
    }

}
