package com.example.berneteprojetandroid.mathematiquesData;

public class Multiplication {
    private final int m_operande1, m_operande2, m_resultat;
    private int m_calcul;


    public Multiplication(int operande1, int operande2) {
        this.m_operande1 = operande1;
        this.m_operande2 = operande2;
        this.m_resultat = operande1 * operande2;
    }

    public int getOperande1() {
        return m_operande1;
    }

    public int getOperande2() {
        return m_operande2;
    }

    public int getResultat() {
        return m_resultat;
    }

    public int getCalcul() {
        return m_calcul;
    }

    public void setCalcul(int calcul) {
        this.m_calcul = calcul;
    }

    public boolean resultatJuste() {
        return (getResultat()==getCalcul());
    }
}
