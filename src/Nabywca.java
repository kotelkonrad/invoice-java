public class Nabywca {
    String nazwa, ulica, numerpocztowy, miasto, nip;


    Nabywca(String nazwa ,String ulica ,String numerpocztowy,String miasto ,String nip) {
        this.nazwa = nazwa;
        this.ulica = ulica;
        this.numerpocztowy = numerpocztowy;
        this.miasto = miasto;
        this.nip = nip;
    }

    public String toString() {
        return "Nabywca" + "\n" +
                "Nazwa : " + nazwa +
                "\nUlica : " + ulica +
                "\nNumer pocztowy : " + numerpocztowy +
                "\nMiasto : " + miasto +
                "\nNIP : " + nip;
    }
}
