package com.example.atferraz.aula04layouts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


/**
 * Created by Ferraz on 12/02/2015.
 * Este adapter, prepara uma lista de objs do tipo Alunos, para uma listView
 * com um itemLayout específico.
 */
public class ListViewAlunosAdapter extends ArrayAdapter<Aluno> {

    // Construtor, recebe a activity e a lista da dados.
    public ListViewAlunosAdapter(Context context, List<Aluno> listaAlunos){

        super(context, R.layout.list_view_row_layout, listaAlunos);

        // A classe ArrayAdapter, super, recebe:
        // 1º: a própria activity
        // 2º: o Layout dos itens da lista - (acessível diretamente)
        // 3º: a Lista de dados
    }



    // getView executa o preenchimento dos dados em cada View do itemLayout.

    @Override public View getView(int position, View convertView, ViewGroup parent) {


        // Este método vai ser executado tantas vezes como os objs existentes na lista de dados
        // Obtem uma cópia do itemLayout, preenche as suas Views com dados de um obj da lista de dados
        // e devolve-o à super classe que o desenha no posição correta da listView.


        // recebe 3 elementos:
        // position - da lista de dados a ser processada: 0 será o primeiro aluno na lista
        // convertView será a View itemLayout a ser devolvida já preenchida
        // parent é a rootLayout, onde cada itemLayout vai ser desenhada.


        // LayoutInflater processa o desenho de cada item da ListView, com o item Layout indicado.
        if(convertView == null){
            // Se já existir um itemLayout, usa-o, caso contrário cria um novo.
            convertView = LayoutInflater.from(getContext()).inflate( R.layout.list_view_row_layout, parent, false);

            // Passamos o itemLayout a usar, o rootLayou onde desenha, bool para ligar ou não ao
            // rootlayout. Se true, fica ligado, false ficam independentes.

        }


        // Agora é apenas preciso ligar os dados a cada View do Layout do item. Este é um trabalho
        // da classe adapter (super) que vai repetir o que definirmos a seguir, para cada um dos objs
        // existentes na lista da dados.

        // Extrai um objeto da lista, definido por "position"
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
