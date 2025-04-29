package com.example.suaapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.suaapp.model.Tarefa;

import java.util.List;

@Dao
public interface TarefaDao {
    @Insert
    void inserir(Tarefa tarefa);

    @Delete
    void excluir(Tarefa tarefa);

    @Query("SELECT * FROM Tarefa")
    List<Tarefa> listar();
}

