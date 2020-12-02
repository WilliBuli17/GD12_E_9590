package com.example.unguided8_xxxx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.unguided8_xxxx.UnitTest.LoginActivity;
import com.google.android.material.button.MaterialButton;

public class UserProfileActivity extends AppCompatActivity {
    private String sIdUser, sNama, sNim, sProdi, sFakultas, sJenisKelamin;
    private TextView twNama, twNim, twFakultas, twProdi, twJenisKelamin;
    private MaterialButton btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        twNama = findViewById(R.id.twNama);
        twNim = findViewById(R.id.twNim);
        twFakultas = findViewById(R.id.twFakultas);
        twProdi = findViewById(R.id.twProdi);
        twJenisKelamin = findViewById(R.id.twJenisKelamin);
        btnLogout = findViewById(R.id.btnLogout);

        Intent i = getIntent();
        sIdUser = i.getStringExtra("id");
        sNama = i.getStringExtra("name");
        sNim = i.getStringExtra("nim");
        sProdi = i.getStringExtra("prodi");
        sFakultas = i.getStringExtra("fakultas");
        sJenisKelamin = i.getStringExtra("jenis_kelamin");

        twNama.setText(sNama);
        twNim.setText(sNim);
        twFakultas.setText(sFakultas);
        twProdi.setText(sProdi);
        twJenisKelamin.setText(sJenisKelamin);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}