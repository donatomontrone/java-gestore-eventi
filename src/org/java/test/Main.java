package org.java.test;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Scanner;

import org.java.events.Concerto;
import org.java.events.Evento;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		Evento ev = new Evento("La vita è bella", "2023-06-06");

		
		System.out.println("Evento -> " + ev);
		System.out.println("Posti disponibili: " + ev.getPostiDisponibili());
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
		try {
			
			ev.prenota(postiP);
			
		} catch (Exception e) {
			System.err.println("Errore: " + e.getMessage());
		}
		System.out.println("Adesso i posti disponibili sono: " + ev.getPostiDisponibili());
		
		System.out.println("Hai " + ev.getPostiPrenotati() + " posti prenotati");
		int postiD;
		while(true) {
		System.out.print("Quanti posti vuoi disdire? ");
		postiD = in.nextInt();
		
			if (postiD <= 0) {
				System.err.println("Inserire un numero positivo");
				continue;
			}
			break;
		}
		System.out.println("Hai deciso di disdire " + postiD + " posti.");
		try {
			
			ev.disdici(postiP);
			
		} catch (Exception e) {
			System.err.println("Errore: " + e.getMessage());
		}
		System.out.println("Adesso i posti disponibili sono: " + ev.getPostiDisponibili());
		
		in.close();
		
		BigDecimal price = new BigDecimal("10.50");
		LocalTime date = LocalTime.now();
		Concerto c = new Concerto("titolo", "2024-04-20", date, price);
		
		System.out.println(c);
	}
}
