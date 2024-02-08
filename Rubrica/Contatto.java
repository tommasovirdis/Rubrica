package Rubrica;

import java.io.Serializable;

public class Contatto implements Serializable {
	
	//Crea le varabili per i dati del contatto
    private String cognome;
    private String nome;
    private String numeroCellulare;
    private String telefonoFisso;
    private String indirizzoEmail;

    //Costruttore
    public Contatto(String cognome, String nome, String numeroCellulare, String telefonoFisso, String indirizzoEmail) {
        this.cognome = cognome;
        this.nome = nome;
        this.numeroCellulare = numeroCellulare;
        this.telefonoFisso = telefonoFisso;
        this.indirizzoEmail = indirizzoEmail;
    }

    //Getter e setter per cognome
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    //Getter e setter per nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Getter e setter per numeroCellulare
    public String getNumeroCellulare() {
        return numeroCellulare;
    }
    public void setNumeroCellulare(String numeroCellulare) {
        this.numeroCellulare = numeroCellulare;
    }

    //Getter e setter per telefonoFisso
    public String getTelefonoFisso() {
        return telefonoFisso;
    }
    public void setTelefonoFisso(String telefonoFisso) {
        this.telefonoFisso = telefonoFisso;
    }

    //Getter e setter per indirizzoEmail
    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }
    public void setIndirizzoEmail(String indirizzoEmail) {
        this.indirizzoEmail = indirizzoEmail;
    }
}
