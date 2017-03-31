package com.quique.fourgallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Quique on 31/03/2017.
 */

public class ResultadosAdapter extends BaseAdapter {
    private Context contexto;
    private NodoImagen[] galeriaImagen;

    public ResultadosAdapter(NodoImagen[] galeriaImagen, Context contexto){
        this.contexto = contexto;
        this.galeriaImagen = galeriaImagen;
    }

    @Override
    public int getCount() { return galeriaImagen.length; }

    @Override
    public Object getItem(int position) { return galeriaImagen[position]; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.nodo_resultados, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.leyenda)).setText(galeriaImagen[position].getEstado() ? "LIKE" : "DISLIKE");
        ((TextView) convertView.findViewById(R.id.posicion)).setText("IMAGEN SITUADA EN POSICION: " + galeriaImagen[position].getPosicion());
        return convertView;
    }
}
