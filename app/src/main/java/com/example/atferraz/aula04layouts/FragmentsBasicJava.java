package com.example.atferraz.aula04layouts;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class FragmentsBasicJava extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_basic);

        FragmentA fragA = new FragmentA();                                      // Cria um novo objeto da nossa classe.
        FragmentManager fragManager = getFragmentManager();                     // Cria um FragmentManager
        FragmentTransaction fragTransaction = fragManager.beginTransaction();   // Cria e inicia a transaction
        fragTransaction.add(R.id.activity_fragment_xml, fragA, "fragA");
        // 1º parametro: o id do layout da activity
        // 2º parametro: fragA que é o objeto do fragment a usar
        // 3º parametro: um nome para ser usado como "tag", no método getFragmentByTag( )

        fragTransaction.commit();                                               // executa

    }
}
