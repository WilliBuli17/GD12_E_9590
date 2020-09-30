package com.example.ugd9_xxxx;

public class UserDAO {
    String id, nama, nim, prodi, fakultas, jenis_kelamin, username, password;

    public UserDAO(String id, String nama, String nim, String prodi, String fakultas, String jenis_kelamin, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.fakultas = fakultas;
        this.jenis_kelamin = jenis_kelamin;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getProdi() {
        return prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
