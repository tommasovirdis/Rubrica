// Package rubrica.salvataggio
package Rubrica.Salvataggio;

import Rubrica.Contatto;

import java.io.*;
import java.util.ArrayList;

public class GestoreSalvataggio {
	
    public static void salvaSuFile(ArrayList<Contatto> listaContatti, String nomeFile) throws IOException {
    	
    	//Stampa su file la lista dei contatti grazie alla variabile "variabileTemporanea"
        try (ObjectOutputStream vt = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            vt.writeObject(listaContatti);
        }
    }

    //Toglie i suggerimenti di java
    @SuppressWarnings("unchecked")
    
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