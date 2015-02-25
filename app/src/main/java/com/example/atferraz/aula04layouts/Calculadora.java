package com.example.atferraz.aula04layouts;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Calculadora extends Activity {

    // atributos da activity
    private String tempDisplay  = "";        // recebe o valor do display
    private String tempOperador = "";        // recebe o símbolo da operação em curso



    // Super: criação da activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora_phone);
/*
        // Fragmentmanager permite manipular FragmentsBasic
        FragmentManager fragManeger = getFragmentManager();

        // FragmentTransaction associar, remover, substituir fragments à activity
        FragmentTransaction fragTransaction = fragManeger.beginTransaction();

        //Configuration pode receber quaisquer tipo informações do aparelho
        // No Caso interessa receber as configurações do aparelho como a Orientação atual
        // o que nos permite ativar a fragment correspondente
        Configuration configInfo = getResources().getConfiguration();

        // Se a orientação do aparelho for landscape
        if(configInfo.orientation == Configuration.ORIENTATION_LANDSCAPE){

            // Cria um objeto da nossa classe CalculadoraFragmengtPhoneLandscape
            CalculadoraFragmentPhoneLandscape fragmentPhoneLandscape = new CalculadoraFragmentPhoneLandscape();

            // Substitui o atual fragment pelo landscape para phone
            fragTransaction.replace(android.R.id.content, fragmentPhoneLandscape);

        }
        else{
            // Cria um objeto da nossa classe CalculadoraFragmengtPhonePortrait
            CalculadoraFragmentPhonePortrait fragmentPhonePortrait = new CalculadoraFragmentPhonePortrait();

            // Substitui o atual fragment pelo portrait para phone
            fragTransaction.replace(android.R.id.content, fragmentPhonePortrait);
        }

        // finalmente é necessário fazer executar a substituição do fragnent
        fragTransaction.commit();
*/
    }

//todo: display: décimais


    // Método da Calculadora
    public void onClickCalcula(View v){

        TextView textViewDisplay = (TextView) findViewById(R.id.textViewDisplay);
        AlertDialog msgBox = new AlertDialog.Builder(this).create();

        switch (((Button)v).getText().toString()){
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                /*
                textViewDisplay.setText( String.valueOf(
                        Double.parseDouble( textViewDisplay.getText().toString() )) +
                        Double.parseDouble(((Button)v).getText().toString()));
                */
                if(textViewDisplay.getText()=="0"){
                    //Se o valor no display for 0, substitui pelo valor da  tecla
                    textViewDisplay.setText(((Button)v).getText().toString());
                    //todo: não tira o zero inicial
                }
                else{
                    //caso contrário insere à direita do digíto que lá constar.
                    textViewDisplay.setText(textViewDisplay.getText() + ((Button)v).getText().toString());
                }
                break;

            case "+":
            case "-":
            case "*":
            case "/":
                Toast.makeText(this, "Botão Clicado: "+((Button)v).getText().toString(), Toast.LENGTH_LONG).show();
                tempDisplay = textViewDisplay.getText().toString();
                tempOperador = ((Button)v).getText().toString();
                textViewDisplay.setText("");
                break;

            case "Back":
                Toast.makeText(this, "Botão Clicado: "+((Button)v).getText().toString(), Toast.LENGTH_LONG).show();
                textViewDisplay.setText(textViewDisplay.getText().subSequence(0, (textViewDisplay.getText().length()-1 )));
                break;

            case "M":
                Toast.makeText(this, "Botão Clicado: "+((Button)v).getText().toString(), Toast.LENGTH_LONG).show();
                //todo: M guarda num atributo temp e falta fazer M+, para acrescentar esse valor no display
                break;

            case "C":
                Toast.makeText(this, ((Button)v).getText().toString()+" Limpa o ecrã", Toast.LENGTH_LONG).show();
                textViewDisplay.setText("");
                break;

            case "CE":
                Toast.makeText(this, ((Button)v).getText().toString()+" Limpa o ecrã e Memória", Toast.LENGTH_LONG).show();
                textViewDisplay.setText("0");
                tempDisplay  = "";
                tempOperador = "";
                break;

            case "=":
                Toast.makeText(this, "RESULTADO", Toast.LENGTH_LONG).show();
                if(textViewDisplay.getText().toString().isEmpty()){
                    msgBox.setTitle("ATENÇÃO");
                    msgBox.setMessage("O Display encontra-se vazio");
                    msgBox.show();
                }
                else{
                    double result = 0;
                    switch(tempOperador){

                        case "+":
                            result = Double.parseDouble(tempDisplay) + Double.parseDouble( textViewDisplay.getText().toString() );
                            break;

                        case "-":
                            result = Double.parseDouble(tempDisplay) - Double.parseDouble( textViewDisplay.getText().toString() );
                            break;

                        case "*":
                            result = Double.parseDouble(tempDisplay) * Double.parseDouble( textViewDisplay.getText().toString() );
                            break;

                        case "/":
                            //todo: Sendo zero, devia entra aqui mas não entra. Testar com tostring
                            if(textViewDisplay.getText().toString().trim() == "0"){
                                msgBox.setTitle("ATENÇÃO");
                                msgBox.setMessage("O denominador da divisão não pode ser nulo");
                                msgBox.show();
                            }
                            else{
                                result = Double.parseDouble(tempDisplay) / Double.parseDouble( textViewDisplay.getText().toString() );
                            }
                            break;

                        default :
                            msgBox.setTitle("ATENÇÃO");
                            msgBox.setMessage("O Operador "+tempOperador+" nao existe");
                            msgBox.show();
                    }
                    //todo: verificar se isto está aqui bem. E se default?
                    textViewDisplay.setText( String.valueOf(result) );

                    //todo: falta azerar as vars temp. Sempre após a boa operação. E se default?
                }


                break;


            //todo Desenvolver as teclas das funções científicas

            default :
                // Caixa de mensagem do tipo alert
                //AlertDialog msgBox = new AlertDialog.Builder(this).create();
                msgBox.setTitle("ATENÇÃO");
                msgBox.setMessage("O Botão: "+((Button) v).getText()+" nao existe");
                msgBox.show();
        }



    }


    //-------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
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
