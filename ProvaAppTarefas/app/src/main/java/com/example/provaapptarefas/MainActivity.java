package com.example.suaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.suaapp.adapter.TarefaAdapter;
import com.example.suaapp.database.AppDatabase;
import com.example.suaapp.model.Tarefa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppDatabase db;
    private List<Tarefa> tarefas;
    private TarefaAdapter adapter;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerTarefas);
        btnAdd = findViewById(R.id.btnAdd);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "tarefas-db").allowMainThreadQueries().build();

        btnAdd.setOnClickListener(v -> {
            startActivity(new Intent(this, AddTarefaActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarTarefas();
    }

    private void carregarTarefas() {
        tarefas = db.tarefaDao().listar();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TarefaAdapter(tarefas, tarefa -> {
            db.tarefaDao().excluir(tarefa);
            carregarTarefas();
        });
        recyclerView.setAdapter(adapter);
    }
}
