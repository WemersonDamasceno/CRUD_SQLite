package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class ProcurarActivity extends AppCompatActivity {
EditText edPesquisar;
TextView nomeAlunoRetorno;
Aluno AlunoRetornado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procurar);


        edPesquisar = findViewById(R.id.edPesquisar);
        nomeAlunoRetorno = findViewById(R.id.nomeAlunoRetorno);



        edPesquisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                procurarAluno(editable.toString());
            }
        });

    }

    private void procurarAluno(String nome) {
        AlunoDAO alunoDAO = new AlunoDAO(this);
        for (Aluno a : alunoDAO.getListAlunos()){
            if(a.nome.toLowerCase().contains(nome.toLowerCase())){
                nomeAlunoRetorno.setText(a.getNome());
            }
        }
    }
}