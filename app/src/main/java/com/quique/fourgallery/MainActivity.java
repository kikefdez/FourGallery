package com.quique.fourgallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * ENTRAMOS EN MAIN ACTIVITY");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("FourGallery - " + getClass().getCanonicalName(), "--- * ASIGNAMOS EL CONTENIDO A CADA FRAGMENT");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment1, new FragmentMenu("orks", this)).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment2, new FragmentMenu("human", this)).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment3, new FragmentMenu("dwarf", this)).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment4, new FragmentMenu("skaven", this)).commit();
    }
}
