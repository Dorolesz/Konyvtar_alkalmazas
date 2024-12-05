package com.example.konyvtar_alkalmazas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class KonyvekListaAdapter extends BaseAdapter {

    private Context context;
    private List<Konyv> konyvekLista;

    public KonyvekListaAdapter(Context context, List<Konyv> konyvekLista) {
        this.context = context;
        this.konyvekLista = konyvekLista;
    }

    @Override
    public int getCount() {
        return konyvekLista.size();
    }

    @Override
    public Object getItem(int position) {
        return konyvekLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_konyv, parent, false);
        }

        TextView detailsKonyvCimeTextView = convertView.findViewById(R.id.detailsKonyvCimeTextView);
        TextView detailsSzerzoNeveTextView = convertView.findViewById(R.id.detailsSzerzoNeveTextView);
        TextView detailsOldalakszamaTextView = convertView.findViewById(R.id.detailsOldalakSzamaTextView);
        Button deleteButton = convertView.findViewById(R.id.deleteButton);

        Konyv konyv = konyvekLista.get(position);

        detailsKonyvCimeTextView.setText(konyv.getKonyvCime());
        detailsSzerzoNeveTextView.setText(konyv.getSzerzoNeve());
        detailsOldalakszamaTextView.setText(String.valueOf(konyv.getOldalakSzama()));

        deleteButton.setOnClickListener(v -> {
            konyvekLista.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}
