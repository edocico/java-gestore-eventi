package org.experis.gestoreeventi;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Concerto extends Evento{

    // attributi

    private LocalTime ora;
    private BigDecimal prezzo;

    // costruttore

    public Concerto(String titolo, CharSequence data, int postiTotali) throws IllegalArgumentException {
        super(titolo, data, postiTotali);
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
}
