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


public class LinearLayoutVertical extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_vertical);
    }

    // Salta para uma activity, passada pela View b
    public void buttonOnClickJump2Activity(View b) {

        //Animação do botão
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        // associação ao botão que chamar o presente método.
        b.startAnimation(animation);

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
                startActivityForResult(new Intent(b.getContext(), RelativeLayout.class), 0);
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
        overridePendingTransition(R.anim.abc_fade_out, R.anim.translate_all_right);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_linear_layout_vertical, menu);
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
