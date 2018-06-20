package br.senai.sp.keepervictorissasom;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.senai.sp.keepervictorissasom.config.RetrofitConfig;
import br.senai.sp.keepervictorissasom.model.Ambiente;
import br.senai.sp.keepervictorissasom.utils.AppUtils;
import br.senai.sp.keepervictorissasom.views.adapter.AmbienteAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmbienteActivity extends AppCompatActivity {

    private RecyclerView recyclerViewAmbiente;
    private List<Ambiente> listaAmbientes = new ArrayList<>();
    private AmbienteAdapter ambienteAdapter;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambiente);

        recyclerViewAmbiente = findViewById(R.id.recyclerViewAmbiente);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewAmbiente.setLayoutManager(linearLayoutManager);
        ambienteAdapter = new AmbienteAdapter(listaAmbientes, getApplicationContext());
        recyclerViewAmbiente.setAdapter(ambienteAdapter);

        final SharedPreferences sharedPreferences = getSharedPreferences(AppUtils.sharedPref, Context.MODE_PRIVATE);
        token = sharedPreferences.getString("token", "");

        Call<List<Ambiente>> chamadaAmbientes = new RetrofitConfig(token).getRestInterface().buscarTodosAmbiente();
        chamadaAmbientes.enqueue(new Callback<List<Ambiente>>() {

            @Override
            public void onResponse(Call<List<Ambiente>> call, Response<List<Ambiente>> response) {
                if (response.isSuccessful())
                {
                    listaAmbientes = response.body();

                    if (listaAmbientes != null) {
                        ambienteAdapter.setAmbienteList(listaAmbientes);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Ambiente>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro na lista", Toast.LENGTH_LONG).show();
            }
        });

    }
}
