/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pwo.projekt.cli;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

/**
 *
 * @author elizakoziol8
 */
public class ProjektCli {
    
    
    public static void main(String[] args) throws IOException {
        //pobranie liczby plikow
        int filesAmount = DataPreparation.getAmountOfFiles();
        //utworzenie naglowka
        String[] headline = DataPreparation.createHeadline();
        //tablica na dane z plikow
        try {
            Object[][] filesData = DataPreparation.createDataTable(filesAmount);
            DataDisplay.printHeadline(headline);        
            DataDisplay.printFilesData(filesAmount, filesData);
        } catch (NoSuchFileException e) {
            System.out.println("Blad!!!! Podano nieistniejaca sciezke do pliku");
        }
        
                
                
    }
}
