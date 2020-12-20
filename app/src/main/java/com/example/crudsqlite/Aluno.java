package com.example.crudsqlite;

import android.os.Parcel;
import android.os.Parcelable;

public class Aluno implements Parcelable {
    int id;
    String nome;
    String cpf;
    String telefone;

    public Aluno() {
    }

    public Aluno(int id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    protected Aluno(Parcel in) {
        id = in.readInt();
        nome = in.readString();
        cpf = in.readString();
        telefone = in.readString();
    }

    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel in) {
            return new Aluno(in);
        }

        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nome);
        parcel.writeString(cpf);
        parcel.writeString(telefone);
    }

    @Override
    public String toString() {
        return "Nome: "+nome+"\nCPF: "+cpf+"\nTelefone: "+telefone;
    }
}
