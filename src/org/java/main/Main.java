package org.java.main;

import java.util.Scanner;

import org.java.events.Evento;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		Evento e = new Evento("La vita è bella", "2023-06-06");

		
		System.out.println("Evento -> " + e);
		System.out.println("Posti disponibili: " + e.getPostiDisponibili());
		System.out.print("Quanti posti vuoi prenotare? ");
		
		int postiP = in.nextInt();
		
		System.out.println("Hai deciso di prenotare " + postiP + " posti.");
		e.prenota(postiP);
		System.out.println("Adesso i posti disponibili sono: " + e.getPostiDisponibili());
		
		System.err.println(e.getPostiTotali());
		
		System.out.println("Hai " + e.getPostiPrenotati() + " posti prenotati");
		System.out.print("Quanti posti vuoi disdire? ");
		
		int postiD = in.nextInt();
		
		System.out.println("Hai deciso di disdire " + postiD + " posti.");
		e.disdici(postiD);
		System.out.println("Adesso i posti disponibili sono: " + e.getPostiDisponibili());
		
		in.close();
	}
}
