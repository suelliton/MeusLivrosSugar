package br.ufrn.eaj.tads.meuslivros;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static br.ufrn.eaj.tads.meuslivros.Main2Activity.RESULT_TWO;
import static br.ufrn.eaj.tads.meuslivros.Main3Activity.RESULT_ONE;

public class MainActivity extends AppCompatActivity {
        final static int request_one = 1;
        final static int request_two = 2;
    ConstraintLayout constraint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraint = (ConstraintLayout) findViewById(R.id.laranja);
        Button btn_cadastrar = (Button) findViewById(R.id.button);
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,request_one);
            }
        });

        Button btn_listar = (Button) findViewById(R.id.button2);
        btn_listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivityForResult(intent,request_two);
            }
        });


    }
    public void callSnack(String message){
        Snackbar snack = Snackbar.make(constraint, message, Snackbar.LENGTH_LONG)
                .setAction("", new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {

                    }
                });
        snack.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
              callSnack("CADASTRO REALIZADO COM SUCESSO!!");
            }else if(resultCode == RESULT_CANCELED){
              callSnack("OPERAÇÃO CANCELADA!!");
            }

        }else if(requestCode == 2){
            if(resultCode == RESULT_ONE){
                callSnack("NENHUM LIVRO CADASTRADO!!");
            }
        }
    }
}
