package com.example.ugd9_xxxx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class UserProfileActivity extends AppCompatActivity {
    private String sIdUser, sName, sNim, sProdi, sFakultas, sJenisKelamin;
    private TextView twNama, twNim, twFakultas, twProdi, twJenisKelamin;
    private MaterialButton btnLogout, btnEdit;

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
        btnEdit = findViewById(R.id.btnEdit);

        Intent i = getIntent();
        sIdUser = i.getStringExtra("id");
        sName = i.getStringExtra("name");
        sNim = i.getStringExtra("nim");
        sProdi = i.getStringExtra("prodi");
        sFakultas = i.getStringExtra("fakultas");
        sJenisKelamin = i.getStringExtra("jenis_kelamin");

        twNama.setText(sName);
        twNim.setText(sNim);
        twFakultas.setText(sFakultas);
        twProdi.setText(sProdi);
        twJenisKelamin.setText(sJenisKelamin);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(UserProfileActivity.this, EditUserActivity.class);
            i.putExtra("id",sIdUser);
            i.putExtra("name",sName);
            i.putExtra("nim",sNim);
            i.putExtra("prodi",sProdi);
            i.putExtra("fakultas",sFakultas);
            i.putExtra("jenis_kelamin",sJenisKelamin);
            startActivity(i);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}