package org.java.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi(String titolo) {
		setTitolo(titolo);
		eventi = new ArrayList<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public List<Evento> getEventi() {
		return eventi;
	}
	
	public void addEvento(Evento e) {
		getEventi().add(e);
	}
	
	public List<Evento> listaEventi(LocalDate data) {
		List<Evento> eventiData = new ArrayList<>();
		for (Evento evento : getEventi()) {
			LocalDate dataEvento = evento.getData();
			 if (dataEvento.isEqual(data)) {
	                eventiData.add(evento);
	            }
	        }
			
		return eventiData;
		}
	
	public void stampaListaEventi(LocalDate data) {
		    List<Evento> eventiData = listaEventi(data);

	    if (eventiData.isEmpty()) {
	        System.out.println("Nessun evento trovato per la data " + data);
	    } else {
	        System.out.println("Eventi trovati per la data " + data + ":");
	        for (Evento evento : eventiData) {
	            System.out.println("\n" + evento);
	        }
	    }
	}
	
	public int numeroEventi() {
		
		
		return getEventi().size();
	}
	
	public void rimuoviEventi() {
		if (!getEventi().isEmpty()) {
			getEventi().removeAll(getEventi());
		}
	}
	

	public String eventiInProgramma() {
		
		String res = "Titolo del programma: " + getTitolo() + "\n\n";
		
		eventi.sort((e1,e2) -> e1.getData().compareTo(e2.getData()));
		
		
	    for (Evento evento : getEventi()) {
	        res += "#[ " + evento.getData() +  " - " + evento.getTitolo() + "]\n";
	    }
		
		return res;
		
	}



}


