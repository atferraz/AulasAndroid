package com.example.atferraz.aula04layouts;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
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
                String str = "Clicou na posição " + position + ", " + aluno.getNome();
                Toast.makeText(ListViewAlunosFotos.this, str, Toast.LENGTH_SHORT).show();
            }
        });
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
        listaAlunos.add(new Aluno(12, "Rúben Severino", R.drawable.severino));
        listaAlunos.add(new Aluno(14, "Rui Ricardo", R.drawable.rui));
        listaAlunos.add(new Aluno(15, "Samuel Santos", R.drawable.samuel));
    }
}



class ListViewAlunosAdapter extends ArrayAdapter<Aluno> {

    // Construtor, recebe a activity e a lista da dados.
    public ListViewAlunosAdapter(Context context, List<Aluno> listaAlunos){

        super(context, R.layout.list_view_row_layout, listaAlunos);

        // A classe ArrayAdapter, super, recebe:
        // 1º: a própria activity
        // 2º: o Layout para os itens da ListView
        // 3º: a Lista de dados (Collection com objetos Aluno)
    }

    // getView é executado na superclasse, em ciclo, para processar cada um dos itens da
    // ListView, tantas vezes como o numero de elementos da Lista de Alunos
    @Override public View getView(int position, View convertView, ViewGroup parent) {

        // Preparação do itemLayout na ListView Gráfica.
        if(convertView == null){
            // Se já existir um itemLayout, usa-o, caso contrário cria um novo.
            convertView = LayoutInflater.from(getContext()).inflate( R.layout.list_view_row_layout, parent, false);

            // LayoutInflater é metodo da superclasse que Constroi Layouts
            // Passamos-lhe o itemLayout e a rootLayout (ListView Gráfica) onde desenha,
        }

        // Ligação dos dados de um aluno na posição "position" da Collection às Views do itemLayout
        Aluno aluno = getItem(position);

        // Imagem - obtem acesso à imageView do itemLayout e passa-lhe o id da imagem do aluno
        ImageView itemImage = (ImageView) convertView.findViewById(R.id.imageViewAluno);
        itemImage.setImageResource(aluno.getImageID());

        // número de aluno - obtem acesso à textView do itemLayout e passa-lhe o nº do aluno
        TextView itemNturma = (TextView) convertView.findViewById(R.id.textViewNumero);
        itemNturma.setText(String.valueOf(aluno.getnTurma()));
        // Atenção aos erros de tipo: Só sao detetáveis no logCat

        // Nome - obtem acesso à textView do itemLayout e passa-lhe o nome do aluno
        TextView itemNomeAluno = (TextView) convertView.findViewById(R.id.textViewNome);
        itemNomeAluno.setText(aluno.getNome());

        return convertView; // Devolve o itemLayout preenchido, pronto a ser adicionado à listView.
    }
}