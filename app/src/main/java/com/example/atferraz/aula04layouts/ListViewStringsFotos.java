package com.example.atferraz.aula04layouts;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListViewStringsFotos extends ActionBarActivity {

    //Array de dados a ser passado ao arrayadapter
    private String[] nomesAlunos = {"Bruno Coimbra","catalin Criste","David Sousa","João Ventura",
            "Jorge Silva","Marcelo Rachado","Mariana Costa","Patrícia Carmo",
            "Ricardo Gomes","Rúben severino","Rui Ricardo","Samuel Santos" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        // obter o controlo da ListView Gráfica
        ListView listViewTurmas = (ListView) findViewById(R.id.listViewTurmas);

        // ArrayAdapter para tratar os dados: recebe o context, o row Layout e o array de dados.
        ListAdapter listViewAdapter = new ListViewStringsAdapter(this, nomesAlunos);

        // Associar o adapter à istView
        listViewTurmas.setAdapter(listViewAdapter);

        // Criar um listener para cada item
        listViewTurmas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String str = "Clicou em" + String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(ListViewStringsFotos.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
