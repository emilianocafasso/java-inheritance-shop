package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        // creo prodotti
        Smartphone mioSmartphone = new Smartphone("iPhone 17", "Apple", new BigDecimal(1000.00),
                new BigDecimal(0.26), 379013723, 4);
        Televisore miaTv = new Televisore("OLED 4K", "LG", new BigDecimal(1299.99), null, 120, 70, 2.5f, true);
        Cuffie mieCuffie = new Cuffie("AirPods Pro", "Apple", null, null, "Bianco", true);

        // test ereditarietà

        // smartphone
        System.out.println("\n--Dettagli Smartphone--");
        System.out.println("Prodotto: " + mioSmartphone.getNome() + ", marca: " + mioSmartphone.getMarca());
        System.out.println("Codice articolo: " + mioSmartphone.getCodice());
        System.out.println("Memoria: " + mioSmartphone.getMemoria() + "GB");
        System.out.println("Prezzo: " + mioSmartphone.getPrezzoIvato() + " euro");

        // tv
        System.out.println("\n--Dettagli TV--");
        System.out.println("Prodotto: " + miaTv.getNome() + ", marca: " + miaTv.getMarca());
        System.out.println("Codice articolo: " + miaTv.getCodice());
        System.out.println(
                "Dimensioni: " + miaTv.getLunghezza() + " x " + miaTv.getLarghezza() + " x " + miaTv.getSpessore()
                        + " cm");
        if (miaTv.isSmart()) {
            System.out.println("Funzionalità SMART: SI");
        } else {
            System.out.println("Funzionalità SMART: NO");
        }
        System.out.println("Prezzo: " + miaTv.getPrezzoIvato() + " euro");

        // cuffie
        System.out.println("\n--Dettagli Cuffie--");
        System.out.println("Prodotto: " + mieCuffie.getNome() + ", marca: " + mieCuffie.getMarca());
        System.out.println("Codice articolo: " + mieCuffie.getCodice());
        System.out.println("Colore: " + mieCuffie.getColore());
        if (mieCuffie.isWireless()) {
            System.out.println("Connettività: Wireless");
        } else {
            System.out.println("Connettività: Cablato");
        }
        System.out.println("Prezzo: " + mieCuffie.getPrezzoIvato() + " euro");
    }
}