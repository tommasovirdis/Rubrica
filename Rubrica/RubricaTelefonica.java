package Rubrica;

import Rubrica.Salvataggio.GestoreSalvataggio;

import java.util.ArrayList;
import java.util.Scanner;

public class RubricaTelefonica {

	// Crea una lista dove inserirà tutti i contatti
	private static ArrayList<Contatto> listaContatti = new ArrayList<>();

	// Crea un file stringa che contiene il mio percorso del file di salvataggio
	private static final String NOME_FILE = "rubrica.dat";

	public static void main(String[] args) {

		// Carica i contatti all'apertura del programma
		caricaContatti();

		// Menu che comprende un while(true) per renderlo infinito
		while (true) {

			// Stampa a video le opzioni del menu
			System.out.println("");// separo per rendere piu chiaro e visibile alla vista
			System.out.println("1. Aggiungi contatto");
			System.out.println("2. Modifica contatto");
			System.out.println("3. Ricerca contatto");
			System.out.println("4. Rimuovi contatto");
			System.out.println("5. Visualizza contatti");
			System.out.println("6. Salva ed Esci");
			System.out.println("");// separo per rendere piu chiaro e visibile alla vista

			// Prende in input l'opzione scelta
			Scanner scanner = new Scanner(System.in);
			int scelta = scanner.nextInt();

			// Switch per le opzioni di scelta
			switch (scelta) {
			case 1:
				aggiungiContatto();
				break;
			case 2:
				modificaContatto();
				break;
			case 3:
				cercaContatto();
				break;
			case 4:
				rimuoviContatto();
				break;
			case 5:
				visualizzaContatti();
				break;
			case 6:
				// Salva i contatti e arresta il programma
				salvaContatti();
				System.exit(0);
				break;
			default:
				// Se la scelta non corrisponde stampa "Scelta non valida, Riprova."
				System.out.println("Scelta non valida, Riprova.");
			}
		}
	}

	private static void aggiungiContatto() {
		Scanner scanner = new Scanner(System.in);

		// Prende in input i dati del contatto da aggiungere
		String cognome = null;
		String nome = null;
		boolean cicloVerificaContatti;
		Contatto controlloNome = null;
		// Do-while per rifar inserire il numero se digitato sbagliato
		do {
			cicloVerificaContatti = false;

			System.out.print("Inserisci il nome del contatto: ");
			nome = scanner.nextLine();
			System.out.print("Inserisci il cognome del contatto: ");
			cognome = scanner.nextLine();

			// Ciclo for per scorrere la lista
			for (int i = 0; i < listaContatti.size(); i++) {
				controlloNome = listaContatti.get(i);

				// Se trova un nome uguale a quello dato in input, non prendendo in
				// considerazione le maiuscole e minuscole, lo fa reinserire
				if (controlloNome.getNome().equalsIgnoreCase(nome)
						&& controlloNome.getCognome().equalsIgnoreCase(cognome)) {
					System.out.println("");
					System.out.println("Il contatto è già esistente");
					cicloVerificaContatti = true;
					i = listaContatti.size();
				}
			}
		} while (cicloVerificaContatti == true);

		String numeroCellulare = null;
		Contatto controlloNumeroCellulare = null;

		// Do-while per rifar inserire il numero se digitato sbagliato
		do {
			cicloVerificaContatti = false;

			System.out.print("Inserisci il numero di cellulare del contatto: ");
			numeroCellulare = scanner.nextLine();

			// Se il numero è composto da 10 cifre allora passi alla prossima verifica
			// altrimenti stampa "Il numero deve essere di 10 cifre. " e reinserisci
			if (numeroCellulare.length() == 10 && numeroCellulare.matches("\\d+")) {

				// Ciclo for per scorrere la lista
				for (int i = 0; i < listaContatti.size(); i++) {
					controlloNumeroCellulare = listaContatti.get(i);

					// Se trova un numero uguale a quello dato in input lo fa reinserire
					if (controlloNumeroCellulare.getNumeroCellulare().equals(numeroCellulare)) {
						System.out.println("");
						System.out.println("Il contatto è già esistente");
						i = listaContatti.size();
						cicloVerificaContatti = true;
					}
				}
			} else {
				System.out.print("Il numero deve essere di 10 cifre. ");
				cicloVerificaContatti = true;
			}
		} while (cicloVerificaContatti == true);

		System.out.print("Inserisci il telefono fisso del contatto: ");
		String telefonoFisso = scanner.nextLine();

		System.out.print("Inserisci l'indirizzo email del contatto: ");
		String indirizzoEmail = scanner.nextLine();

		// Crea il nuovo contatto e lo aggiunge alla lista dei contatti
		Contatto nuovoContatto = new Contatto(cognome, nome, numeroCellulare, telefonoFisso, indirizzoEmail);
		listaContatti.add(nuovoContatto);

		System.out.println("Contatto aggiunto con successo!");
	}

