package org.lessons.java.shop;

import java.math.BigDecimal;

public class Televisore extends Prodotto {

    private float lunghezza;
    private float larghezza;
    private float spessore;
    private boolean isSmart;

    public Televisore(String nome, String marca, BigDecimal prezzo, BigDecimal iva, float lunghezza, float larghezza,
            float spessore, boolean isSmart) {

        super(nome, marca, prezzo, iva);
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.spessore = spessore;
    }

    public float getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(float lunghezza) {
        this.lunghezza = lunghezza;
    }

    public float getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(float larghezza) {
        this.larghezza = larghezza;
    }

    public float getSpessore() {
        return spessore;
    }

    public void setSpessore(float spessore) {
        this.spessore = spessore;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }
}
