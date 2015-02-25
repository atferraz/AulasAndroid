package com.example.atferraz.aula04layouts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class FragmentsTabsSlidding extends FragmentActivity {

    static ViewPager viewPager = null;     // Criação de um ViewPager para controlo do
                                    // Slidding como atributo para acesso geral.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_tabs_slidding);

        // No arranque da activity liga-se o Viewpager ao Layout da activity
        viewPager = (ViewPager) findViewById(R.id.fragmentsTabsSlidding);

        // Associa o novo FragmentAdapter ao ViewPager
        FragmentManager fm = getSupportFragmentManager();   // da support.v4
        viewPager.setAdapter(new MeuFragmentAdapter(fm));
    }
}

class MeuFragmentAdapter extends FragmentPagerAdapter{

    MeuFragmentAdapter(FragmentManager fm) {        // Recebe o fragment Adapter no contrutor.
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {         // Devolve um dos Fragments, recebida a positção
        Fragment fragment = null; //

        if(position == 0){
            fragment = new FragmentS1();
        }
        if(position == 1){
            fragment = new FragmentS2();
        }
        if(position == 2){
            fragment = new FragmentS3();
        }
        return fragment;
    }

    @Override
    public int getCount() {                         // devolve o nº de Fragments tratados nesta activity
        return 3;
    }
}
