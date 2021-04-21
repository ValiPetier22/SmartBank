package com.company;

public class ContBancarExtins extends ContBancar {
    private double rataDobandaanuala;

    public void adaugaDobandaLunara() {
        double dobanda = suma * rataDobandaanuala / 12;
        adauga(dobanda);
    }

    @Override
    public void afisare() {
        System.out.println(suma + " " + rataDobandaanuala + " ");
    }

    public ContBancarExtins(int id, double suma, double rataDobandaanuala) {
        super(id, suma);
        this.rataDobandaanuala = rataDobandaanuala;
    }
}