package br.senai.sp.keepervictorissasom.views.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.senai.sp.keepervictorissasom.R;
import br.senai.sp.keepervictorissasom.model.Ambiente;
import br.senai.sp.keepervictorissasom.views.adapter.AmbienteAdapter;

public class AmbienteViewHolder extends RecyclerView.ViewHolder {

    private Long idAmbiente;
    public final TextView nomeAmbiente;
    public final AmbienteAdapter ambienteAdapter;

    public AmbienteViewHolder(View itemView, AmbienteAdapter ambienteAdapter) {
        super(itemView);
        this.nomeAmbiente = itemView.findViewById(R.id.nomeAmbiente);
        this.ambienteAdapter = ambienteAdapter;
    }

    public void preencher(Ambiente ambiente) {
        idAmbiente = ambiente.getId();
        nomeAmbiente.setText(ambiente.getNome());
    }
}
