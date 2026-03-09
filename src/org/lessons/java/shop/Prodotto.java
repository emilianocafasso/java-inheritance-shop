package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.logging.Handler;

public class Prodotto {

    // incapsulamento, attributi PRIVATE
    private int codice;
    private String nome;
    private String marca;
    private BigDecimal prezzo;
    private BigDecimal iva;

    // costruttore completo
    public Prodotto(String nome, String marca, BigDecimal prezzo, BigDecimal iva) {

        Random random = new Random();
        this.codice = random.nextInt(9000) + 1000;
        this.nome = nome;
        this.marca = marca;
        if (prezzo == null) {
            this.prezzo = BigDecimal.ZERO;
        } else {
            this.prezzo = prezzo;
        }
        if (iva == null) {
            this.iva = new BigDecimal("0.22");
        } else {
            this.iva = iva;
        }
    }

    // metodo prezzo con sconto
    public BigDecimal getPrezzoScontato() {
        BigDecimal sconto = new BigDecimal("0.02");
        BigDecimal prezzoScontato = getPrezzoIvato().subtract(getPrezzoIvato().multiply(sconto));
        return prezzoScontato.setScale(2, RoundingMode.HALF_EVEN);
    }

    // GETTERS e SETTERS

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        if (prezzo.compareTo(BigDecimal.ZERO) >= 0) {
            this.prezzo = prezzo;
        } else {
            System.out.println("Prezzo non valido");
        }
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        if (iva.compareTo(BigDecimal.ZERO) >= 0) {
            this.iva = iva;
        } else {
            System.out.println("IVA non valida");
        }
    }

    public BigDecimal getPrezzoIvato() {
        BigDecimal importoIva = prezzo.multiply(iva);
        return prezzo.add(importoIva).setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getNomeEsteso() {
        return codice + " - " + nome;
    }
}
