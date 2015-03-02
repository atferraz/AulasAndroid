package com.example.atferraz.aula04layouts;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ListViewStringsWithImage extends ActionBarActivity {

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
                Toast.makeText(ListViewStringsWithImage.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/**
 * Created by Ferraz on 17/02/2015.
 */
class ListViewStringsAdapter extends ArrayAdapter<String> {

    // Construtor: serve apenas para receber e enviar para a super classe
    ListViewStringsAdapter(Context context, String[] listaAlunos){

        super(context, R.layout.list_view_row_layout_ex2, listaAlunos);
    }

    // getView é executado na superclasse, em ciclo, para processar cada um dos itens da
    // ListView, tantas vezes como o numero de elementos do array de strings
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // LayoutInflater é um processador de Layout
        LayoutInflater meuInflater = LayoutInflater.from(getContext());

        // Processar o itemLayout da nossa listView
        View itemLayout = meuInflater.inflate(R.layout.list_view_row_layout_ex2, parent, false);

        // Agora é apenas preciso ligar os dados a cada View do Layout do item

        // Extrai uma string do array de strings
        String aluno = getItem(position);

        // obter controlo da ViewImage e associar-lhe a imagem pretendida.
        ImageView itemImage = (ImageView) itemLayout.findViewById(R.id.imageViewAluno);
        itemImage.setImageResource(R.drawable.ic_launcher);

        // obter controlo da LargeTextView e associar-lhe a string pretendida.
        TextView itemNomeAluno = (TextView) itemLayout.findViewById(R.id.textViewNome);
        itemNomeAluno.setText(aluno);

        return itemLayout;
    }
}
