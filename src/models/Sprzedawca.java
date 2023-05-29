package models;

public class Sprzedawca extends BasicData {


    public Sprzedawca(String nazwa, String ulica, String numerpocztowy, String miasto, String nip) {
        this.nazwa = nazwa;
        this.ulica = ulica;
        this.numerpocztowy = numerpocztowy;
        this.miasto = miasto;
        this.nip = nip;
    }

    public String toString() {
        return "Sprzedawca"+"\n" +
                "Nazwa : " + this.nazwa +
                "\nUlica : " + this.ulica +
                "\nNumer pocztowy : " + this.numerpocztowy +
                "\nMiasto : " + this.miasto +
                "\nNIP : " + this.nip;
    }
}
