package com.example.tascarecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AdapterLlistaItems extends RecyclerView.Adapter<AdapterLlistaItems.ViewHolderLlistaItems>{
    ArrayList<String> llistaItems;
    ArrayList<String> llistaSubitems;

    public AdapterLlistaItems(ArrayList<String> llistaItems, ArrayList<String> llistaSubitems) {
        this.llistaItems = llistaItems;
        this.llistaSubitems = llistaSubitems;
    }

    //Connexió amb el resource layout "llista_items"
    @NonNull
    @NotNull
    @Override
    public AdapterLlistaItems.ViewHolderLlistaItems onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.llista_items, null, false);
        return new ViewHolderLlistaItems(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterLlistaItems.ViewHolderLlistaItems holder, int position) {
        holder.assignarItem(llistaItems.get(position), llistaSubitems.get(position));
    }

    //Recompte d'items
    @Override
    public int getItemCount() {
        return llistaItems.size();
    }

    public class ViewHolderLlistaItems extends RecyclerView.ViewHolder {

        TextView item;
        TextView subitem;
        public ViewHolderLlistaItems(@NonNull @NotNull View itemView) {
            super(itemView);
            this.item = itemView.findViewById(R.id.item_title);
            this.subitem = itemView.findViewById(R.id.item_subtitle);
        }

        public void assignarItem(String item, String subitem) {
            this.item.setText(item);
            this.subitem.setText(subitem);
        }
    }
}
