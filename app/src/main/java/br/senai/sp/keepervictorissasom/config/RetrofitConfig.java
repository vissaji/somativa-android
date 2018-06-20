package br.senai.sp.keepervictorissasom.config;

import java.io.IOException;

import br.senai.sp.keepervictorissasom.rest.RestInterface;
import br.senai.sp.keepervictorissasom.utils.AppUtils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig(final String token) {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("Accept", "application/json");
                builder.addHeader("Authorization", token);

                return chain.proceed(builder.build());
            }
        }).build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(AppUtils.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RestInterface getRestInterface() {
        return this.retrofit.create(RestInterface.class);
    }

}
