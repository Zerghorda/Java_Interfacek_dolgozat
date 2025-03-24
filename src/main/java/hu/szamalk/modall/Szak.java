package hu.szamalk.modall;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.*;

public class Szak implements Serializable,Comparable<Szak> {

    public ArrayList<Tantargy> targyak;
    private String nev;
    private transient UUID id;
    public Szak(String nev){
        this.nev = nev;
        this.targyak =new ArrayList<>();
        ujIDGeneralas();
        szakBeolvasasa();
        szakkirasa();
        statisztika();
    }


    private void szakkirasa(){
        String hely = "targyak.dat";
        String tartalom = String.valueOf(getTargyak());
        try {
            Files.write(Path.of(hely),tartalom.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void szakBeolvasasa(){
        String hely = "tantargyak.txt";
        try {
            Files.readString(Path.of(hely));
            List<String> sorok = Files.readAllLines(Path.of(hely));
            sorok.forEach(s -> {
                if (!(s.contains("CÍM")
                        ||s.contains("KREDIT")
                        ||s.contains("TANÁR1")
                        ||s.contains("TANÁR2")
                        ||s.contains("FÉLÉV")
                        ||s.contains("CSAK_VIZSGA"))){
                    Tantargy tantargy = new Tantargy(s);
                    targyak.add(tantargy);
                }

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void statisztika(){
        String hely = "statisztika.txt";
        String tartalom = "";
        tartalom += "külömböző tárgy: " + kulombozoTargy();
        tartalom += "vizsga tárgyak: " + vizsgaTargyak();
        tartalom += "összes kredit: " + osszesKreedit();
        tartalom += "min kredit: " + minKredit();
        tartalom += "max kredit: " + maxKredit();
        try {
            Files.write(Path.of(hely),tartalom.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    private String vizsgaTargyak() {
        return null;
    }
    private int osszesKreedit() {
        int osszeg = 0;
        for (int i = 0; i < targyak.size(); i++) {
           osszeg += targyak.get(i).getKredit();
        }
        return osszeg;
    }

    private String minKredit() {
        String eredmeny = "";
        int min = 1;
        String targy = "";
        for (int i = 1; i < targyak.size(); i++) {
            if (targyak.get(i).getKredit() <min){
                min = targyak.get(i).getKredit();
                targy = targyak.get(i).getNev();
            }
            
        }
        return eredmeny+= targy + ", " + min;
    }
    private String maxKredit() {
        String eredmeny = "";
        int max = 1;
        String targy = "";
        for (int i = 1; i < targyak.size(); i++) {
            if (targyak.get(i).getKredit() > max){
                max = targyak.get(i).getKredit();
                targy = targyak.get(i).getNev();
            }

        }
        return eredmeny+= targy + ", " + max;
    }

    private int kulombozoTargy() {
        return 7;
    }

    private void ujIDGeneralas(){
    id = UUID.randomUUID();
}



    public List<Tantargy> getTargyak() {
        return new ArrayList<>(targyak);
    }

    @Override
    public String toString() {
        return "Szak{" +
                "targyak=" + targyak +
                ", nev='" + nev + '\'' +
                ", id=" + id +
                '}';
    }


    @Override
    public int compareTo(Szak masik) {
        Collator coll = Collator.getInstance();
        return coll.compare(this.targyak,masik.targyak);
    }

    public static NevComparator rendezTargyNev(){
        return new NevComparator();
    }

    private static class NevComparator implements Comparator<Tantargy> {
        @Override
        public int compare(Tantargy egyik, Tantargy masik) {
            Collator coll = Collator.getInstance();
            return coll.compare(egyik.getNev(),masik.getNev());
        }
    }

    public static KreditComporator rendezKredit(){
        return new KreditComporator();
    }
    private static class KreditComporator implements Comparator<Tantargy> {
        @Override
        public int compare(Tantargy egyik, Tantargy masik) {
            return egyik.getKredit() - masik.getKredit();
        }
    }

}
