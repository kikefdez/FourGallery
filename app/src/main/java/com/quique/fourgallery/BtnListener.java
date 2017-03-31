package com.quique.fourgallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by FernandEn on 30/03/2017.
 */

public class BtnListener implements View.OnClickListener {
    private String modulo;
    private int posicion;
    private NodoImagen[] galeriaImagen;

    public BtnListener(String valorModulo, int valorPosicion, NodoImagen[] valorGaleria) {
        this.modulo = valorModulo;
        this.posicion = valorPosicion;
        this.galeriaImagen = valorGaleria;
    }

    @Override
    public void onClick(View vista) {
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * DETECTAMOS CLICK EN BOTÓN");
        switch(vista.getId()){
            case R.id.btnLike:
                galeriaImagen[posicion].setEstado(true);
                break;
            case R.id.btnDislike:
                galeriaImagen[posicion].setEstado(false);
                break;
        }

        galeriaImagen[posicion].setVisitado(true);

        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * RECUPERAMOS ACTIVIDAD PADRE");
        Activity actividadPadre = (Activity)vista.getContext();
        ViewPager viewPager = (ViewPager)actividadPadre.findViewById(R.id.viewPager);

        if((posicion + 1) < galeriaImagen.length){
            Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * FLUJO DIRIGIDO A SIGUIENTE IMAGEN:" + (posicion + 1));
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        } else {
            Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * FLUJO DIRIGIDO A ACTIVIDAD DE RESULTADOS");
            Intent intent = new Intent(vista.getContext(), Resultados.class);
            Bundle b = new Bundle();
            b.putSerializable("galeriaImagen", galeriaImagen);
            intent.putExtras(b);
            vista.getContext().startActivity(intent);
        }
    }
}
