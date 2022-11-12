/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.projekt.stats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.List;

/**
 * Klasa obliczajaca statystyki dotyczace pojedynczego pliku
 *
 * @author gman
 */
public class FileStatistics {

    private final List<String> fileContent;
    private int chars;
    private int nonWhiteChars;
    private int words;
    private double avgWordLength;
    private int asciiChars;
    private int nonAsciiChars;
    private int polishChars;
    private double percentageOfPolishChars;
    private final HashMap<Character, Integer> charsStats;

    // TODO: Do zmiany poczatkowy warunek ustawiania na zero, bo moze byc np. 0 polskich znakow
    // TODO: Sprawdzanei rozmiaru pliku > 1GB lub 0 bajtow
    public FileStatistics(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        fileContent = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        words = 0;
        chars = 0;
        nonWhiteChars = 0;
        avgWordLength = 0.0;
        asciiChars = 0;
        nonAsciiChars = 0;
        polishChars = 0;
        percentageOfPolishChars = 0.0;
        charsStats = new HashMap<Character, Integer>();
    }

    /**
     * 
     * @return Liczba linii w pliku
     */
    public int getNumOfLines() {
        return fileContent.size();
    }

    /**
     * 
     * @return Liczba slow w pliku (ciagi znakow odseparowane spacja)
     */
    public int getNumOfWords() {
        if (words > 0) {
            return words;
        }
        for (String line : fileContent) {
            words += line.split("\\s+").length;
        }
        return words;
    }

    /**
     * 
     * @return Liczba wszystkich znakow
     */
    public int getNumOfChars() {
        if (chars > 0) {
            return chars;
        }
        for (String line : fileContent) {
            chars += line.length();
        }
        return chars;
    }

    /**
     * 
     * @return Liczba niebialych znakow w pliku
     */
    public int getNumOfNonWhiteChars() {
        if (nonWhiteChars > 0) {
            return nonWhiteChars;
        }
        for (String line : fileContent) {
            line = line.replaceAll("\\s+", "");
            nonWhiteChars += line.length();
        }
        return nonWhiteChars;
    }

    /**
     * 
     * @return Liczba znakow ASCII w pliku
     */
    public int getNumOfAsciiChars() {
        if (asciiChars > 0) {
            return asciiChars;
        }
        for (String line : fileContent) {
            asciiChars += line.replaceAll("^\\p{ASCII}*$", "").length();
        }
        return asciiChars;
    }

    /**
     * 
     * @return Liczba znakow nienalezacych do ASCII
     */
    public int getNumOfNonAsciiChars() {
        if (nonAsciiChars > 0) {
            return nonAsciiChars;
        }
        if (asciiChars < 1) {
            getNumOfAsciiChars();
        }
        if (chars < 1) {
            getNumOfChars();
        }
        nonAsciiChars = chars - asciiChars;
        return nonAsciiChars;
    }

    /**
     * 
     * @return Liczba polskich znakow
     */
    public int getNumOfPolishChars() {
        if (polishChars > 0) {
            return polishChars;
        }
        for (String line : fileContent) {
            polishChars += line.replaceAll("[ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]", "").length();
        }
        return polishChars;
    }

    /**
     * @see #getNumOfChars() 
     * @see #getNumOfPolishChars() 
     * @return Procent (w stosunku do liczby wszystkich znakow) polskich znakow w pliku 
     */
    public double percentageOfPolishChars() {
        if (percentageOfPolishChars > 0.0) {
            return percentageOfPolishChars;
        }
        percentageOfPolishChars = (double) polishChars / chars;
        return percentageOfPolishChars;
    }

    /**
     * 
     * @return Srednia dlugosc slowa
     */
    public double getAvgWordLength() {
        if (avgWordLength > 0.0) {
            return avgWordLength;
        }
        if (words < 1) {
            getNumOfWords();
        }
        if (nonWhiteChars < 1) {
            getNumOfNonWhiteChars();
        }
        return (double) words / nonWhiteChars;
    }

    /**
     * 
     * @return Liczba wystapien poszczegolnych znakow w pliu
     */
    public HashMap<Character, Integer> getCharsStats() {
        if (!charsStats.isEmpty()) {
            return charsStats;
        }
        for (String line : fileContent) {
            CharacterIterator ci = new StringCharacterIterator(line);
            while (ci.current() != CharacterIterator.DONE) {
                charsStats.merge(ci.current(), 1, (oldValue, newValue) -> oldValue + 1);
                ci.next();
            }
        }
        return charsStats;
    }

    public void printFile() {
        fileContent.forEach(System.out::println);
    }
}
