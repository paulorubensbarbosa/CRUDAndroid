package com.example.comics.activity.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.comics.R;

public class SocialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social);

    }

    public void clickCarlos(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cadu_mell0/"));
        startActivity(intent);

    }
    public void clickGeoorge(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/geoorge_victor/"));
        startActivity(intent);
    }
    public void clickLeo(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://steamcommunity.com/id/Leonardo996/"));
        startActivity(intent);
    }
    public void clickMilena(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/milena.has/"));
        startActivity(intent);
    }
    public void clickPaulo(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/paulo.rubens1/"));
        startActivity(intent);
    }
    public void clickRogerio(View view){

    }
    public void clickThales(View view){

    }

}
