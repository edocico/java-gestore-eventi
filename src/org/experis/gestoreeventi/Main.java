package org.experis.gestoreeventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("inserisci la data dell'evento");
        CharSequence input = scan.nextLine();

        Evento evento = new Evento("concerto u2", input, 10000);
        System.out.println(evento.toString());

         scan.close();
    }
}
