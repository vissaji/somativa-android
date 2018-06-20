package br.senai.sp.keepervictorissasom.views.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.senai.sp.keepervictorissasom.R;
import br.senai.sp.keepervictorissasom.model.Item;
import br.senai.sp.keepervictorissasom.views.adapter.ItemAdapter;
public class ItemViewHolder extends RecyclerView.ViewHolder{

    private Long idItem;
    public final TextView nomeItem;
    public final ItemAdapter itemAdapter;

    public ItemViewHolder(View itemView, ItemAdapter itemAdapter) {
        super(itemView);
        this.nomeItem = itemView.findViewById(R.id.nomeItem);
        this.itemAdapter = itemAdapter;
    }

    public void preencher(Item item) {
        idItem = item.getId();

    }

}
