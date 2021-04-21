package com.company;

import java.io.Serializable;

public abstract class ContBancar implements Serializable {
    public int getId() {
        return id;
    }

    private int id;
    protected double suma;

    public ContBancar(int id, double suma) {
        this.id = id;
        this.suma = suma;
    }

    public double getSuma() {
        return suma;
    }

    public void adauga(double x) {
        suma += x;
    }

    private boolean isPossible(double x) {
        if (suma >= x)
            return true;
        else
            return false;
    }

    public void extract(double x) {
        if (isPossible(x) == true)
            suma -= x;
        else
            System.out.println("Operation failed");
    }

    public void afisare() {
        System.out.println(suma);
    }
}