package com.example.ugd9_xxxx;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("user")
    Call<UserResponse> getAllUser();

    @POST("user")
    @FormUrlEncoded
    Call<UserResponse> createUser(@Field("nama") String nama,
                                  @Field("nim") String nim,
                                  @Field("prodi") String prodi,
                                  @Field("fakultas") String fakultas,
                                  @Field("jenis_kelamin") String jenis_kelamin,
                                  @Field("password") String password);

    @POST("user/update")
    @FormUrlEncoded
    Call<UserResponse> updateUser(@Field("id") String id,
                                  @Field("nama") String nama,
                                  @Field("prodi") String prodi,
                                  @Field("fakultas") String fakultas,
                                  @Field("jenis_kelamin") String jenis_kelamin,
                                  @Field("password") String password);
}
