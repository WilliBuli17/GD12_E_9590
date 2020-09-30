package com.example.ugd9_xxxx;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("user")
    Call<DataResponse> getAllUser(@Query("data") String data);

    @POST("user")
    @FormUrlEncoded
    Call<UserDAO> createUser(@Field("nama") String nama,
                             @Field("nim") String nim,
                             @Field("prodi") String prodi,
                             @Field("fakultas") String fakultas,
                             @Field("jenis_kelamin") String jenis_kelamin,
                             @Field("username") String username,
                             @Field("password") String password);

    @POST("user/update")
    @FormUrlEncoded
    Call<UserDAO> updateUser(@Field("id") String id,
                             @Field("nama") String nama,
                             @Field("nim") String nim,
                             @Field("prodi") String prodi,
                             @Field("fakultas") String fakultas,
                             @Field("jenis_kelamin") String jenis_kelamin,
                             @Field("username") String username,
                             @Field("password") String password);
}
