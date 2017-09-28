package br.ufrn.eaj.tads.meuslivros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.orm.SugarContext;

public class Main2Activity extends AppCompatActivity {
        final static int RESULT_CODE = 1;
        final static int RESULT_TWO = 2;
        final static int  RESULT_UPDATE = 6;
    EditText tv_titulo;
    EditText tv_autor;
    EditText tv_ano;
    RatingBar rt_nota;
    long id_update ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SugarContext.init(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        tv_titulo = (EditText) findViewById(R.id.editText);
        tv_autor = (EditText) findViewById(R.id.editText2);
        tv_ano = (EditText) findViewById(R.id.editText3);
        rt_nota = (RatingBar) findViewById(R.id.ratingBar);

        if(bundle != null){
            tv_titulo = (EditText) findViewById(R.id.editText);
            tv_autor = (EditText) findViewById(R.id.editText2);
            tv_ano = (EditText) findViewById(R.id.editText3);
            rt_nota = (RatingBar) findViewById(R.id.ratingBar);

            tv_titulo.setText(bundle.getString("titulo"));
            tv_ano.setText(String.valueOf(bundle.getInt("ano")));
            tv_autor.setText(bundle.getString("autor"));
            rt_nota.setRating((int) bundle.getDouble("nota"));
            id_update = bundle.getLong("id");
        }


        Button btn_salvar = (Button) findViewById(R.id.button3);
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = tv_titulo.getText().toString();
                String autor = tv_autor.getText().toString();
                int ano =Integer.valueOf( tv_ano.getText().toString());
                double nota = rt_nota.getRating() ;

                Livro livro = new Livro(titulo,autor,ano,nota);

                livro.save(livro);

                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();

            }
        });
        Button bnt_cancelar = (Button) findViewById(R.id.button4);
        bnt_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

        Button btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titulo = tv_titulo.getText().toString();
                String autor = tv_autor.getText().toString();
                int ano =Integer.valueOf( tv_ano.getText().toString());
                double nota = rt_nota.getRating() ;
                Livro livro =  Livro.findById(Livro.class,id_update);
                livro.setAno(ano);
                livro.setAutor(autor);
                livro.setNota(nota);
                livro.setTitulo(titulo);
                livro.save();
                Intent intent = new Intent();
                setResult(RESULT_UPDATE,intent);
                finish();

            }
        });




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }
}
