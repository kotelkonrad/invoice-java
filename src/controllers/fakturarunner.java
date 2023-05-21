package controllers;

import models.Nabywca;
import models.SplitData;
import models.Sprzedawca;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class fakturarunner {
    public static void faktura(
                               String miejscewystawienia,
                               String datawystawienia,
                               String datasprzedazy,
                               String nazwaSprzedawcy,
                               String ulicaSprzedawcy,
                               String numerpocztowySprzedawcy,
                               String miastoSprzedawcy,
                               String nipSprzedawcy,
                               String nazwaNadawcy,
                               String ulicaNadawcy,
                               String numerpocztowyNadawcy,
                               String miastoNadawcy,
                               String nipNadawcy,
                               String pozycjefaktury) {


        System.out.println("Czy chcesz zapisać do pliku? tak/nie");
        Scanner scanner = new Scanner(System.in);
        double cenbvat = 0.0;
        double warsbvat = 0.0;
        double kwopvat = 0.0;
        double warsvat = 0.0;
        while (true) {
            String pytanie = scanner.nextLine();
            if (pytanie.equalsIgnoreCase("nie")) {

                System.out.println(
                        "Miejsce wystawienia faktury: " + miejscewystawienia + "\n" +
                        "Data wystawienia faktury: " + datawystawienia + "\n" +
                        "Data sprzedaży: " + datasprzedazy + "\n");

                System.out.println(new Sprzedawca(nazwaSprzedawcy,
                        ulicaSprzedawcy,
                        numerpocztowySprzedawcy,
                        miastoSprzedawcy,
                        nipSprzedawcy));
                System.out.println(new Nabywca(nazwaNadawcy, ulicaNadawcy, numerpocztowyNadawcy, miastoNadawcy, nipNadawcy));
                String[] split = pozycjefaktury.split("\\|");
                int i = 1;
                System.out.format("%-10s|%-30s|%-15s|%-5s|%-10s|%-10s|%-5s|%-10s|%-10s%n",
                        "L.p.",
                        "Nazwa tow. lub usłu.",
                        "Jedno. miary",
                        "Ilosc",
                        "Cena jednost. bez VAT",
                        "Wartość sprze. bez VAT",
                        "Procent podatku VAT",
                        "Kwota pod. VAT",
                        "Wartość sprze. z VAT");
                for (String s : split) {
                    String[] ssplit = s.split("/");
                    if (ssplit.length == 5) {
                        SplitData.Result result = SplitData.split(ssplit);
                        System.out.format("%-10d|%-30s|%-15s|%-5s|%-10.2f|%-10.2f|%-5s|%-10.2f|%-10.2f%n",
                                i,
                                result.str1,
                                result.str2,
                                result.str3,
                                result.val1,
                                result.val2,
                                result.str5,
                                result.val3,
                                result.val4
                        );
                        i++;
                        cenbvat += Math.round(result.val1*100)/100D;
                        warsbvat += Math.round(result.val2*100)/100D;
                        kwopvat += Math.round(result.val3*100)/100D;
                        warsvat += Math.round(result.val4*100)/100D;

                    }
                }
                System.out.println("Razem: " + cenbvat + "|" + warsbvat + "|" + kwopvat + "|" + warsvat);
                break;
            } else if (pytanie.equalsIgnoreCase("tak")) {
                String[] split = pozycjefaktury.split("\\|");
                int i = 1;

                PrintWriter writer;
                String fakturanaz;
                System.out.println("Podaj nazwę pliku");
                Scanner fakturanazpli = new Scanner(System.in);
                fakturanaz = fakturanazpli.nextLine(); // poprawka
                File file = new File(fakturanaz + ".txt"); // dodatkowa linia kodu
                try {
                    writer = new PrintWriter(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                writer.println("Miejsce wystawienia faktury: " + miejscewystawienia + "\n" +
                        "Data wystawienia faktury: " + datawystawienia + "\n" +
                        "Data sprzedaży: " + datasprzedazy + "\n");
                writer.println(new Sprzedawca(nazwaSprzedawcy,
                        ulicaSprzedawcy,
                        numerpocztowySprzedawcy,
                        miastoSprzedawcy,
                        nipSprzedawcy));
                writer.println(new Nabywca(nazwaNadawcy,
                        ulicaNadawcy,
                        numerpocztowyNadawcy,
                        miastoNadawcy,
                        nipNadawcy));
                writer.format("%-10s|%-30s|%-15s|%-5s|%-10s|%-10s|%-5s|%-10s|%-10s%n",
                        "L.p.",
                        "Nazwa tow. lub usłu.",
                        "Jedno. miary",
                        "Ilosc",
                        "Cena jednost. bez VAT",
                        "Wartość sprze. bez VAT",
                        "Procent podatku VAT",
                        "Kwota pod. VAT",
                        "Wartość sprze. z VAT");
                for (String s : split) {
                    String[] ssplit = s.split("/");
                    if (ssplit.length == 5) {
                        SplitData.Result result = SplitData.split(ssplit);
                        writer.format("%-10d|%-30s|%-15s|%-5s|%-10.2f|%-10.2f|%-5s|%-10.2f|%-10.2f%n",
                                i,
                                result.str1,
                                result.str2,
                                result.str3,
                                result.val1,
                                result.val2,
                                result.str5,
                                result.val3,
                                result.val4
                        );
                        i++;
                        cenbvat += Math.round(result.val1*100)/100D;
                        warsbvat += Math.round(result.val2*100)/100D;
                        kwopvat += Math.round(result.val3*100)/100D;
                        warsvat += Math.round(result.val4*100)/100D;
                    }
                }
                writer.println("Razem: " + cenbvat + "|" + warsbvat + "|" + kwopvat + "|" + warsvat);
                writer.close();
                System.out.println("Plik został zapisany jako " + fakturanaz + ".txt");
                break;
            } else {
                System.out.println("Nie napisałeś tak czy nie, jeśli chcesz kontynuować napisz tak, jeśli chcesz odnowa uruchomić program napisz nie lub cokolwiek");
                if (!(scanner.next().equalsIgnoreCase("tak"))) {
                    break;
                }
            }
        }
    }
}
