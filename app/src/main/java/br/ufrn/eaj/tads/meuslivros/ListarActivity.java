package br.ufrn.eaj.tads.meuslivros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends AppCompatActivity {
    List<Livro> livros =  new ArrayList<Livro>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        SugarContext.init(this);
        buscaDados();

        ListView listView = (ListView) findViewById(R.id.minha_lista);
        listView.setAdapter(new LivrosAdapter(this,livros));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });




    }


    public void buscaDados(){
       livros =  Livro.listAll(Livro.class);
        Toast.makeText(this, ""+livros.size(), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }
}
