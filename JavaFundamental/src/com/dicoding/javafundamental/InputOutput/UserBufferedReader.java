package com.dicoding.javafundamental.InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserBufferedReader {
    public static void main (String[] args){
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        System.out.println("Program Penjumlahan yang Sangat Sederhana.");
        int value = 0;
        int anotherValue = 0;

        try {
            System.out.print("Masukkan angka pertama: ");
            value = Integer.parseInt(bufferedReader.readLine());
            System.out.print("Masukkan angka Kedua: ");
            anotherValue = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e){
            e.printStackTrace();
        }

        int result = value + anotherValue;
        System.out.println("Hasilnya adalah: " + result);

    }

}
