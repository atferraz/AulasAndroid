package com.example.atferraz.aula04layouts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ferraz on 17/02/2015.
 */
public class ListViewStringsAdapter extends ArrayAdapter<String> {

    // Construtor
    ListViewStringsAdapter(Context context, String[] listaAlunos){
        super(context, R.layout.list_view_row_layout, listaAlunos);
    }

    //getView processa todosos dados para as View do Layout row.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // LayoutInflater processa o desenho de Layout
        LayoutInflater meuInflater = LayoutInflater.from(getContext());

        // Processar o desenho do itemLayout da nossa listView
        View itemLayout = meuInflater.inflate(R.layout.list_view_row_layout, parent, false);

        // Agora é apenas preciso ligar os dados a cada View do Layout do item

        // Extrai um nome de cada vez, da lista de Alunos passada:
        String aluno = getItem(position);

        // Imagem
        ImageView itemImage = (ImageView) itemLayout.findViewById(R.id.imageViewAluno);
        itemImage.setImageResource(R.drawable.ic_launcher);

        // Nome
        TextView itemNomeAluno = (TextView) itemLayout.findViewById(R.id.textViewNome);
        itemNomeAluno.setText(aluno);

        return itemLayout;
    }
}

