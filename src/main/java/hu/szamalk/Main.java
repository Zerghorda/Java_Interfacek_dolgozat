package hu.szamalk;

import hu.szamalk.modall.Szak;

import java.util.Collections;


public class Main {
    public static void main(String[] args) {
    feladatok();
    }

    private static void feladatok() {
        Szak szak =  new Szak("szak");
        System.out.println(szak);
        szak.getTargyak().sort(Szak.rendezTargyNev());
        System.out.println("Név szerint rendezés:");
        System.out.println(szak.targyak);
        szak.getTargyak().sort(Szak.rendezKredit());
        System.out.println("Kredit szerint rendezés:");
        System.out.println(szak.targyak);
        System.out.println("nem jó a statisztika!");
    }

}