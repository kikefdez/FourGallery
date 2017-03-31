package com.quique.fourgallery;

import android.app.Activity;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by FernandEn on 30/03/2017.
 */

public class ScreenFragment extends Fragment {
    private int posicion;
    private NodoImagen[] galeriaImagen;

    public ScreenFragment() {}
    public ScreenFragment (int valorPosicion, NodoImagen[] valorGaleria) {
        this.posicion = valorPosicion;
        this.galeriaImagen = valorGaleria;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * ACCEDEMOS AL onCreateView DEL ADAPTER: " + galeriaImagen[posicion].getModulo() + " - " + posicion);
        View nodo_viewPager = inflater.inflate(R.layout.nodo_viewpager, container, false);
        return nodo_viewPager;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        new com.quique.fourgallery.AsyncTask(view, galeriaImagen).execute(galeriaImagen[posicion].getModulo(), Integer.toString(posicion));
    }
}
