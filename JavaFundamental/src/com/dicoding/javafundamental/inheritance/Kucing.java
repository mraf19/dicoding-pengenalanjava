package com.dicoding.javafundamental.inheritance;

public class Kucing extends Hewan implements Mamalia {
    private String ras;
    private String habitat;
    public Kucing(String ras, String habitat){
        //super(); //akan tetap memanggil construct dari parent
        this.ras = ras;
        this.habitat = habitat;
    }

    public Kucing() {
        //super(); // akan tetap memanggil constructor dari parent Class
        System.out.println("construct Kucing");
    }

    @Override
    public String toString(){
        return "Kucing ras: " + this.ras + ", habitat: " + habitat;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof  Kucing){
            Kucing other = (Kucing )obj;
            return this.ras.equals(other.ras);
        } else {
            return false;
        }
    }

    public void makan() { // overriding
        System.out.println("Kucing sedang makan..");
    }

    public void makan(String food) { // overloading
        System.out.println("Kucing makan " + food);
    }
}
