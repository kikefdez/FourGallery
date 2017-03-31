package com.quique.fourgallery;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by FernandEn on 30/03/2017.
 */

public class AsyncTask extends android.os.AsyncTask<String, Void, Bitmap>  {
    private static final String urlServer = "http://img.kf-sp.es/CICE";
    private View vista;
    private String modulo;
    private int posicion;
    private NodoImagen[] galeriaImagen;

    public AsyncTask(View valorVista, NodoImagen[] valorGaleria){
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * ACCEDEMOS AL CONSTRUCTOR DEL AsyncTask");
        this.vista = valorVista;
        this.galeriaImagen = valorGaleria;
    }

    @Override
    protected void onPreExecute() {
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * INICIAMOS LA DESCARGA");
    }

    @Override
    protected Bitmap doInBackground(String... parametros) {
        Bitmap bitmap = null;
        HttpURLConnection http = null;

        try {
            modulo = parametros[0].toString();
            posicion = Integer.parseInt(parametros[1].toString());

            Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * GENERAMOS LA URL DE LA IMAGEN DINÁMICAMENTE [" + posicion + "]: " + urlServer + "/" + modulo + "/" + (posicion + 1) + ".jpg");
            URL datosUrl = new URL(urlServer + "/" + modulo + "/" + (posicion + 1) + ".jpg");
            http = (HttpURLConnection)datosUrl.openConnection();

            int codigoRespuesta = http.getResponseCode();

            if(codigoRespuesta == HttpURLConnection.HTTP_OK){
                Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * RESPUESTA DEL SERVIDOR SATISFACTORIA [" + posicion + "]");
                InputStream respuestaServer = http.getInputStream();
                bitmap = BitmapFactory.decodeStream(respuestaServer);
                //galeriaImagen[posicion].setImagen(bitmap);
            } else {
                Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * RESPUESTA DEL SERVIDOR ERRONEA[" + posicion + "]: " + codigoRespuesta);
            }
        } catch (Throwable t) {
            Log.e("EROOOOR", t.getMessage());
        } finally {
            http.disconnect();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * PROCESO ASINCRONO FINALIZADO [" + posicion + "]");
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * ASIGNAMOS Y VISUALIZAMOS LA IMAGEN DESCARGADA [" + posicion + "]");
        ((ImageView) vista.findViewById(R.id.imagenNodo)).setImageBitmap(bitmap);
        ((TextView) vista.findViewById(R.id.imagenTitulo)).setText("Posición: " + posicion);
        (vista.findViewById(R.id.btnLike)).setOnClickListener(new BtnListener(modulo, posicion, galeriaImagen));
        (vista.findViewById(R.id.btnDislike)).setOnClickListener(new BtnListener(modulo, posicion, galeriaImagen));
    }
}
