import java.util.Scanner;

public class kalkulator {

    public static void main(String[] args) {
        double liczba1;
        double liczba2;
        System.out.println("Oto program kalkulator.");
        System.out.println("Wprowadź jeżeli chcesz coś obliczyć w formacie: operacja;liczba;liczba");
        System.out.println("Jeżeli chcesz zakończyć program, wpisz: koniec");


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();

            if (command.equals("koniec")) {
                break;
            }

            String[] split = command.split(";");
            String operation = split[0];
            try {
                liczba1 = Double.parseDouble(split[1]);
                liczba2 = Double.parseDouble(split[2]);
                if (operation.equals("dodaj")) {
                    kalkulatordwa.dodaj(liczba1, liczba2);
                } else if (operation.equals("odejmij")) {
                    kalkulatordwa.odejmij(liczba1, liczba2);
                } else if (operation.equals("pomnoz")) {
                    kalkulatordwa.pomnoz(liczba1, liczba2);
                } else if (operation.equals("podziel")) {
                    kalkulatordwa.podziel(liczba1, liczba2);
                } else {
                    System.out.println("Zła operacja");
                }

            } catch (NumberFormatException e) {
                if (!(operation.equals("dodaj") || operation.equals("odejmij") || operation.equals("pomnoz") || operation.equals("podziel"))) {
                    System.out.println("Zła operacja");
                }
                System.out.println("Nie można tego zrobić");

            }
        }
    }
}
