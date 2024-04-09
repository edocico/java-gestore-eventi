package org.experis.gestoreeventi;

import java.time.LocalDate;

public class Evento {

    // attributi

    private String titolo;
    private LocalDate data;
    private final int postiTotali;
    private int postiPrenotati;

    // costruttore


    public Evento(String titolo, CharSequence data, int postiTotali) throws IllegalArgumentException{

        LocalDate parseData = LocalDate.parse(data);
        if (parseData.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere passata");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo");
        }

        this.titolo = titolo;
        this.data = parseData;
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



    // getter


    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    // metodi

    // metodo prenota

    public void prenota(int postiDaPrenotare) throws IllegalArgumentException{
        if(getData().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è già passato");
        }
        if(postiDaPrenotare > getPostiTotali() - getPostiPrenotati()) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili");
        }
        postiPrenotati += postiDaPrenotare;
    }

    // metodo disdici

    public void disdici(int postiDaDisdire) throws IllegalArgumentException{
        if(getData().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è già passato");
        }
        if(postiDaDisdire > getPostiPrenotati()) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti prenotati");
        }
        postiPrenotati -= postiDaDisdire;
    }

    // to string


    @Override
    public String toString() {
        return "Evento{" + "titolo='" + titolo + '\'' + ", data=" + data + ", postiTotali=" + postiTotali + ", postiPrenotati=" + postiPrenotati + '}';
    }
}
