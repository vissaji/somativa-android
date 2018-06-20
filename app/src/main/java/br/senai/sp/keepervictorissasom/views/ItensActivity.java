package br.senai.sp.keepervictorissasom.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.senai.sp.keepervictorissasom.R;
import br.senai.sp.keepervictorissasom.config.RetrofitConfig;
import br.senai.sp.keepervictorissasom.model.Ambiente;
import br.senai.sp.keepervictorissasom.model.Item;
import br.senai.sp.keepervictorissasom.utils.AppUtils;
import br.senai.sp.keepervictorissasom.views.adapter.AmbienteAdapter;
import br.senai.sp.keepervictorissasom.views.adapter.ItemAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItensActivity extends AppCompatActivity {

    private RecyclerView recyclerViewItem;
    private List<Item> listaItens = new ArrayList<>();
    private ItemAdapter itemAdapter;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambiente);

        recyclerViewItem = findViewById(R.id.recyclerViewAmbiente);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewItem.setLayoutManager(linearLayoutManager);
        itemAdapter = new ItemAdapter(listaItens, getApplicationContext());
        recyclerViewItem.setAdapter(itemAdapter);

        final SharedPreferences sharedPreferences = getSharedPreferences(AppUtils.sharedPref, Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");

        Log.e("aaa", token);

        Call<List<Item>> chamadaItens = new RetrofitConfig(token).getRestInterface().buscarTodosItens();
        chamadaItens.enqueue(new Callback<List<>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful())
                {
                    listaItens = response.body();

                    Log.e("aaa", "certo");

                    if (listaItens != null) {
                        itemAdapter.setAmbienteList(listaItens);
                    }
                }else{

                    Log.e("aaa", "errado");
                    Log.e("aaa", String.valueOf(response.code()));
                }
            }

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro na lista", Toast.LENGTH_LONG).show();
                Log.e("aaa", "deu bosta");

            }
        })

    }
}
