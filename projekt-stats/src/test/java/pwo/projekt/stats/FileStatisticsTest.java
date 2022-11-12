/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pwo.projekt.stats;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author gman
 */
public class FileStatisticsTest {
    
    private FileStatistics fileStats;
    
    @BeforeAll
    public void testCreateObject(){
        System.out.println("Utworzenie obiektu sie ");
        try {
            fileStats = new FileStatistics("./testFile");
            System.out.println("udalo");
        } catch (Exception e) {
            assertTrue(false);
            System.out.println("nie udalo");
            System.out.println(e);
        }
        assertTrue(true);
    }

    @Test
    public void testGetNumOfLines() {
         System.out.println("Liczba linii w pliku: " + fileStats.getNumOfLines());
        assertEquals(fileStats.getNumOfLines(), 12);
    }
    
    @Test
    public void testGetNumOfWords() {
        System.out.println("Liczba slow w pliku: " + fileStats.getNumOfWords());
        assertEquals(fileStats.getNumOfWords(), 21);
    }
    
    @Test
    public void testGetNumOfChars(){
        System.out.println("Liczba znakow w pliku: " + fileStats.getNumOfChars());
        assertEquals(fileStats.getNumOfChars(), 89);
    }
    
    @Test
    public void testGetNumOfNonWhiteChars() {
        System.out.println("Liczba niebialych znakow w pliku: " + fileStats.getNumOfNonWhiteChars());
        assertEquals(fileStats.getNumOfNonWhiteChars(), 80);
    }
    
    @Test
    public void testGetNumOfAsciiChars() {
        System.out.println("Liczba znakow ASCII w pliku: " + fileStats.getNumOfAsciiChars());
        assertEquals(fileStats.getNumOfAsciiChars(), 50);
    }
    
    @Test
    public void testGetNumOfNonAsciiChars(){
        System.out.println("Liczba znakow nie bedacych ASCII w pliku: " + fileStats.getNumOfNonAsciiChars());
        assertEquals(fileStats.getNumOfNonAsciiChars(), 39);
    }
    
    @Test
    public void testGetNumOfPolishChars(){
        System.out.println("Liczba polskich znakow w poliku: " + fileStats.getNumOfPolishChars());
        assertEquals(fileStats.getNumOfPolishChars(), 24);
    }
    
    @Test
    public void testGetAvgWordLength() {
        System.out.println("Srednia dlugosc slowa w pliku: " + fileStats.getAvgWordLength());
        assertEquals(fileStats.getAvgWordLength(), (double) 21/80);
    }
    
    @Test
    public void testGetAvgWordsInLine() {
        System.out.println("Srednia liczba slow w linii w pliku: " + fileStats.getAvgWordsInLine());
        assertEquals(fileStats.getAvgWordsInLine(), (double)21/12);
    }
    
    @Test
    public void testGetAvgCharsInLine() {
        System.out.println("Srednia liczba znakow w linii w pliku: " + fileStats.getAvgCharsInLine());
        assertEquals(fileStats.getAvgCharsInLine(), (double)89/12);
    }
    
    @Test
    public void testGetCharsStats() {
        System.out.println("Statystyki dotyczace wystapienia poszczegolnych znakow w pliku:");
        System.out.println(fileStats.getCharsStats());
    }
    
    @Test
    public void testGetUniqueCharacters(){
        System.out.println("Lista unikalnych znakow, ktore wystapily w pliku:");
        System.out.println(fileStats.getUniqueCharacters());
    }
    
    @Test
    public void testGetMostFrequentCharacter(){
        System.out.println("Najczesciej wystepujacy znak w pliku: " + fileStats.getMostFrequentCharacter());
    }
    
    @Test
    public void testGetLeastFrequentCharacter(){
        System.out.println("Najrzadziej wystepujacy znak w pliku: " + fileStats.getLeastFrequentCharacter());
    }
}
