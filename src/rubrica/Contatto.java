package rubrica;

import java.util.Random;

public class Contatto {
	private String nome;
	private String cognome;
	private String indirizzo;
	private String email;
	private int cap;
	final static int dim = 10;
	private int numeroCellulare;
	public int nContatto = 0;

	public Contatto(String nome, String cognome, int numeroCellulare) {
		this.nome = nome;
		this.cognome = cognome;
		this.numeroCellulare = numeroCellulare;

		nContatto++;

	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public int getCap() {
		return cap;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int[] getNumeroCellulare() {
		return numeroCellulare;
	}

	@Override
	public String toString() {
		return "Contatto [nome=" + nome + ", cognome=" + cognome + ", numeroCellulare=" + numeroCellulare
				+ ", nContatto=" + nContatto + "]";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

}
