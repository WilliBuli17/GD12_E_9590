package com.example.ugd9_xxxx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private MaterialButton btnLogin;
    private TextInputEditText nim, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        nim = findViewById(R.id.loginNim);
        password = findViewById(R.id.loginPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nim.getText().toString())) {
                    nim.setError("Username tidak boleh kosong!");
                    return;
                }else if (TextUtils.isEmpty(password.getText().toString())){
                    password.setError("Password tidak boleh kosong!");
                    return;
                }else {
                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                    Call<UserResponse> userDAOCall = apiService.loginUser(nim.getText().toString(),password.getText().toString());
                    userDAOCall.enqueue(new Callback<UserResponse>() {
                        @Override
                        public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                            if(response.body().getMessage().equalsIgnoreCase("berhasil login")){
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                                Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<UserResponse> call, Throwable t) {
                            //failure
                        }
                    });

                }
            }
        });
    }
}