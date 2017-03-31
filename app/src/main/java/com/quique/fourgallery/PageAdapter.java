package com.quique.fourgallery;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by FernandEn on 30/03/2017.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    private NodoImagen[] galeriaImagenes;

    public PageAdapter(FragmentManager fm, NodoImagen[] valorGaleria){
        super(fm);
        this.galeriaImagenes = valorGaleria;
    }



    @Override
    public int getCount() {
        return galeriaImagenes.length;
    }

    @Override
    public Fragment getItem(int posicion) {
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * RECUPERO EL ELEMENTO CON POSICIÓN: " + posicion);
        return new ScreenFragment(posicion, galeriaImagenes);
    }
}
