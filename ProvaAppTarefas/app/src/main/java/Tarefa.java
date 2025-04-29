package com.example.suaapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tarefa {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String titulo;
    public String descricao;
}
