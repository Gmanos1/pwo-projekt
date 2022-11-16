/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.projekt.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import pwo.projekt.stats.FileMetadata;
import pwo.projekt.stats.FileStatistics;

/**
 *
 * @author elizakoziol8
 */
public class DataPreparation {
    
    
    public static int getAmountOfFiles() throws IOException {
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
    
    public static String[] createHeadline() {
        String[] headlineData = new String[21];
        
        headlineData[0] = "Sciezka do pliku";
        headlineData[1] = "Data utworzenia pliku";
        headlineData[2] = "Data ostatniego dostepu do pliku";
        headlineData[3] = "Data ostatniej modyfikacji do pliku";
        headlineData[4] = "Typ pliku";
        headlineData[5] = "Rozmiar pliku";
        headlineData[6] = "Wlasciciel pliku";
        headlineData[7] = "Liczba linii w pliku";
        headlineData[8] = "Liczba slow w pliku";
        headlineData[9] = "Liczba wszystkich znakow";
        headlineData[10] = "Liczba wszystakich niebialych znakow";
        headlineData[11] = "Liczba znakow ASCII";
        headlineData[12] = "Liczba znakow nienalezacych do ASCII";
        headlineData[13] = "Liczba polskich znakow";
        headlineData[14] = "Procent polskich znakow";
        headlineData[15] = "Srednia dlugosc slowa";
        headlineData[16] = "Srednia liczba slow w linii";
        headlineData[17] = "Srednia liczba znakow w linii";
        headlineData[18] = "Najczesciej wystepujacy znak";
        headlineData[19] = "Najrzadziej wystepujacy znak";
        headlineData[20] = "Liczba wystapien poszczegolnych znakow";
    
        return headlineData;
    }
    
    public static Object[][] createDataTable(int filesAmount) throws IOException {
        Object[][] filesData = new Object[filesAmount][21]; 
        String path;
       
        //utworzenie tablicy z danymi
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
            filesData[i][10] = stats.getNumOfNonWhiteChars();
            filesData[i][11] = stats.getNumOfAsciiChars();
            filesData[i][12] = stats.getNumOfNonAsciiChars();
            filesData[i][13] = stats.getNumOfPolishChars();
            filesData[i][14] = stats.percentageOfPolishChars();
            filesData[i][15] = stats.getAvgWordLength();
            filesData[i][16] = stats.getAvgWordsInLine();
            filesData[i][17] = stats.getAvgCharsInLine();
            filesData[i][18] = stats.getMostFrequentCharacter();
            filesData[i][19] = stats.getLeastFrequentCharacter();
            filesData[i][20] = stats.getCharsStats();
        }
        return filesData;         
    }
    
    public static String getPathOfFile(int fileNumber, int filesAmount) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));          
        System.out.println(String.format("(%d/%d) Podaj sciezke pliku:", fileNumber, filesAmount));
        String pathOfFile = reader.readLine();
        return pathOfFile;
    }
}
