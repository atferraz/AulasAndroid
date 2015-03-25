package com.example.atferraz.aula04layouts;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;


public class LayoutRelative extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
    }


    // Salta para uma activity, passada pela View b
    public void buttonOnClickJump2Activity(View b) {

        //Animação do botão
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        // associação ao botão que chamar o presente método.
        b.startAnimation(animation);

        AlertDialog msgBox = new AlertDialog.Builder(this).create();

        switch(((Button)b).getText().toString())    // extrai o Text do botão
        {
            case "FrameLayout" :
                startActivityForResult(new Intent(b.getContext(), LayoutFrame.class), 0);
                break;

            case "GridLayout" :
                startActivityForResult(new Intent(b.getContext(), LayoutGrid.class), 0);
                break;

            case "LinearLayoutHorizontal" :
                startActivityForResult(new Intent(b.getContext(), LayoutLinearHorizontal.class), 0);
                break;

            case "LinearLayoutVertical" :
                startActivityForResult(new Intent(b.getContext(), LayoutLinearVertical.class), 0);
                break;

            case "RelativeLayout" :
                startActivityForResult(new Intent(b.getContext(), LayoutRelative.class), 0);
                break;
            case "TableLayout" :
                startActivityForResult(new Intent(b.getContext(), LayoutTable.class), 0);
                break;
            case "Animação de Views" :
                startActivityForResult(new Intent(b.getContext(), ViewsAnimation.class), 0);
                break;
            case "Calculadora" :
                startActivityForResult(new Intent(b.getContext(), Calculadora.class), 0);
                break;
            case "ListViewStrings" :
                startActivityForResult(new Intent(b.getContext(), ListViewStrings.class), 0);
                break;
            case "ListViewStringsFotos" :
                startActivityForResult(new Intent(b.getContext(), ListViewStringsWithImage.class), 0);
                break;
            case "ListViewFotos" :
                startActivityForResult(new Intent(b.getContext(), ListViewAlunosFotos.class), 0);
                break;
            case "FragmentsBasicXml" :
                startActivityForResult(new Intent(b.getContext(), FragmentsBasicXml.class), 0);
                break;
            case "FragmentsBasicJava" :
                startActivityForResult(new Intent(b.getContext(), FragmentsBasicJava.class), 0);
                break;
            case "FragmentsSliddingFixed" :
                msgBox.setTitle("ATENÇÃO");
                msgBox.setMessage("Resolver ERRO: startActivityForResult(fragment) ");
                msgBox.show();
                //startActivityForResult(new Intent(b.getContext(), FragmentsTabsSlidding.class), 0);
                break;


            default :
                // Caixa de mensagem do tipo alert
                //AlertDialog msgBox = new AlertDialog.Builder(this).create();
                msgBox.setTitle("ATENÇÃO");
                msgBox.setMessage("A activity: "+((Button) b).getText()+" nao existe");
                msgBox.show();
        }

        // animaçao da activity. É um método void que recebe os ids das xml com a animação
        overridePendingTransition(R.anim.translate_all_left, R.anim.translate_all_right);
    }


    // metodo para associar criar uma msgBox do tipo alert
    public void buttonOnClickAlert(View b){

        // Caixa de mensagem do tipo alert
        AlertDialog msgBox = new AlertDialog.Builder(this).create();
        msgBox.setTitle("ATENÇÃO");
        msgBox.setMessage("Botão clicado foi: "+((Button) b).getText());
        msgBox.show();
    }

    // metodo para associar criar uma msgBox do tipo Toast (método da classe super)
    public void buttonOnClickToast(View b){

        Toast.makeText(LayoutRelative.this, "Botão clicado foi: " +
                ((Button) b).getText(), Toast.LENGTH_LONG).show();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
//77777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_relative_layout, menu);
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
