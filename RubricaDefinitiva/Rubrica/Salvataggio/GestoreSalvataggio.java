/**
 * La classe GestoreSalvataggio fornisce metodi statici per salvare e caricare la lista dei contatti su e da un file.
 * Implementa la funzionalità di serializzazione per consentire il salvataggio degli oggetti ArrayList<Contatto>.
 */
package Rubrica.Salvataggio;

import Rubrica.Contatto;
import java.io.*;
import java.util.ArrayList;

public class GestoreSalvataggio {
	
    /**
     * Salva la lista dei contatti su un file.
     * @param listaContatti la lista dei contatti da salvare
     * @param nomeFile il nome del file su cui salvare la lista dei contatti
     * @throws IOException se si verifica un errore durante l'operazione di salvataggio
     */
    public static void salvaSuFile(ArrayList<Contatto> listaContatti, String nomeFile) throws IOException {
    	
    	//Stampa su file la lista dei contatti grazie alla variabile "variabileTemporanea"
        try (ObjectOutputStream vt = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            vt.writeObject(listaContatti);
        }
    }

    /**
     * Carica la lista dei contatti da un file.
     * @param nomeFile il nome del file da cui caricare la lista dei contatti
     * @return la lista dei contatti caricata dal file
     * @throws IOException se si verifica un errore durante l'operazione di caricamento
     */
    
    public static ArrayList<Contatto> caricaDaFile(String nomeFile) throws IOException, ClassNotFoundException {
    	
    	//Crea la variabile "file" inserendoci il percorso del nostro file salvataggio 
        File file = new File(nomeFile);
        
        //Se il file per il salvataggio non esiste lo crea
        if (!file.exists()) {
            file.createNewFile();
        }
        
            //Salva su file la lista dei contatti grazie alla variabile "variabileTemporanea"
            try (ObjectInputStream vt = new ObjectInputStream(new FileInputStream(file))) {
                return (ArrayList<Contatto>) vt.readObject();
            }
    }
}