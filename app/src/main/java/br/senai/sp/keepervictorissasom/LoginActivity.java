package br.senai.sp.keepervictorissasom;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import br.senai.sp.keepervictorissasom.config.RetrofitConfig;
import br.senai.sp.keepervictorissasom.model.Usuario;
import br.senai.sp.keepervictorissasom.utils.AppUtils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private String token;
    private EditText campoEmail;
    private EditText campoSenha;
    private Button botaoLogar;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.campoEmail);
        campoSenha = findViewById(R.id.campoSenha);
        botaoLogar = findViewById(R.id.btnLogar);

        campoEmail.setText("admin@gmail.com");
        campoSenha.setText("123456");
        sharedPref = getSharedPreferences(AppUtils.sharedPref, Context.MODE_PRIVATE);

        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario (campoEmail.getEditableText().toString(), campoSenha.getEditableText().toString());

                Call<ResponseBody> chamadaLogin = new RetrofitConfig(token).getRestInterface().realizarLogin(usuario);
                chamadaLogin.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful())
                        {
                            try {

                                JSONObject jsonObject = new JSONObject(response.body().string());
                                String token = jsonObject.getString("token");
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString("token", "Bearer " + token);
                                editor.apply();
                                Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intentMain);
                                finish();

                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro ao fazer login", Toast.LENGTH_LONG).show();
                        Log.d("Login Error: ", t.getMessage());
                    }
                });
            }
        });

    }
}
