package org.experis.gestoreeventi;

import java.time.LocalDate;

public class Evento {

    // attributi

    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    // costruttore


    public Evento(String titolo, LocalDate data, int postiTotali) throws IllegalArgumentException{

        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere passata");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo");
        }
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    // setter


    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setPostiTotali(int postiTotali) {
        this.postiTotali = postiTotali;
    }

    public void setPostiPrenotati(int postiPrenotati) {
        this.postiPrenotati = postiPrenotati;
    }

    // getter


    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }
}
