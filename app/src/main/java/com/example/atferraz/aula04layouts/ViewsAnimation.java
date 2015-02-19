package com.example.atferraz.aula04layouts;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class ViewsAnimation extends ActionBarActivity {

    CheckBox checkBoxJava;              // Declaração da checkBox como atributo da activity
                                        // Só vai ser ligada ao objeto dentro do método onClickAnimateView( )
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views_animation);
    }


    // Animação de uma View. Método associado a todos os eventos click dos botões da activity
    public void onClickAnimateView(View v) {

        // Associação dos objetos java com os objetos gráficos
        checkBoxJava   = (CheckBox) findViewById(R.id.checkBoxJavaXml);


        // Definição das animações,
        // São sub classes que produzem objetos de animação e que depois
        // são associadas aos Views.

        // Alpha - opacidade - recebe no construtor os valores  inicial e final da opacidade
        // Mas é preciso definir com um setDuration(miliseconds), a duração do efeito.
        final AlphaAnimation animationAlpha = new AlphaAnimation(
                1,          // 100% totalmente opaco
                0);         //   0% transparente

        animationAlpha.setDuration(1000);

        // Translate recebe 8 argumentos:
        final TranslateAnimation animationTranslate= new TranslateAnimation(

                Animation.ABSOLUTE, 0,              // fromXtype, fromXvalue
                Animation.RELATIVE_TO_PARENT, 1,    // toXtype, fromXvalue
                Animation.ABSOLUTE, 0,              // fromYtype, fromYvalue
                Animation.ABSOLUTE, 100 );          // toYtype, toYvalue

        animationTranslate.setDuration(1000);       // duração do movimento

        // Rotate
        RotateAnimation animationRotate = new RotateAnimation(
                0,                              //fromDegrees
                360,                            //toDegrees
                Animation.RELATIVE_TO_SELF,     //PivotXtype
                0.5f,                           //PivotXvalue
                Animation.RELATIVE_TO_SELF,     //PivotYtype
                0.5f);                          //PivotYvalue

        animationRotate.setDuration(1000);      // duração da rotação

        //Scale
        final ScaleAnimation animationScale = new ScaleAnimation(
                1,      // froamX
                2,      // toX
                1,      // froamY
                2);     // toY
        animationScale.setDuration(1000);


        // SET - O construtor recebe um true para activar um interpolator.....
        final AnimationSet animationSet = new AnimationSet(true);
        // Adicionar as animações pretendidas
        animationSet.addAnimation(animationAlpha);
        animationSet.addAnimation(animationTranslate);
        animationSet.addAnimation(animationRotate);
        animationSet.addAnimation(animationScale);






        switch(((Button)v).getText().toString()) {    // switch ao Text do botão

            //Animação dos botões
            case "Rotate" :
                Toast.makeText(this, "Rotate", Toast.LENGTH_LONG).show();
                if(checkBoxJava.isChecked())
                    v.startAnimation(animationRotate);  // animação por java code
                else
                    v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_360));
                break;

            case "Scale":
                Toast.makeText(this, "Scale", Toast.LENGTH_LONG).show();
                if(checkBoxJava.isChecked())
                    v.startAnimation(animationScale);
                else
                    v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_up));
                break;

            case "Alpha":
                Toast.makeText(this, "alpha [1->0]: ", Toast.LENGTH_LONG).show();
                if(checkBoxJava.isChecked())
                    v.startAnimation(animationAlpha);
                else
                    v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha_out));
                break;

            case "Translate":
                Toast.makeText(this, "Translate", Toast.LENGTH_LONG).show();
                if(checkBoxJava.isChecked())
                    v.startAnimation(animationTranslate);
                else
                    v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate_all_right));
                break;

            case "Set":
                Toast.makeText(this, "Set", Toast.LENGTH_LONG).show();
                if(checkBoxJava.isChecked())
                    v.startAnimation(animationSet);
                else
                    v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.set_scale_up_and_alpha_up));
                break;

            default:
                AlertDialog msgBox = new AlertDialog.Builder(this).create();
                msgBox.setTitle("ATENÇÃO");
                msgBox.setMessage("O nome da View clicada: " + ((Button) v).getText() + " nao existe");
                msgBox.show();
        }

    }





    //------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_views_animation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
