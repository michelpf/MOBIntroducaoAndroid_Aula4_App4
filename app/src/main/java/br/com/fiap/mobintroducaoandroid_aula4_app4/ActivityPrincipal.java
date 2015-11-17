package br.com.fiap.mobintroducaoandroid_aula4_app4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityPrincipal extends AppCompatActivity {

    ListView lv = null;
    List<MyItemAcoes> itens = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = (ListView) findViewById(R.id.lv);
        itens = new ArrayList<>();

        itens.add(new MyItemAcoes(R.mipmap.ic_seta_baixo,"Petrobras PN"));
        itens.add(new MyItemAcoes(R.mipmap.ic_seta_cima,"ItauUnibanco PN"));
        itens.add(new MyItemAcoes(R.mipmap.ic_seta_baixo, "Bradesco PN"));
        itens.add(new MyItemAcoes(R.mipmap.ic_seta_baixo, "Vale PNA PN"));

        MyAdapterAcoes adaptador = new MyAdapterAcoes(this,itens);

        lv.setAdapter(adaptador);


    }


    public void calcular(View v){
        int total=0;

        for (int i=0;i<lv.getAdapter().getCount();i++){
            MyItemAcoes item = (MyItemAcoes) lv.getAdapter().getItem(i);
            total+=item.getValor();
        }

        Toast.makeText(this, "Valor Total=" + total, Toast.LENGTH_SHORT).show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
