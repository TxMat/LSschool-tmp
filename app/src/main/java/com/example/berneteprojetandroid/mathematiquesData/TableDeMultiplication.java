package com.example.berneteprojetandroid.mathematiquesData;

import java.util.ArrayList;

public class TableDeMultiplication {
    private ArrayList<Multiplication> multiplications;

    public TableDeMultiplication(int choixNombre) {
        multiplications = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            Multiplication multiplication = new Multiplication(choixNombre, i);
            multiplications.add(multiplication);
        }
    }

    public ArrayList<Multiplication> getMultiplications() {
        return multiplications;
    }

    public Multiplication getMultiplicationIndice(int indice) {
        return multiplications.get(indice);
    }


    public int nbReponsesJustes(){
        int nb = 0;
        for (Multiplication multiplication : multiplications){
            if (multiplication.resultatJuste()) {
                nb++;
            }
        }
        return nb;
    }
}
