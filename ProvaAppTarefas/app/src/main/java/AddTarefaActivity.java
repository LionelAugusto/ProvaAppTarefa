package com.example.suaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.suaapp.database.AppDatabase;
import com.example.suaapp.model.Tarefa;

public class AddTarefaActivity extends AppCompatActivity {

    private EditText etTitulo, etDescricao;
    private Button btnSalvar;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tarefa);

        etTitulo = findViewById(R.id.etTitulo);
        etDescricao = findViewById(R.id.etDescricao);
        btnSalvar = findViewById(R.id.btnSalvar);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "tarefas-db").allowMainThreadQueries().build();

        btnSalvar.setOnClickListener(v -> {
            String titulo = etTitulo.getText().toString();
            String descricao = etDescricao.getText().toString();

            if (!titulo.isEmpty() && !descricao.isEmpty()) {
                Tarefa tarefa = new Tarefa();
                tarefa.titulo = titulo;
                tarefa.descricao = descricao;
                db.tarefaDao().inserir(tarefa);
                finish();
            }
        });
    }
}

