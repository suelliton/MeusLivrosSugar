package br.ufrn.eaj.tads.meuslivros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Aluno on 13/09/2017.
 */

public class LivrosAdapter extends BaseAdapter {
    Context context;
    List<Livro> livros;

    public LivrosAdapter(Context context, List<Livro> l){
        this.context = context;
        this.livros = l;
    }@Override
    public int getCount() {
        return livros != null ? livros.size() : 0;
    }
    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        ViewHolder holder;
        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.livro_inflater, viewGroup,
                    false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }


        Livro livroEscolhido = livros.get(i);
        holder.titulo.setText(livroEscolhido.getTitulo());
        holder.autor.setText(livroEscolhido.getAutor());
        holder.ano.setText(""+livroEscolhido.getAno());
        holder.rating.setNumStars((int) livroEscolhido.getNota());



        return view;
    }
}
