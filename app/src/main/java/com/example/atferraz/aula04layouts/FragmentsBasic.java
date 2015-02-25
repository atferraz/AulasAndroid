package com.example.atferraz.aula04layouts;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class FragmentsBasic extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_basic);

        // adicionar o Fragment à activity e iniciar a Transaction

        FragmentB fragB = new FragmentB();                                      // Cria um novo objeto da nossa classe.
        FragmentManager fragManager = getFragmentManager();                     // Cria um FragmentManager
        FragmentTransaction fragTransaction = fragManager.beginTransaction();   // Cria e inicia a transaction
        fragTransaction.add(R.id.activity_fragment, fragB, "fragB");
                    // 1º parametro: o id do layout da activity, que ainda é preciso definir
                    // 2º parametro: fragB que é o objeto do fragment a usar
                    // 3º parametro: um nome para ser usado como "tag", no método getFragmentByTag( )

        fragTransaction.commit();                                               // executa
    }
}