	private static void modificaContatto() {

		Scanner scanner = new Scanner(System.in);

		// Prende in input il nome del contatto da modificare
		System.out.print("Inserisci il cognome del contatto che vuoi modificare: ");
		String cognomeDaModificare = scanner.nextLine();
		System.out.print("Inserisci anche il nome: ");
		String nomeDaModificare = scanner.nextLine();

		Contatto contatto = null;
		// Ciclo for per scorrere la lista
		for (int i = 0; i < listaContatti.size(); i++) {
			contatto = listaContatti.get(i);

			// Se trova un nome uguale a quello dato in input, non prendendo in
			// considerazione le maiuscole e minuscole, lo fa modificare
			if (contatto.getNome().equalsIgnoreCase(nomeDaModificare)
					&& contatto.getCognome().equalsIgnoreCase(cognomeDaModificare)) {

				// Immettere i nuovi dati del contatto
				System.out.print("Nuovo cognome: ");
				contatto.setCognome(scanner.nextLine());

				System.out.print("Nuovo nome: ");
				contatto.setNome(scanner.nextLine());

				System.out.print("Nuovo numero di cellulare: ");
				contatto.setNumeroCellulare(scanner.nextLine());

				System.out.print("Nuovo telefono fisso: ");
				contatto.setTelefonoFisso(scanner.nextLine());

				System.out.print("Nuovo indirizzo email: ");
				contatto.setIndirizzoEmail(scanner.nextLine());

				System.out.println("Contatto modificato con successo!");
				// Esce dal metodo quando trova il contatto corrispondente e dopo averlo
				// modificato
				return;
			}
		}
		// Se la scelta non corrisponde stampa "Contatto non trovato."
		System.out.println("Contatto non trovato.");
	}

	private static void cercaContatto() {
		Scanner scanner = new Scanner(System.in);

		// Prendi in input il nome del contatto da cercare
		System.out.print("Inserisci il nome del contatto che vuoi cercare: ");
		String nomeDaCercare = scanner.nextLine();

		Contatto contatto = null;
		// Ciclo for per scorrere la lista
		for (int i = 0; i < listaContatti.size(); i++) {
			contatto = listaContatti.get(i);

			// Se trova un nome uguale a quello dato in input, non prendendo in
			// considerazione le maiuscole e minuscole, stampa i dati
			if (contatto.getNome().equalsIgnoreCase(nomeDaCercare)) {

				// Stampa le informazioni del contatto
				System.out.println("Contatto trovato:");
				System.out.println("Cognome: " + contatto.getCognome());
				System.out.println("Nome: " + contatto.getNome());
				System.out.println("Numero di cellulare: " + contatto.getNumeroCellulare());
				System.out.println("Telefono fisso: " + contatto.getTelefonoFisso());
				System.out.println("Indirizzo email: " + contatto.getIndirizzoEmail());
				// Esce dal metodo quando trova il contatto corrispondente e dopo averlo
				// stampato
				return;
			}
		}
		// Se la scelta non corrisponde stampa "Contatto non trovato."
		System.out.println("Contatto non trovato.");
	}

	private static void rimuoviContatto() {
		Scanner scanner = new Scanner(System.in);

		// Prende in input il nome del contatto da rimuovere
		System.out.print("Inserisci il cognome del contatto che vuoi rimuovere: ");
		String cognomeDaRimuovere = scanner.nextLine();
		System.out.print("Inserisci il nome del contatto che vuoi rimuovere: ");
		String nomeDaRimuovere = scanner.nextLine();

		// Crea una variabile dove salvare il contatto da rimuovere
		Contatto contattoDaRimuovere = null;
		Contatto contatto = null;

		// Ciclo for per scorrere la lista
		for (int i = 0; i < listaContatti.size(); i++) {
			contatto = listaContatti.get(i);

			// Se trova un nome uguale a quello dato in input, non prendendo in
			// considerazione le maiuscole e minuscole, lo copia nella variabile
			// "contattoDaRimuovere"
			if (contatto.getNome().equalsIgnoreCase(nomeDaRimuovere)
					&& contatto.getCognome().equalsIgnoreCase(cognomeDaRimuovere)) {
				contattoDaRimuovere = contatto;
				// Esce dal for dopo aver trovato il contatto da rimuovere
				break;
			}
		}

		// Se la variabile "contattoDaRimuovere" non è vuota allora rimuoverla dalla
		// lista altrimenti stampa "Contatto non trovato."
		if (contattoDaRimuovere != null) {
			listaContatti.remove(contattoDaRimuovere);
			System.out.println("Contatto rimosso con successo!");
		} else {
			System.out.println("Contatto non trovato.");
		}
	}

	private static void visualizzaContatti() {

		// Controlla se la lista è vuota e stampa "Nessun contatto presente nella
		// rubrica." altrimenti stampa l'elenco dei contatti
		if (listaContatti.isEmpty()) {
			System.out.println("Nessun contatto presente nella rubrica.");
		} else {
			System.out.println("Elenco dei contatti:");
			System.out.println("");
			Contatto contatto = null;
			for (int i = 0; i < listaContatti.size(); i++) {
				contatto = listaContatti.get(i);
				System.out.println("Cognome: " + contatto.getCognome());
				System.out.println("Nome: " + contatto.getNome());
				System.out.println("Numero di cellulare: " + contatto.getNumeroCellulare());
				System.out.println("Telefono fisso: " + contatto.getTelefonoFisso());
				System.out.println("Indirizzo email: " + contatto.getIndirizzoEmail());
				System.out.println("");
				System.out.println("---------------------------");
				System.out.println("");
			}
		}
	}

	private static void caricaContatti() {

		// Carica i contatti dal file altrimenti stampa "Errore durante il caricamento
		// dei contatti: " + un messaggio dell'eccezione che spiega meglio l'errore
		try {
			listaContatti = GestoreSalvataggio.caricaDaFile(NOME_FILE);
		} catch (Exception e) {
			System.err.println("Errore durante il caricamento dei contatti: " + e.getMessage());
		}
	}

	private static void salvaContatti() {
		// Salva i contatti nel file altrimenti stampa "Errore durante il salvataggio
		// dei contatti: " + un messaggio dell'eccezione che spiega meglio l'errore
		try {
			GestoreSalvataggio.salvaSuFile(listaContatti, NOME_FILE);
		} catch (Exception e) {
			System.err.println("Errore durante il salvataggio dei contatti: " + e.getMessage());
		}
	}
}