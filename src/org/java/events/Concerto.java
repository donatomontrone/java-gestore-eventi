package org.java.events;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	
	private LocalTime ora;
	private  BigDecimal prezzo;

	public Concerto(String titolo, String data, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data);
		setPrezzo(prezzo);
		setOra(ora);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public String prezzoFormat() {
	    DecimalFormat decimalFormat = new DecimalFormat("##,##0.00€");
	    return decimalFormat.format(getPrezzo());
	}
    public String formatOra() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return getOra().format(formatter);
    }
    
    @Override
    public String toString() {
    	return getData() + " " + formatOra() + " - " + getTitolo() + " - " + prezzoFormat();
    }

}
