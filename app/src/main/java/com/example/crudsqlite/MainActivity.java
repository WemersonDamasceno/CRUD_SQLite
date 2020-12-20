package com.example.crudsqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText nome;
EditText cpf;
EditText telefone;
Button btnSalvar;
Button btnListaAlunos;
AlunoDAO alunoDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nome = findViewById(R.id.nomeAlunoForm);
        cpf = findViewById(R.id.cpfAlunoForm);
        telefone = findViewById(R.id.tellAlunoForm);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnListaAlunos = findViewById(R.id.btnListaAlunos);
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


        btnListaAlunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),ListarAlunosActivity.class));
            }
        });






    }

    private void clearForm() {
        nome.setText("");
        cpf.setText("");
        telefone.setText("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int op = item.getItemId();
        if(op == R.id.adicionar){
            startActivity(new Intent(getBaseContext(), MainActivity.class));
        }else if(op == R.id.procurar){
            startActivity(new Intent(getBaseContext(), ProcurarActivity.class));
        }else if(op == R.id.listar){
            startActivity(new Intent(getBaseContext(), ListarAlunosActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }
}