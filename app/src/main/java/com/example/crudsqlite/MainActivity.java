package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
EditText nome;
EditText cpf;
EditText telefone;
Button btnSalvar;
AlunoDAO alunoDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome = findViewById(R.id.nomeAlunoForm);
        cpf = findViewById(R.id.cpfAlunoForm);
        telefone = findViewById(R.id.tellAlunoForm);
        btnSalvar = findViewById(R.id.btnSalvar);
        alunoDAO = new AlunoDAO(this);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno aluno = new Aluno();
                aluno.setCpf(cpf.getText().toString());
                aluno.setNome(nome.getText().toString());
                aluno.setTelefone(telefone.getText().toString());

                long id = alunoDAO.inserirAluno(aluno);
                Log.i("teste","id: "+id);
                //limpar formulario
                clearForm();
            }
        });







    }

    private void clearForm() {
        nome.setText("");
        cpf.setText("");
        telefone.setText("");
    }
}