package br.ufrn.eaj.tads.meuslivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class ListarActivity extends AppCompatActivity {
    List livros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        buscaDados();




    }


    public void buscaDados(){
        Livro l = new Livro();
        

    }

}
