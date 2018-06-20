package br.senai.sp.keepervictorissasom.views.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.senai.sp.keepervictorissasom.R;
import br.senai.sp.keepervictorissasom.model.Ambiente;
import br.senai.sp.keepervictorissasom.model.Item;
import br.senai.sp.keepervictorissasom.views.holder.AmbienteViewHolder;
import br.senai.sp.keepervictorissasom.views.holder.ItemViewHolder;

public class ItemAdapter extends RecyclerView.Adapter{

    private List<Item> listaItens;
    private Context context;

    public ItemAdapter(List<Item> listaItens, Context context) {
        this.listaItens = listaItens;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_lista_ambientes, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view, this);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        Item item = listaItens.get(position);

        ((ItemViewHolder) holder).preencher(item);
    }

    @Override
    public int getItemCount() {
        return listaItens.size();
    }

    public void setAmbienteList(List<Item> listaItens) {
        this.listaItens = listaItens;
        notifyDataSetChanged();
    }

}
