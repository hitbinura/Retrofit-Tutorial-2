package com.hit.retrofittutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.security.cert.CertPathBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.textview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/").addConverterFactory(GsonConverterFactory.create()).build();


        MyAPICall myAPICall = retrofit.create(MyAPICall.class);

        Call<DataModel> call = myAPICall.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                if (response.code() != 200) {
                    txt.setText("Check the connection");
                    return;
                }

                String jsony = "";

                jsony = "ID = " + response.body().getId() +
                        "\nuserId = " + response.body().getUserId() +
                        "\ntitle= " + response.body().getTitle() +
                        "\nstastus=" + response.body().isCompleted();

                txt.append(jsony);


            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });


    }


}