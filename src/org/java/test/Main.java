package org.java.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import org.java.events.Concerto;
import org.java.events.Evento;
import org.java.events.ProgrammEventi;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		Evento ev = new Evento("La vita è bella", "2023-06-06");
		
		System.out.println("Evento -> " + ev);
		System.out.println("Posti disponibili: " + ev.getPostiDisponibili());
		System.out.println("\n-----------------------------------------\n");
		
		int postiP = 0;
		while (true) {
			System.out.println("Quanti posti vuoi prenotare? ");
			postiP = in.nextInt();
			if (postiP <= 0) {
				System.err.println("Inserire un numero positivo");
				continue;
			}
			
			break;
		}
		
		System.out.println("Hai deciso di prenotare " + postiP + " posti.");
		
		System.out.println("\n-----------------------------------------\n");
		
		System.out.println("Prenotazione in corso..");
		
		try {
			
			ev.prenota(postiP);
			
		} catch (Exception e) {
			System.err.println("Errore: " + e.getMessage());
		}
		
		System.out.println("Adesso i posti disponibili sono: " + ev.getPostiDisponibili());
		
		System.out.println("Hai " + ev.getPostiPrenotati() + " posti prenotati.");
		
		System.out.println("\n-----------------------------------------\n");
		
		int postiD;
		while(true) {
		System.out.println("Quanti posti vuoi disdire? ");
		postiD = in.nextInt();
		
			if (postiD <= 0) {
				System.err.println("Inserire un numero positivo");
				continue;
			}
			break;
		}
		System.out.println("Hai deciso di disdire " + postiD + " posti.");
		
		System.out.println("\n-----------------------------------------\n");
		
		System.out.println("Disdetta posti in corso..");
		
		try {
			
			ev.disdici(postiP);
			
		} catch (Exception e) {
			System.err.println("Errore: " + e.getMessage());
		}
		
		System.out.println("Adesso i posti disponibili sono: " + ev.getPostiDisponibili());
		
		in.close();
		
		System.out.println("\n-----------------------------------------");
		System.out.println("-----------------------------------------\n");
		
		System.out.println("Concerto:");
		
		BigDecimal price = new BigDecimal("10.50");
		LocalTime date = LocalTime.now();
		Concerto c = new Concerto("titolo", "2024-04-20", date, price);
		
		System.out.println("\n" + c);
		
		System.out.println("\n-----------------------------------------\n");	
		
		ProgrammEventi pre = new ProgrammEventi("Programma 1");
		
		pre.addEvento(new Evento("Evento 1", "2023-06-06"));
		pre.addEvento(new Evento("Evento 2", "2023-06-06"));
		pre.addEvento(new Evento("Evento 3", "2023-06-06"));
		pre.addEvento(new Evento("Evento 4", "2023-06-06"));
		pre.addEvento(new Evento("Evento 5", "2023-08-06"));
		pre.addEvento(new Evento("Evento 6", "2023-07-06"));
		pre.addEvento(new Evento("Evento 7", "2023-06-06"));
		pre.addEvento(new Evento("Evento 8", "2023-07-06"));
		pre.addEvento(new Evento("Evento 9", "2023-08-06"));
		pre.addEvento(new Evento("Evento 10", "2023-07-06"));
		
		LocalDate data = LocalDate.parse("2023-06-06");
		
		pre.stampaListaEventi(data);
		
		System.out.println("\n-----------------------------------------\n");
		
		System.out.println("Numero eventi in programma: " + pre.numeroEventi());
		
		System.out.println("\n-----------------------------------------\n");
		
		
		System.out.println(pre.eventiInProgramma());
		
		pre.rimuoviEventi();
		
		System.out.println("Sto svuotando la lista degli eventi...");
		System.out.println("\nBene, la lista adesso ha " + pre.numeroEventi() + " eventi in programma.");
	}
}
