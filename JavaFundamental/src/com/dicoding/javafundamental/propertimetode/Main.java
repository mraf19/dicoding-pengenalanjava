package com.dicoding.javafundamental.propertimetode;

public class Main {
    public static void main (String[] args){
        Hewan kucing = new Hewan(2);
        kucing.jalan();
        kucing.lari();
        kucing.makan();

        // Contoh penggunaan fungsi getUmur
        System.out.println("Umurnya adalah " + kucing.getUmur());
        // Perhitungan indeks massa tubuh (BMI)
        // berat(kg) / ( tinggi(m) * tinggi(m) )
        double bmi = kucing.getBerat() / ((kucing.getTinggi() * 0.01) * (kucing.getTinggi() * 0.01));
        System.out.println("Indeks massa tubuhnya adalah " + bmi);
        System.out.println(kucing.getTinggi());
    }
}
