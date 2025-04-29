package com.example.suaapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.suaapp.dao.TarefaDao;
import com.example.suaapp.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TarefaDao tarefaDao();
}
