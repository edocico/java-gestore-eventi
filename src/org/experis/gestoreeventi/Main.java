package org.experis.gestoreeventi;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Evento evento = null;

        while (evento == null) {
            System.out.println("crea un nuovo evento... inizia dal nome");
            String nomeEvento = scan.nextLine();
            System.out.println("ora inserisci la data in cui si terrà l'evento in formato YYYY-MM-DD");
            String dataEvento = scan.nextLine();
            System.out.println("quale capienza ha il posto dove si terrà l'evento?");
            String capienzaEvento = scan.nextLine();
            int parseCapienza = Integer.parseInt(capienzaEvento);
            try {
                evento = new Evento(nomeEvento, dataEvento,parseCapienza);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("quanti posti vuoi prenotare?");
        String answer = "";

        while (evento.getPostiPrenotati() == 0) {
            try {
                answer = scan.nextLine();
                int parseAnswer = Integer.parseInt(answer);
                evento.prenota(parseAnswer);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Ci sono prenotati: " + evento.getPostiPrenotati() + " " + "posti");
        System.out.println("sono ancora disponibili: " + evento.postiDisponibili() + " posti");


        System.out.println("vuoi disdire dei posti ? Y/N");
        String choise = scan.nextLine();
        String choiseClean = choise.trim();
        switch (choiseClean) {
            case "Y":
                System.out.println("Quanti posti vuoi disdire?");
                String posti = scan.nextLine();
                int parsePosti = Integer.parseInt(posti);
                evento.disdici(parsePosti);
                break;
            case "N":
                System.out.println("Grazie e arrivederci");
                break;
            default:
                break;
        }

        System.out.println("Ci sono prenotati: " + evento.getPostiPrenotati() + " " + "posti");
        System.out.println("sono ancora disponibili: " + evento.postiDisponibili() + " posti");

        scan.close();

    }

}

