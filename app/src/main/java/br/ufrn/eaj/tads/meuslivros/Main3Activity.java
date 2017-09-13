package br.ufrn.eaj.tads.meuslivros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    ArrayList<Livro> listaLivros = new ArrayList();
    int cont;
    TextView tv_titulo;
    TextView tv_autor;
    TextView tv_ano;
    TextView tv_nota;
    final static int RESULT_ONE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        cont = 0;
        tv_titulo = (TextView) findViewById(R.id.tv1);
        tv_autor = (TextView) findViewById(R.id.tv2);
        tv_ano = (TextView) findViewById(R.id.tv3);
        tv_nota = (TextView) findViewById(R.id.tv4);



        listaLivros = (ArrayList<Livro>) Livro.findAll(Livro.class);

        final Button btn_retornar = (Button) findViewById(R.id.button5);
        final Button btn_avancar = (Button) findViewById(R.id.button6);

        btn_retornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont < 1){
                    btn_retornar.setVisibility(View.INVISIBLE);
                }else{
                    btn_avancar.setVisibility(View.VISIBLE);
                    btn_retornar.setVisibility(View.VISIBLE);
                    cont --;
                    exibir(cont);
                }
            }
        });
        btn_avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cont > listaLivros.size()-2){
                    btn_avancar.setVisibility(View.INVISIBLE);
                }else {
                    btn_retornar.setVisibility(View.VISIBLE);
                    btn_avancar.setVisibility(View.VISIBLE);
                    cont ++;
                    exibir(cont);
                }


            }
        });
        if(listaLivros.size() == 0) {
            Intent intent = new Intent();
            setResult(RESULT_ONE,intent);
            finish();
        }else{
            exibir(cont);
        }

    }

    public void exibir(int cont){
        tv_titulo.setText(listaLivros.get(cont).getTitulo());
        tv_autor.setText(listaLivros.get(cont).getAutor());
       tv_ano.setText(String.valueOf(listaLivros.get(cont).getAno()));
       tv_nota.setText(String.valueOf(listaLivros.get(cont).getNota()));
    }
}
