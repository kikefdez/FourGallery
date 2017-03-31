package com.quique.fourgallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class Resultados extends AppCompatActivity {
    private NodoImagen[] galeriaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * ACCEDEMOS AL onCreate DE RESULTADOS");

        Intent intent = getIntent();
        galeriaImagen = (NodoImagen[]) intent.getSerializableExtra("galeriaImagen");

        ListView listaResultados = (ListView)findViewById(R.id.lista_resultados);
        listaResultados.setAdapter(new ResultadosAdapter(galeriaImagen, this));
    }
}
