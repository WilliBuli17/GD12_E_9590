package com.example.unguided8_xxxx;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("user")
    Call<UserResponse> getAllUser();

    @POST("login")
    @FormUrlEncoded
    Call<UserResponse> loginUser(@Field("nim") String nim,
                                  @Field("password") String password);

    @POST("user")
    @FormUrlEncoded
    Call<UserResponse> createUser(@Field("nama") String nama,
                                  @Field("nim") String nim,
                                  @Field("prodi") String prodi,
                                  @Field("fakultas") String fakultas,
                                  @Field("jenis_kelamin") String jenis_kelamin,
                                  @Field("password") String password);

    @POST("user/update/{id}")
    @FormUrlEncoded
    Call<UserResponse> updateUser(@Path("id")String id,
                                  @Field("nama") String nama,
                                  @Field("prodi") String prodi,
                                  @Field("fakultas") String fakultas,
                                  @Field("jenis_kelamin") String jenis_kelamin,
                                  @Field("password") String password);
    @POST("user/delete/{id}")
    Call<UserResponse> deleteUser(@Path("id")String id);
}
