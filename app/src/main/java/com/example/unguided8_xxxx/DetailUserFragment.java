package com.example.unguided8_xxxx;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailUserFragment extends DialogFragment {
    private TextView twNama, twNim, twFakultas, twProdi, twJenisKelamin;
    private String sIdUser, sNama, sNim, sFakultas, sProdi, sJenisKelamin;
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
        btnDelete = v.findViewById(R.id.btnDelete);
        btnEdit = v.findViewById(R.id.btnEdit);

        sIdUser = getArguments().getString("id", "");
        sNama = getArguments().getString("nama", "");
        sNim = getArguments().getString("nim", "");
        sFakultas = getArguments().getString("fakultas", "");
        sProdi = getArguments().getString("prodi", "");
        sJenisKelamin = getArguments().getString("jenis_kelamin", "");

        twNama.setText(sNama);
        twNim.setText(sNim);
        twFakultas.setText(sFakultas);
        twProdi.setText(sProdi);
        twJenisKelamin.setText(sJenisKelamin);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog diaBox = KonfirmasiHapus();
                diaBox.show();
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
                startActivity(i);
            }
        });

        return v;
    }

    private AlertDialog KonfirmasiHapus()
    {
        AlertDialog diaBox = new AlertDialog.Builder(getContext())
                // set message, title, and icon
                .setTitle("Konfirmasi")
                .setMessage("Yakin ingin menghapus data ini?")

                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                        Call<UserResponse> delete = apiService.deleteUser(sIdUser);

                        delete.enqueue(new Callback<UserResponse>() {
                            @Override
                            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getContext(), ShowListUserActivity.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);
                            }

                            @Override
                            public void onFailure(Call<UserResponse> call, Throwable t) {
                                Toast.makeText(getContext(), "Gagal menghapus user", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();

        return diaBox;
    }
}