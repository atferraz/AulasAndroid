package com.example.atferraz.aula04layouts;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class FragmentsBasicXml extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_basic_xml);

        // adicionar o Fragment à activity e iniciar a Transaction
    }
}
