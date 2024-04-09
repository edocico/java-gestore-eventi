package org.experis.gestoreeventi;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
            String capienzaEvento = null;
            try {
                capienzaEvento = scan.nextLine();
            } catch (Exception e) {
                throw new NumberFormatException("deve essere un numero");
            }
            int parseCapienza = Integer.parseInt(capienzaEvento);
            try {
                evento = new Evento(nomeEvento, dataEvento,parseCapienza);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("La data inserita non è valida. Assicurati di inserirla nel formato corretto (YYYY-MM-DD)");
            }
        }

        String comando = "";

        while (!comando.equalsIgnoreCase("no")) {
            System.out.println("vuoi prenotare dei posti per l'evento? si/no");
            comando = scan.nextLine();
            if (comando.equalsIgnoreCase("si")) {
                System.out.println("quanti posti vuoi prenotare?");
                String answer = "";


                    try {
                        try {
                            answer = scan.nextLine();
                        } catch (Exception e) {
                            throw new NumberFormatException("deve essere un numero");
                        }
                        int parseAnswer = Integer.parseInt(answer);
                        int absAnw = Math.abs(parseAnswer);
                        evento.prenota(absAnw);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("sono ancora disponibili: " + evento.postiDisponibili() + " posti");
                        System.out.println("quanti posti vuoi prenotare?");
                    }

                System.out.println("Ci sono prenotati: " + evento.getPostiPrenotati() + " " + "posti");
                System.out.println("sono ancora disponibili: " + evento.postiDisponibili() + " posti");
            }
        }

        System.out.println("Ci sono prenotati: " + evento.getPostiPrenotati() + " " + "posti");
        System.out.println("sono ancora disponibili: " + evento.postiDisponibili() + " posti");


        if (evento.getPostiPrenotati() > 0) {
            String choise = "";
            while (!choise.equalsIgnoreCase("no")) {
                System.out.println("vuoi disdire dei posti ? si/no");
                choise = scan.nextLine();
                if (choise.equalsIgnoreCase("si")) {
                    try {
                        System.out.println("Quanti posti vuoi disdire?");
                        String posti = null;
                        try {
                            posti = scan.nextLine();
                        } catch (Exception e) {
                            throw new NumberFormatException("deve essere un numero");
                        }
                        int parsePosti = Integer.parseInt(posti);
                        int absPosti = Math.abs(parsePosti);
                        evento.disdici(absPosti);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Ci sono prenotati: " + evento.getPostiPrenotati() + " " + "posti");


                }
            }
            System.out.println("Ci sono prenotati: " + evento.getPostiPrenotati() + " " + "posti");
            System.out.println("sono ancora disponibili: " + evento.postiDisponibili() + " posti");

        }

        scan.close();

    }

}

