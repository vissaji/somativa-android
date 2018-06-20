package br.senai.sp.keepervictorissasom.rest;

import java.util.List;

import br.senai.sp.keepervictorissasom.model.Ambiente;
import br.senai.sp.keepervictorissasom.model.Item;
import br.senai.sp.keepervictorissasom.model.Movimentacao;
import br.senai.sp.keepervictorissasom.model.Patrimonio;
import br.senai.sp.keepervictorissasom.model.Usuario;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RestInterface {

    @POST("rest/auth/jwt")
    Call<ResponseBody> realizarLogin(@Body Usuario usuario);

    @GET("rest/ambientes")
    Call<List<Ambiente>> buscarTodosAmbiente();

    @GET("rest/itens")
    Call<List<Item>> buscarTodosItens();

    @GET("rest/itens/{id}/movimentacoes")
    Call<List<Movimentacao>> buscarTodosMovimentacao(@Path("id") Long id);

    @GET("rest/patrimonios")
    Call<List<Patrimonio>> buscarTodosPatrimonio();

    @POST("rest/itens/{id}/movimentacoes")
    Call<Movimentacao> fazerMovimentacao(@Body Movimentacao movimentacao, @Path("id") Long id);
}
