package org.lessons.java.shop;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {

    private int imei;
    private int memoria;

    public Smartphone(String nome, String marca, BigDecimal prezzo, BigDecimal iva, int imei, int memoria) {
        super(nome, marca, prezzo, iva);
        this.imei = imei;
        this.memoria = memoria;
    }

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    @Override
    public String toString() {
        return "\nNome prodotto: " + getNome() + "\nMarca: " + getMarca() + "\nPrezzo: " + getPrezzoIvato()
                + "\nMemoria: "
                + getMemoria() + "\nCodice IMEI: " + getImei();
    }

    // sconto 5% in caso memoria inferiore a 32GB
    @Override
    public BigDecimal getPrezzoScontato() {
        BigDecimal sconto;
        if (memoria < 32) {
            sconto = new BigDecimal("0.05");
            return getPrezzoIvato().subtract(getPrezzoIvato().multiply(sconto));
        } else {
            // altrimenti uso il metoro della classe madre con "super"
            return super.getPrezzoScontato();
        }
    }
}
