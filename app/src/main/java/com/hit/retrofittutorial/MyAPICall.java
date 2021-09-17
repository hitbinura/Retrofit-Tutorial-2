package com.hit.retrofittutorial;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {
//https://reqres.in/           api/users?page=2

    @GET("api/users?page=2")
    Call<DataModel> getData();


}
