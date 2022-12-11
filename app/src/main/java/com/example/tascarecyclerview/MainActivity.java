package com.example.tascarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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

    }
}