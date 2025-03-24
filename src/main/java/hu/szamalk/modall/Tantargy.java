package hu.szamalk.modall;

import java.util.Objects;

public class Tantargy {
    private String nev;
    private int kredit,felev;
    private String tanar1,tanar2;
    private boolean feleves;

    public Tantargy() {
    }

    public Tantargy(String sor) {
        String[] adatok = sor.split(";");
        String nev = adatok[0];
        int kredit = Integer.parseInt(adatok[1]);
        String tanar1 = adatok[2];
        String tanar2 = adatok[3];
        int felEv = Integer.parseInt(adatok[4]);
        boolean feleves = Boolean.parseBoolean(adatok[5]);
        this.nev = nev;
        this.kredit = kredit;
        this.tanar1 = tanar1;
        this.tanar2 = tanar2;
        this.felev = felEv;
        this.feleves = feleves;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    public void setFelev(int felev) {
        this.felev = felev;
    }

    public void setTanar1(String tanar1) {
        this.tanar1 = tanar1;
    }

    public void setTanar2(String tanar2) {
        this.tanar2 = tanar2;
    }

    public void setFeleves(boolean feleves) {
        this.feleves = feleves;
    }

    public int getKredit() {
        return kredit;
    }

    public int getFelev() {
        return felev;
    }

    public String getTanar1() {
        return tanar1;
    }

    public String getTanar2() {
        return tanar2;
    }

    public boolean isFeleves() {
        return feleves;
    }

    public String getNev() {
        return nev;
    }

    @Override
    public String toString() {
        return "Tantargy{" +
                "nev='" + nev + '\'' +
                ", kredit=" + kredit +
                ", felev=" + felev +
                ", tanar1='" + tanar1 + '\'' +
                ", tanar2='" + tanar2 + '\'' +
                ", feleves=" + feleves +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tantargy tantargy = (Tantargy) o;
        return kredit == tantargy.kredit && felev == tantargy.felev && Objects.equals(nev, tantargy.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, kredit, felev);
    }

}
