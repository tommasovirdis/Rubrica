package rubrica;



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Rubrica {
	public static String[] rubricaNomi = new String[80];
	public static int seriale = 0;

	public boolean inserisciNome() {
		boolean result = false;
		boolean esito;
		int s;
		String scelta;
		String[] line;
		String nomeCognome = " ";
		Scanner scanner = new Scanner(System.in);
		String indirizzo;
		do {
			System.out.println("Inserisci nome e cognome del contatto numero " + (seriale + 1));

			nomeCognome = scanner.nextLine();

			line = nomeCognome.split(" ");

			if (line.length > 1) {
				rubricaNomi[seriale] = line[1] + ", " + line[0];
				Contatto contatto = new Contatto(line[1], line[0], generaNumeroCellulare());
				System.out.println(rubricaNomi[seriale]);
				System.out.println(contatto.toString());
				seriale++;
				esito=true;
			} else {
				return false;
			}

			System.out.println("Vuoi aggiungere altre informazioni? ");
			scelta = scanner.nextLine();

			if (scelta.equals("si")) {
				// ciclo per aggiungere le informazioni secondarie
				while (!result) {
					System.out.println("Premi 1 per inserire indirizzo, 2 per inserire email, 3 per inserire il CAP");
					s = scanner.nextInt();
					scanner.nextLine();

					switch (s) {
					case 1:
						System.out.println("Inserimento indirizzo");
						
						break;

					case 2:
						System.out.println("Inserimento email");
						break;

					case 3:
						System.out.println("Inserimento CAP");
						break;
					}
					System.out.println("Aggiungere altro?");
					scelta = scanner.nextLine();
					if (scelta.equals("si")) {
						result = false;
					} else if (scelta.equals("no")) {
						result = true;
					}
				}
			}

		} while (!nomeCognome.equals("fine"));

		scanner.close();
	}

	public static int generaNumeroCellulare() {
		Random rand = new Random();

		int numero = 1 + rand.nextInt(9);
		for (int i = 1; i < 10; i++) {
			numero = numero * 10 + rand.nextInt(10);
		}

		return numero;
	}

	public String toString() {
		return "Rubrica: " + Arrays.toString(rubricaNomi);
	}

	public static void main(String[] args) {
		Rubrica name = new Rubrica();
		name.inserisciNome();
		System.out.println(name.toString());
	}
}
