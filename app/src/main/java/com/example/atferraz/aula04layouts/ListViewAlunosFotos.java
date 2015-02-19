package com.example.atferraz.aula04layouts;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListViewAlunosFotos extends ActionBarActivity {

    private List<Aluno> listaAlunos = new ArrayList<Aluno>();   // Lista de objs Alunos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        loadList();             // Executa o método para preencher a lista com alunos
        populateListView();     // Executa o meu Adapter para popular a listView
    }


    // método para popular a Lista, com os nº, nome e id da imagem dos alunos da turma
    private void loadList(){

        listaAlunos.add(new Aluno(1, "Bruno Coimbra", R.drawable.bruno_coimbra));
        listaAlunos.add(new Aluno(2, "Catalin Criste", R.drawable.catalin));
        listaAlunos.add(new Aluno(3, "David Sousa", R.drawable.david_sousa));
        listaAlunos.add(new Aluno(6, "João Ventura", R.drawable.joao_ventura));

        listaAlunos.add(new Aluno(7, "Jorge Silva", R.drawable.jorge));
        listaAlunos.add(new Aluno(8, "Marcelo Rachado", R.drawable.marcelo));
        listaAlunos.add(new Aluno(9, "Mariana Costa", R.drawable.mariana));
        listaAlunos.add(new Aluno(10, "Patrícia Carmo", R.drawable.patricia));

        listaAlunos.add(new Aluno(11, "Ricardo Gomes", R.drawable.ricardo));
        listaAlunos.add(new Aluno(12, "Rúben severino", R.drawable.severino));
        listaAlunos.add(new Aluno(14, "Rui Ricardo", R.drawable.rui));
        listaAlunos.add(new Aluno(15, "Samuel Santos", R.drawable.samuel));
    }


    // método para popular a listView java com a Lista de alunos.
    private void populateListView(){

        // obter o controlo da ListView Gráfica
        ListView listViewTurmas = (ListView) findViewById(R.id.listViewTurmas);

        // Criação de um ArrayAdapter para transformar a nossa lista de Alunos, para a ListView.
        ListViewAlunosAdapter adapter = new ListViewAlunosAdapter(this, listaAlunos);
                // Envia esta activity e a Collection listaAlunoscom

        // Associação da listView ao adapter. Passa os dados preparados para listView
        listViewTurmas.setAdapter(adapter);

                // este método vai usar a getView que redefinimos no nosso adapter
                // para construir cada um dos itens da lisView.


        // Criar um listener para cada item da ListView
        listViewTurmas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override   // alt Insert - Override methods - onItemClick
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Compor uma string com a posição no array para
                // Escrever um Toast com o id do item clicada

                Aluno aluno = listaAlunos.get(position);

                String str = "Clicou na posição "
                        + position
                        + ", " + aluno.getNome();
                Toast.makeText(ListViewAlunosFotos.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
