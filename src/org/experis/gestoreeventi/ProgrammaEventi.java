package org.experis.gestoreeventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    // attributi
    private String title;
    private List<Evento> eventi;

    // costruttore


    public ProgrammaEventi(String title) {
        this.title = title;
        this.eventi = new ArrayList<>();
    }

    // getter


    public String getTitle() {
        return title;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    // metodi

    // metodo aggiungi evento
    public void addEvento(Evento evento) {
        this.eventi.add(evento);
    }

    // metodo eventi in una data
    public List<Evento> getEventiInData(LocalDate data) {
        List<Evento> eventiInData = new ArrayList<>();
        for (Evento evento : eventi) {
            if (evento.getData().equals(data)) {
                eventiInData.add(evento);
            }
        }
        return eventiInData;
    }

    // metodo conta eventi presenti

    public int countEventi() {
        int counter = 0;
        for (Evento evento : eventi) {
            counter++;
        }
        return counter;
    }


    // metodo che rimuove tutti gli eventi

    public void remove() {
        this.eventi.clear();
    }

    //metodo che stampa stringa





}
