package models;

public class Nabywca extends BasicData{


    public Nabywca(String nazwa ,String ulica ,String numerpocztowy,String miasto ,String nip) {
        this.nazwa = nazwa;
        this.ulica = ulica;
        this.numerpocztowy = numerpocztowy;
        this.miasto = miasto;
        this.nip = nip;
    }

    public String toString() {
        return "models.Nabywca" + "\n" +
                "Nazwa : " + this.nazwa +
                "\nUlica : " + this.ulica +
                "\nNumer pocztowy : " + this.numerpocztowy +
                "\nMiasto : " + this.miasto +
                "\nNIP : " + this.nip;
    }
}
