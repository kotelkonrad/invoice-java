package controllers;

import interfaces.BasicInterface;

import java.util.Scanner;

public class faktura implements BasicInterface {

    public void run() {
        System.out.println(HELLO);
        Scanner scanner = new Scanner(System.in);
        StringBuilder komenda = new StringBuilder();
        System.out.println("Podaj miejsce wystawienia faktury:");
        komenda.append(scanner.nextLine());
        System.out.println("Podaj datę wystawienia faktury:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj datę sprzedaży:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj jak nazywa się sprzedawca:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj ulicę sprzedawcy:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj kod pocztowy sprzedawcy:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj miasto sprzedawcy:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj NIP sprzedawcy:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj jak nazywa się nadawca:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj ulicę nadawcy:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj kod pocztowy nadawcy:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj miasto nabywcy:");
        komenda.append(";").append(scanner.nextLine());
        System.out.println("Podaj NIP nadawcy:");
        komenda.append(";").append(scanner.nextLine()).append(";");
        System.out.println("Podaj pozycje według wzoru: \nNazwaTowaruLubUsługi;Miara;Ilość;Cena;ProcentVAT \nNapisz koniec żeby zakończyć podawanie pozycji:");
        boolean first = true;
        while (true) {
            String pozycja = scanner.nextLine();
            if (pozycja.equalsIgnoreCase("koniec")) {
                break;
            } else {
                if (!first) {
                    komenda.append("|");
                } else {
                    first = false;
                }
                komenda.append(pozycja.replace(';', '/'));
            }
        }
        String[] split = komenda.toString().split(";");
        System.out.println("Robię fakturę na podstawie danych");
        fakturarunner.faktura(
                split[0],
                split[1],
                split[2],
                split[3],
                split[4],
                split[5],
                split[6],
                split[7],
                split[8],
                split[9],
                split[10],
                split[11],
                split[12],
                split[13]
        );
    }
}
