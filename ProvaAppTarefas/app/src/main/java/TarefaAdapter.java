package com.example.suaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suaapp.R;
import com.example.suaapp.model.Tarefa;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {

    private List<Tarefa> lista;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onDeleteClick(Tarefa tarefa);
    }

    public TarefaAdapter(List<Tarefa> lista, OnItemClickListener listener) {
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarefa, parent, false);
        return new TarefaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        Tarefa tarefa = lista.get(position);
        holder.txtTitulo.setText(tarefa.titulo);
        holder.txtDescricao.setText(tarefa.descricao);
        holder.btnExcluir.setOnClickListener(v -> listener.onDeleteClick(tarefa));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class TarefaViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitulo, txtDescricao;
        Button btnExcluir;

        public TarefaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtDescricao = itemView.findViewById(R.id.txtDescricao);
            btnExcluir = itemView.findViewById(R.id.btnExcluir);
        }
    }
}
