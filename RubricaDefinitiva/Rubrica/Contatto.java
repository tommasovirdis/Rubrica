/**
 * La classe Contatto rappresenta un contatto telefonico, con attributi come cognome, nome,
 * numero di cellulare, telefono fisso e indirizzo email.
 * Implementa l'interfaccia Serializable per consentire la serializzazione degli oggetti di questa classe.
 */
package Rubrica;

import java.io.Serializable;

public class Contatto implements Serializable {
	
	//Crea le varabili per i dati del contatto
    private String cognome;
    private String nome;
    private String numeroCellulare;
    private String telefonoFisso;
    private String indirizzoEmail;

    /**
     * Costruttore della classe Contatto.
     * @param cognome il cognome del contatto
     * @param nome il nome del contatto
     * @param numeroCellulare il numero di cellulare del contatto
     * @param telefonoFisso il telefono fisso del contatto
     * @param indirizzoEmail l'indirizzo email del contatto
     */
    public Contatto(String cognome, String nome, String numeroCellulare, String telefonoFisso, String indirizzoEmail) {
        this.cognome = cognome;
        this.nome = nome;
        this.numeroCellulare = numeroCellulare;
        this.telefonoFisso = telefonoFisso;
        this.indirizzoEmail = indirizzoEmail;
    }

    /**
     * Restituisce il cognome del contatto.
     * @return il cognome del contatto
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome del contatto.
     * @param cognome il nuovo cognome del contatto
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce il nome del contatto.
     * @return il nome del contatto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del contatto.
     * @param nome il nuovo nome del contatto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il numero di cellulare del contatto.
     * @return il numero di cellulare del contatto
     */
    public String getNumeroCellulare() {
        return numeroCellulare;
    }

    /**
     * Imposta il numero di cellulare del contatto.
     * @param numeroCellulare il nuovo numero di cellulare del contatto
     */
    public void setNumeroCellulare(String numeroCellulare) {
        this.numeroCellulare = numeroCellulare;
    }

    /**
     * Restituisce il telefono fisso del contatto.
     * @return il telefono fisso del contatto
     */
    public String getTelefonoFisso() {
        return telefonoFisso;
    }

    /**
     * Imposta il telefono fisso del contatto.
     * @param telefonoFisso il nuovo telefono fisso del contatto
     */
    public void setTelefonoFisso(String telefonoFisso) {
        this.telefonoFisso = telefonoFisso;
    }

    /**
     * Restituisce l'indirizzo email del contatto.
     * @return l'indirizzo email del contatto
     */
    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }

    /**
     * Imposta l'indirizzo email del contatto.
     * @param indirizzoEmail il nuovo indirizzo email del contatto
     */
    public void setIndirizzoEmail(String indirizzoEmail) {
        this.indirizzoEmail = indirizzoEmail;
    }
}
