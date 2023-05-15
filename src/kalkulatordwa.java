public class kalkulatordwa {
    private static double wynik;
    public static void dodaj(double liczba1, double liczba2) {
        wynik = liczba1 + liczba2;
        System.out.println("Wynik dodawania liczby "+liczba1+" i liczby "+liczba2+" wynosi:"+wynik);
    }
    public static void odejmij(double liczba1, double liczba2) {
        wynik = liczba1 - liczba2;
        System.out.println("Wynik odejmowania liczby "+liczba1+" i liczby "+liczba2+" wynosi:"+wynik);
    }
    public static void pomnoz(double liczba1, double liczba2) {
        wynik = liczba1 * liczba2;
        System.out.println("Wynik mnożenia liczby "+liczba1+" i liczby "+liczba2+" wynosi:"+wynik);
    }
    public static void podziel(double liczba1, double liczba2) {
        wynik = liczba1 / liczba2;
        System.out.println("Wynik dzielenia liczby "+liczba1+" i liczby "+liczba2+" wynosi:"+wynik);
    }

}
