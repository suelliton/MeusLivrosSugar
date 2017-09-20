package br.ufrn.eaj.tads.meuslivros;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

import static br.ufrn.eaj.tads.meuslivros.Main2Activity.RESULT_UPDATE;

public class ListarActivity extends AppCompatActivity {
    List<Livro> livros =  new ArrayList<Livro>();
    final static int REQUEST_UPDATE = 5;
    LinearLayout linear ;
    RecyclerView recyclerView;
    LivrosAdapter adapter;
    int position_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        SugarContext.init(this);
        buscaDados();
        adapter = new LivrosAdapter(this,livros);
        linear = (LinearLayout) findViewById(R.id.linearLayout);

        recyclerViewStart();
    }

    public void buscaDados(){
       livros =  Livro.listAll(Livro.class);
        Toast.makeText(this, ""+livros.size(), Toast.LENGTH_SHORT).show();

    }
    public boolean delete(Livro l){
        try {
            Livro.delete(l);
            return true;
        }catch (RuntimeException c){
            return false;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SugarContext.terminate();
    }

    public void callSnack(String message){
        Snackbar snack = Snackbar.make(linear, message, Snackbar.LENGTH_LONG)
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
        if(requestCode == REQUEST_UPDATE){
            if(resultCode == RESULT_UPDATE){
                Intent i = new Intent(ListarActivity.this,ListarActivity.class);
                startActivity(i);
                finish();
                callSnack("Livro modificado com sucesso!");
                adapter.notifyItemChanged(position_update);
                recyclerViewStart();
            }
        }
    }

    public void recyclerViewStart(){
        recyclerView = (RecyclerView) findViewById(R.id.reciclerview);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void clickinho(View view, int position) {
//                        Bundle bundle = new Bundle();
//                        bundle.putString("titulo",livros.get(position).getTitulo());
//                        bundle.putString("autor",livros.get(position).getAutor());
//                        bundle.putInt("ano",livros.get(position).getAno());
//                        bundle.putDouble("nota",livros.get(position).getNota());
//                        bundle.putLong("id",livros.get(position).getId());
//                        position_update = position;
//                        Intent intent = new Intent(ListarActivity.this,Main2Activity.class);
//                        intent.putExtras(bundle);
//                        startActivityForResult(intent,REQUEST_UPDATE);
//                        finish();
                        //startActivityForResult(intent,REQUEST_UPDATE);
                    }

                    @Override
                    public void clickao(View view, int position) {

                        recyclerView.getAdapter().notifyDataSetChanged();
                        if(delete(livros.get(position))){
                            Toast.makeText(ListarActivity.this, "Deletou", Toast.LENGTH_SHORT).show();
                            livros.remove(position);
                        }
                    }
                })

        );
    }
}
