/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pwo.projekt.cli;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pwo.projekt.stats.FileMetadata;
import pwo.projekt.stats.FileStatistics;

/**
 *
 * @author gman
 */
public class ProjektCli {
    
    


    public static void main(String[] args) throws IOException {
        //pobranie liczby plikow
        int filesAmount = getAmountOfFiles();
        //tablica na dane z plikow 
        Object[][] filesData = new Object[filesAmount][21]; 
        String path;
        //przypisanie sciezki do pliku jako pierwszy argument
        for (int i=0; i<filesAmount;i++) {
            path = getPathOfFile(i+1, filesAmount);
            FileMetadata metadata = new FileMetadata(path);
            filesData[i][0] = path;
            filesData[i][1] = metadata.getCreationTime();
            filesData[i][2] = metadata.getLastAccessTime();
            filesData[i][3] = metadata.getLastModificationTime();
            filesData[i][4] = metadata.getFileType();
            filesData[i][5] = metadata.getFileSize();
            filesData[i][6] = metadata.getOwner();
            FileStatistics stats = new FileStatistics(path);
            filesData[i][7] = stats.getNumOfLines();
            filesData[i][8] = stats.getNumOfWords();
            filesData[i][9] = stats.getNumOfChars();
            filesData[i][9] = stats.getNumOfNonWhiteChars();
            filesData[i][10] = stats.getNumOfAsciiChars();
            filesData[i][11] = stats.getNumOfNonAsciiChars();
            filesData[i][12] = stats.getNumOfPolishChars();
            filesData[i][13] = stats.percentageOfPolishChars();
            filesData[i][14] = stats.getAvgWordLength();
            filesData[i][15] = stats.getAvgWordsInLine();
            filesData[i][16] = stats.getAvgCharsInLine();
            filesData[i][17] = stats.getMostFrequentCharacter();
            filesData[i][18] = stats.getLeastFrequentCharacter();
            filesData[i][19] = stats.getCharsStats();
//            filesData[i][20] = stats.getUniqueCharacters();
        }        
        
        
        for (int x=0; x<filesAmount;x++) {
            for (int y=0; y<20;y++) {
                System.out.print(filesData[x][y] + "\t\t");
            }
                System.out.println("");
        }
        
        
        
        System.out.println("Unikalne znaki dla plikow: ");
        for (int x=0; x<filesAmount;x++) {
            System.out.print(filesData[x][0] + "\t\t");

//            System.out.println(filesData[x][20]);
        }

        
        
        
        
        
//        for (int j=0; j<filesAmount;j++) {
//            System.out.println(filesData[j][0]);
//        }

        
    }
    
    
    private static int getAmountOfFiles() throws IOException {
        int filesAmount = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));          
        System.out.println("Podaj ilosc plikow:");
        try {
            filesAmount = Integer.parseInt(reader.readLine());
        } catch(NumberFormatException nfe) {
            System.err.println("Zly format, podaj liczbe");
        }
        return filesAmount;
    }
    
    private static String getPathOfFile(int fileNumber, int filesAmount) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));          
        System.out.println(String.format("(%d/%d) Podaj sciezke pliku:", fileNumber, filesAmount));
        String pathOfFile = reader.readLine();
        return pathOfFile;
    }
}
