package org.java.events;

import java.time.LocalDate;
import java.util.Random;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	public Evento(String titolo, String data) throws Exception {
		setTitolo(titolo);
		setData(data);
		setPostiTotali();
		setPostiPrenotati(0);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(String data) throws Exception {
		LocalDate today = LocalDate.now();
		LocalDate dataE = LocalDate.parse(data);
		boolean isBefore = today.isBefore(dataE);
		if (!isBefore) {
			throw new Exception("La data è antecedente alla data odierna");
		}
		
		this.data = dataE;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	private void setPostiTotali() {
		Random rnd = new Random();
		postiTotali = rnd.nextInt(1,101);
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	private void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}
	
	private void pastDate() throws Exception {
		LocalDate dataEvento = getData();
		if (dataEvento.isBefore(LocalDate.now())) {
			throw new Exception("L'evento è già terminato!");
		}
	}
	
	public int getPostiDisponibili() {
		int disponibili = getPostiTotali() - getPostiPrenotati();
		return disponibili;
	}
	
	public int prenota(int posti) throws Exception {
		pastDate();
		if (getPostiPrenotati() > getPostiTotali()) {
			throw new Exception("Numero di posti prenotabili raggiunto");
		}
		
		
		return postiPrenotati += posti;
	}
	
	public int disdici(int posti) throws Exception {
		pastDate();
		if (getPostiPrenotati() <= 0) {
			throw new Exception("Non hai nessun posto prenotato!");
		} else if (posti > getPostiPrenotati()) {
			throw new Exception("Vuoi disdire più posti di quelli prenotati!");
		}
		return postiPrenotati -= posti;
	}
	
	
	@Override
	public String toString() {
		return getTitolo() + " - " + getData();
	}
	
	
}
