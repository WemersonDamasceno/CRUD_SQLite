package com.example.crudsqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListarAlunosActivity extends AppCompatActivity {
    ListView rvListAlunos;
    AlunoDAO alunoDAO;
    List<Aluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_alunos);

        rvListAlunos = findViewById(R.id.rvListAlunos);
        alunoDAO = new AlunoDAO(this);

        alunos = alunoDAO.getListAlunos();

        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alunos);

        rvListAlunos.setAdapter(adapter);



        registerForContextMenu(rvListAlunos);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    public void excluir(MenuItem item){
        AlunoDAO alunoDAO = new AlunoDAO(this);

        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Aluno alunoExcluir = alunos.get(menuInfo.position);

        alunoDAO.excluirAluno(alunoExcluir);
        alunos.remove(alunoExcluir);
        recreate();

    }

}