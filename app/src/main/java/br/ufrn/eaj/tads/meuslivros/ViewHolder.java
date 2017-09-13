package br.ufrn.eaj.tads.meuslivros;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Aluno on 13/09/2017.
 */

public class ViewHolder{

    final TextView titulo;
    final TextView autor;
    final TextView ano;
    final RatingBar rating ;


    public ViewHolder(View v){
        titulo = (TextView) v.findViewById(R.id.text_titulo);
        autor = (TextView) v.findViewById(R.id.text_autor);
        ano = (TextView) v.findViewById(R.id.text_ano);
        rating = (RatingBar) v.findViewById(R.id.rating_nota);
    }
}
