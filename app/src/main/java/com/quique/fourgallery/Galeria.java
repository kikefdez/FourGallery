package com.quique.fourgallery;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Galeria extends AppCompatActivity {
    private String modulo;
    private static ViewPager viewPager;
    private NodoImagen[] galeriaImagen = new NodoImagen[]{
            new NodoImagen(0, ""),
            new NodoImagen(1, ""),
            new NodoImagen(2, ""),
            new NodoImagen(3, ""),
            new NodoImagen(4, ""),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        modulo = (this.getIntent()).getStringExtra("modulo").toString();

        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * ACCEDEMOS A LA GALERIA CON PARÁMETROS: " + modulo);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        galeriaImagen[0].setModulo(modulo);
        galeriaImagen[1].setModulo(modulo);
        galeriaImagen[2].setModulo(modulo);
        galeriaImagen[3].setModulo(modulo);
        galeriaImagen[4].setModulo(modulo);

        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * RECUPERAMOS EL VIEWPAGER");
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * ASIGNAMOS EL PAGEADAPTER AL VIEWPAGER");
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), galeriaImagen));
    }

    @Override
    public void onBackPressed() {
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * DETECTAMOS CLICK EN BOTÓN VOLVER");
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if(viewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }
}
