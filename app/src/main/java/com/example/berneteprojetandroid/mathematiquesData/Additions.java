package com.example.berneteprojetandroid.mathematiquesData;

public class Additions {
    private final int m_operande1, m_operande2;
    private int m_calcul, m_resultat;


    public Additions() {
        this.m_operande1 = nbRandom();
        this.m_operande2 = nbRandom();
        setResultat();
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

    public void setResultat() {
        m_resultat = getOperande1() + getOperande2();
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

    public int nbRandom() {
        return (int)(Math.random() * ((15 - 0) + 1)) + 0;
    }

}
