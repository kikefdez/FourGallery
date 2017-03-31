package com.quique.fourgallery;

import android.util.Log;
import java.io.Serializable;

/**
 * Created by Quique on 31/03/2017.
 */

public class NodoImagen implements Serializable {
    private int Posicion;
    private String Modulo;
    private boolean Estado;
    private boolean Visitado;

    public int getPosicion() { return this.Posicion; }
    public String getModulo() { return this.Modulo; }
    public boolean getEstado() { return this.Estado; }
    public boolean getVisitado() {return this.Visitado; }

    public void setPosicion(int valor) { this.Posicion = valor; }
    public void setModulo(String valor) { this.Modulo = valor;}
    public void setEstado(boolean valor) { this.Estado = valor; }
    public void setVisitado(boolean valor) {this.Visitado = valor; }

    public NodoImagen(int valorPosicion, String valorModulo) {
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * CREAMOS UN NUEVO ELEMENTO DE TIPO NodoImagen para la posicion: " + valorPosicion);
        this.Posicion = valorPosicion;
        this.Modulo = valorModulo;
        this.Estado = false;
        this.Visitado = false;
    }
}
