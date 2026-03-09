package org.lessons.java.shop;

import java.math.BigDecimal;

public class Cuffie extends Prodotto {

    private String colore;
    private boolean isWireless;

    public Cuffie(String nome, String marca, BigDecimal prezzo, BigDecimal iva, String colore, boolean isWireless) {
        super(nome, marca, prezzo, iva);
        this.colore = colore;
        this.isWireless = isWireless;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    @Override
    public String toString() {
        String wirelessOutput;
        if (this.isWireless()) {
            wirelessOutput = "Wireless";
        } else {
            wirelessOutput = "Cablato";
        }

        return "\nNome prodotto: " + getNome() + "\nMarca: " + getMarca() + "\nPrezzo: " + getPrezzoIvato()
                + "\nColore: "
                + getColore()
                + "\nConnettività: " + wirelessOutput;
    }

    @Override
    public BigDecimal getPrezzoScontato() {
        if (!isWireless) {
            BigDecimal sconto = new BigDecimal("0.07");
            return getPrezzoIvato().subtract(getPrezzoIvato().multiply(sconto));
        } else {
            // altrimenti uso il metoro della classe madre con "super"
            return super.getPrezzoScontato();
        }
    }
}
