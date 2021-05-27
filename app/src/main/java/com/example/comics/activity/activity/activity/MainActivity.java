package com.example.comics.activity.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.comics.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_lista :
                startActivity( new Intent(getApplicationContext(), ListaActivity.class));
                break;
            case R.id.menu_social :
                startActivity(new Intent(getApplicationContext(), SocialActivity.class));
                break;
            case R.id.menu_sobre :
                startActivity(new Intent(getApplicationContext(), SobreActivity.class));
                break;
            case R.id.menu_cadastrar:
                startActivity(new Intent(getApplicationContext(), CadastroActivity.class));
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
