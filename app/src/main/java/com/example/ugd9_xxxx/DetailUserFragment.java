package com.example.ugd9_xxxx;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.button.MaterialButton;

public class DetailUserFragment extends DialogFragment {
    private TextView twNama, twNim, twFakultas, twProdi, twJenisKelamin, twUsername;
    private String sIdUser, sNama, sNim, sFakultas, sProdi, sJenisKelamin, sUsername;
    private ImageButton ibClose;
    private MaterialButton btnDelete, btnEdit;

    public static DetailUserFragment newInstance() {
        return new DetailUserFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_user_fragment, container, false);

        ibClose = v.findViewById(R.id.ibClose);
        ibClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        twNama = v.findViewById(R.id.twNama);
        twNim = v.findViewById(R.id.twNim);
        twFakultas = v.findViewById(R.id.twFakultas);
        twProdi = v.findViewById(R.id.twProdi);
        twJenisKelamin = v.findViewById(R.id.twJenisKelamin);
        twUsername = v.findViewById(R.id.twUsername);
        btnDelete = v.findViewById(R.id.btnDelete);
        btnEdit = v.findViewById(R.id.btnEdit);

        sIdUser = getArguments().getString("id", "");
        sNama = getArguments().getString("nama", "");
        sNim = getArguments().getString("nim", "");
        sFakultas = getArguments().getString("fakultas", "");
        sProdi = getArguments().getString("prodi", "");
        sJenisKelamin = getArguments().getString("jenis_kelamin", "");
        sUsername = getArguments().getString("username", "");

        twNama.setText(sNama);
        twNim.setText(sNim);
        twFakultas.setText(sFakultas);
        twProdi.setText(sProdi);
        twJenisKelamin.setText(sJenisKelamin);
        twUsername.setText(sUsername);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), EditUserActivity.class);
                i.putExtra("id",sIdUser);
                i.putExtra("name",sNama);
                i.putExtra("nim",sNim);
                i.putExtra("prodi",sProdi);
                i.putExtra("fakultas",sFakultas);
                i.putExtra("jenis_kelamin",sJenisKelamin);
                i.putExtra("username",sUsername);
                startActivity(i);
            }
        });

        return v;
    }

}