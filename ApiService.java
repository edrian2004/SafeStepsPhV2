package com.example.safestepsphv2;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface ApiService {

    // Existing illnesses endpoint
    @GET("get_illnesses.php")
    Call<IllnessResponse> getIllnesses();

    // Registration endpoint
    @FormUrlEncoded
    @POST("register_user.php")
    Call<RegisterResponse> registerUser(
            @Field("firstname") String firstname,
            @Field("lastname") String lastname,
            @Field("email") String email,
            @Field("password") String password

    );
    // Add this under your registerUser() method
    @FormUrlEncoded
    @POST("login_user.php")
    Call<RegisterResponse> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );

}
