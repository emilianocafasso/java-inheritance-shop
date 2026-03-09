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
        this.isSmart = isSmart;
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

    public String getDimensioni() {
        return getLunghezza() + " x " + getLarghezza() + " x " + getSpessore();
    }

    @Override
    public String toString() {

        String smartOutput;
        if (this.isSmart) {
            smartOutput = "SI";
        } else {
            smartOutput = "NO";
        }

        return "\nNome prodotto: " + getNome() + "\nMarca: " + getMarca() + "\nPrezzo: " + getPrezzoIvato()
                + "\nDimensioni: "
                + getDimensioni() + " cm\nFunzionalità Smart: " + smartOutput;
    }

    @Override
    public BigDecimal getPrezzoScontato() {
        if (!isSmart) {
            BigDecimal sconto = new BigDecimal("0.1");
            return getPrezzoIvato().subtract(getPrezzoIvato().multiply(sconto));
        } else {
            // altrimenti uso il metoro della classe madre con "super"
            return super.getPrezzoScontato();
        }
    }
}
