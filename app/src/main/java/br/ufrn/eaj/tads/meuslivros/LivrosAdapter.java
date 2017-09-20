package br.ufrn.eaj.tads.meuslivros;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Aluno on 13/09/2017.
 */

public class LivrosAdapter extends RecyclerView.Adapter {
    Context context;
    List<Livro> livros;
    ViewHolder ultimoItem;


    public LivrosAdapter(Context context, List<Livro> l){
        this.context = context;
        this.livros = l;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.livro_inflater,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewholder, final int position) {
        final ViewHolder holder = (ViewHolder) viewholder ;

        Livro livroEscolhido = livros.get(position);
        holder.ano.setText(livroEscolhido.getAno()+"");
        holder.autor.setText(livroEscolhido.getAutor());
        holder.rating.setNumStars((int) livroEscolhido.getNota());
        holder.titulo.setText(livroEscolhido.getTitulo());

        holder.row.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                if(ultimoItem != null ){
                    ultimoItem.row.setBackgroundColor( Color.parseColor("#ffffff"));
                }else{
                    holder.row.setBackgroundColor(Color.parseColor("#f00000"));
                    ultimoItem = holder;
                }
            }
        });


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }


}
