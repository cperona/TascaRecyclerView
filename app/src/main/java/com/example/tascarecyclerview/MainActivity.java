package com.example.tascarecyclerview;

import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> llistaItems;
    ArrayList<String> llistaSubitems;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        //Omplim la llista d'items
        llistaItems = new ArrayList<>();
        llistaSubitems = new ArrayList<>();
        for (int i = 0; i < 43; i++){
            llistaItems.add("Item " + i);
            llistaSubitems.add("Subitem " + i);
        }

        //Li passem la llista d'items a l'adapter
        AdapterLlistaItems adapterLlistaItems = new AdapterLlistaItems(llistaItems, llistaSubitems);
        recyclerView.setAdapter(adapterLlistaItems);

        //Fem que els items siguin cliquejables
        adapterLlistaItems.setOnClickListener(new View.OnClickListener() {
            //Lo que s'executarà quan es cliqui un item de la llista
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Selecció: " + llistaItems.get(recyclerView.getChildAdapterPosition(view)), Toast.LENGTH_LONG).show();
            }
        });

        //Afegim separadors amb ItemDecoration
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, GridLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration2 = new DividerItemDecoration(this, GridLayoutManager.HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration1);
        recyclerView.addItemDecoration(dividerItemDecoration2);

        //Afegim transicions


    }
}