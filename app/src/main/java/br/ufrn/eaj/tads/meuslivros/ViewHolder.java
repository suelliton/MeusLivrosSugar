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
        titulo =   v.findViewById(R.id.text_titulo);
        autor =  v.findViewById(R.id.text_autor);
        ano =  v.findViewById(R.id.text_ano);
        rating =  v.findViewById(R.id.rating_nota);

    }


}
