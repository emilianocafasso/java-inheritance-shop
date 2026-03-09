package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.NameAlreadyBoundException;

public class Carrello {
    private ArrayList<Prodotto> prodotti;

    public Carrello() {
        this.prodotti = new ArrayList<>();
    }

    public static void main(String[] args) {

        // creo il carrello
        Carrello mioCarrello = new Carrello();

        Scanner scanner = new Scanner(System.in);
        int codiceProdotto = 0;

        do {
            System.out
                    .println(
                            "Che articolo vuoi inserire? 1)Smartphone; 2)Televisore; 3)Cuffie; 0) Termina -\nInserisci codice: ");
            codiceProdotto = scanner.nextInt();
            scanner.nextLine();

            switch (codiceProdotto) {
                case 1: {
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.println("Prezzo: ");
                    BigDecimal prezzo = new BigDecimal(scanner.nextLine());
                    System.out.println("Iva: ");
                    BigDecimal iva = new BigDecimal(scanner.nextLine());
                    System.out.println("IMEI: ");
                    int imei = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Memoria: ");
                    int memoria = scanner.nextInt();
                    scanner.nextLine();

                    // creazione smartphone
                    Smartphone mioSmartphone = new Smartphone(nome, marca, prezzo, iva, imei, memoria);
                    mioCarrello.aggiungiProdotto(mioSmartphone);

                    break;
                }
                case 2: {
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.println("Prezzo: ");
                    BigDecimal prezzo = new BigDecimal(scanner.nextLine());
                    System.out.println("Iva: ");
                    BigDecimal iva = new BigDecimal(scanner.nextLine());
                    System.out.println("Lunghezza: ");
                    float lunghezza = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Larghezza: ");
                    float larghezza = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Spessore: ");
                    float spessore = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("È SmartTv? 0)No ; 1)Si");
                    int isSmartInt = scanner.nextInt();
                    boolean isSmart = isSmartInt == 1;

                    // creazione tv
                    Televisore miaTv = new Televisore(nome, marca, prezzo, iva, lunghezza, larghezza, spessore,
                            isSmart);
                    mioCarrello.aggiungiProdotto(miaTv);

                    break;
                }
                case 3: {
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.println("Prezzo: ");
                    BigDecimal prezzo = new BigDecimal(scanner.nextLine());
                    System.out.println("Iva: ");
                    BigDecimal iva = new BigDecimal(scanner.nextLine());
                    System.out.println("Colore: ");
                    String colore = scanner.nextLine();
                    System.out.println("È Wireless? 0)No ; 1)Si: ");
                    int isWirelessInt = scanner.nextInt();
                    boolean isWireless = isWirelessInt == 1;

                    // creazione cuffie
                    Cuffie mieCuffie = new Cuffie(nome, marca, prezzo, iva, colore, isWireless);
                    mioCarrello.aggiungiProdotto(mieCuffie);

                    break;
                }
                case 0: {
                    System.out.println("Inserimento terminato!\n");
                    break;
                }
                default:
                    System.out.println("Codice inserito non valido");
                    break;
            }
        } while (codiceProdotto != 0);

        System.out.println("\nHai una tessera fedeltà? - 0)No; 1)Si");
        int haiTesseraInt = scanner.nextInt();
        boolean haiTessera = haiTesseraInt == 1;

        // stampa carrello
        System.out.println("\n-- Il TUO CARRELLO --");
        mioCarrello.stampaCarrello();
        System.out.println(String.format("\nTOTALE: %.2f", mioCarrello.calcolaTotale(haiTessera)));
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public void stampaCarrello() {
        for (Prodotto p : prodotti) {
            System.out.println(p);
        }
    }

    public BigDecimal calcolaTotale(boolean haiTessera) {
        BigDecimal totale = BigDecimal.ZERO;

        if (haiTessera) {
            for (Prodotto p : prodotti) {
                totale = totale.add(p.getPrezzoScontato());
            }
        } else {
            for (Prodotto p : prodotti) {
                totale = totale.add(p.getPrezzoIvato());
            }
        }
        return totale;
    }
}
