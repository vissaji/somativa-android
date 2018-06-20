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
import br.senai.sp.keepervictorissasom.views.holder.AmbienteViewHolder;

public class AmbienteAdapter extends RecyclerView.Adapter {

    private List<Ambiente> listaAmbientes;
    private Context context;

    public AmbienteAdapter(List<Ambiente> listaAmbientes, Context context) {
        this.listaAmbientes = listaAmbientes;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_lista_ambientes, parent, false);
        AmbienteViewHolder holder = new AmbienteViewHolder(view, this);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AmbienteViewHolder viewHolder = (AmbienteViewHolder) holder;
        Ambiente ambiente = listaAmbientes.get(position);

        ((AmbienteViewHolder) holder).preencher(ambiente);
    }

    @Override
    public int getItemCount() {
        return listaAmbientes.size();
    }

    public void setAmbienteList(List<Ambiente> listaAmbientes) {
        this.listaAmbientes = listaAmbientes;
        notifyDataSetChanged();
    }
}
