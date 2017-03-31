package com.quique.fourgallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Quique on 29/03/2017.
 */

public class FragmentMenu extends Fragment {
    private String modulo;
    private Activity actividad;

    public FragmentMenu(String valor, Activity valorActividad) {
        this.modulo = valor;
        this.actividad = valorActividad;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * INFLAMOS LA VISTA PARA EL FRAGMENT");
        View vistaFragMenu = inflater.inflate(R.layout.opcion_menu, container, false);

        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * VALOR RECUPERADO: " + modulo);
        ImageView logoEjercito = (ImageView) vistaFragMenu.findViewById(R.id.imgMenu);
        logoEjercito.setImageResource(getResources().getIdentifier(modulo, "drawable", actividad.getPackageName()));
        logoEjercito.setTag(modulo);

        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * ASIGNAMOS LISTENER A LA IMAGEN");
        logoEjercito.setOnClickListener(new View.OnClickListener() {
            public void onClick(View vista) {
                ImageView logoEjercito = (ImageView) vista.findViewById(R.id.imgMenu);
                Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * IMAGEN SELECCIONADA CORRESPONDIENTE A: " + logoEjercito.getTag());
                Intent intent = new Intent(actividad, Galeria.class);
                intent.putExtra("modulo", modulo);
                Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * LANZAMOS EL HILO DE EJECUCIÓN A LA SIGUIENTE ACTIVIDAD: GALERIA");
                startActivity(intent);
            }
        });
        return vistaFragMenu;
    }
}
