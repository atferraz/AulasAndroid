package com.example.atferraz.aula04layouts;

/**
 * Created by Alexandre on 09/02/2015.
 */
public class Aluno {

    private String nome;
    private int nTurma;
    private String imageName;
    private int imageID;                // R.Drawable.imageID

    public Aluno(int nTurma, String nome, int rImageID) {
        this.nTurma = nTurma;
        this.nome = nome;
        if(nTurma < 10){
            imageName = "0"+Integer.toString(nTurma);
        }
        else{
            imageName = Integer.toString(nTurma);
        }
        this.imageID=rImageID;
    }

    public int getnTurma() {
        return nTurma;
    }

    public void setnTurma(int nTurma) {
        this.nTurma = nTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int rImageID) {
        this.imageID = rImageID;
    }

}
