package com.example.comics.activity.activity.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.comics.R;
import com.example.comics.activity.activity.model.Hq;

import java.util.List;

public class HqAdapter extends BaseAdapter {

    private List<Hq> hqs;
    private Activity activity;

    public HqAdapter(Activity activity, List<Hq> hqs) {
        this.activity = activity;
        this.hqs = hqs;

    }


    @Override
    public int getCount() {

        return hqs.size();
    }

    @Override
    public Object getItem(int position) {

        return hqs.get(position);
    }

    @Override
    public long getItemId(int position) {

        return hqs.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater().inflate(R.layout.item,parent, false );
        TextView nome = view.findViewById(R.id.txt_titulo);
        TextView valor = view.findViewById(R.id.txt_valor);

        Hq h = hqs.get(position);
        nome.setText(h.getTitulo());
        valor.setText(h.getValor());

        return view;
    }
}
