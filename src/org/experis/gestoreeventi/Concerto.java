package org.experis.gestoreeventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{

    // attributi

    private LocalTime ora;
    private BigDecimal prezzo;

    // costruttore

    public Concerto(String titolo, CharSequence data, int postiTotali, CharSequence ora, double prezzo) throws IllegalArgumentException {
        super(titolo, data, postiTotali);
        LocalTime parseOra = LocalTime.parse(ora);
        if (getData().equals(LocalDate.now()) && parseOra.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("l'orario non può essere passato");
        }
        if (BigDecimal.valueOf(prezzo).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("il prezzo non può essere minore di 0");
        }

        this.ora = parseOra;
        this.prezzo = BigDecimal.valueOf(prezzo);
    }

    // getter


    public LocalTime getOra() {
        return ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    // setter


    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    // metodi

    public String formatOra(LocalTime ora) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(formatter);
    }

    public String formatPrezzo(BigDecimal prezzo) {
        DecimalFormat df = new DecimalFormat("##,##");
        return df.format(prezzo);
    }

    // to string


    @Override
    public String toString() {
        return "Concerto: " + getTitolo() + " " + "data: " + getData() + " " + "ora: " + formatOra(getOra()) + " " +
                "prezzo: " + formatPrezzo(getPrezzo()) + "$";
    }
}
