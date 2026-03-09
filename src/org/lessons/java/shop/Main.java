package org.lessons.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        // creo prodotti
        Smartphone mioSmartphone = new Smartphone("iPhone 17", "Apple", new BigDecimal(1000.00),
                new BigDecimal(0.26), 379013723, 4);
        Televisore miaTv = new Televisore("OLED 4K", "LG", new BigDecimal(1299.00), null, 120, 70, 2.5f, true);
        Cuffie mieCuffie = new Cuffie("AirPods Pro", "Apple", null, null, "Bianco", true);

        System.out.println(mioSmartphone);
        System.out.println(miaTv);
        System.out.println(mieCuffie);
    }
}