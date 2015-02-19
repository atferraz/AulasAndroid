package com.example.atferraz.aula04layouts;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by Ferraz on 15/01/2015.
 */

//todo: utilitários para usar no dev.
public class Utils {
    /*
    public static class Msg{

        //private String title;
        //private String message;

        // Construtores--------------
        //private Msg(){}

        public static void show(String title, String message)
        {
            // Caixa de mensagem do tipo alert
            AlertDialog msgBox = new AlertDialog.Builder(this).create();
            msgBox.setTitle(title);
            msgBox.setMessage(message);
            msgBox.show();
        }

    }

    public static class Globais extends ActionBarActivity {

        // Salta para uma activity, passada pela View b
        public static void buttonOnClickJump2Activity2(View b) {

            //Animação do botão
            Animation viewAnim = AnimationUtils.loadAnimation(this, R.anim.scale_up);
            // associação ao botão que chamar o presente método.
            b.startAnimation(viewAnim);

            switch(((Button)b).getText().toString())    // extrai o Text do botão
            {
                case "FrameLayout" :
                    startActivityForResult(new Intent(b.getContext(), FrameLayout.class), 0);
                    break;

                case "GridLayout" :
                    startActivityForResult(new Intent(b.getContext(), GridLayout.class), 0);
                    break;

                case "LinearLayoutHorizontal" :
                    startActivityForResult(new Intent(b.getContext(), LinearLayoutHorizontal.class), 0);
                    break;

                case "LinearLayoutVertical" :
                    startActivityForResult(new Intent(b.getContext(), LinearLayoutVertical.class), 0);
                    break;

                case "RelativeLayout" :
                    // Caixa de mensagem do tipo alert
                    AlertDialog msgBox1 = new AlertDialog.Builder(this).create();
                    msgBox1.setTitle("ATENÇÃO");
                    msgBox1.setMessage("A activity: foi chamada pelo botão "+((Button) b).getText()+" da FrameLayout");
                    msgBox1.show();
                    //startActivityForResult(new Intent(b.getContext(), RelativeLayout.class), 0);
                    break;
                case "TableLayout" :
                    startActivityForResult(new Intent(b.getContext(), TableLayout.class), 0);
                    break;

                default :
                    // Caixa de mensagem do tipo alert
                    AlertDialog msgBox = new AlertDialog.Builder(this).create();
                    msgBox.setTitle("ATENÇÃO");
                    msgBox.setMessage("A activity: "+((Button) b).getText()+" nao existe");
                    msgBox.show();
            }

            // animaçao da activity. É um método void que recebe os ids das xml com a animação
            overridePendingTransition(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
        }

    }*/
}
