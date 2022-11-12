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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private int asciiChars;
    private int nonAsciiChars;
    private int polishChars;
    private final HashMap<Character, Integer> charsStats;
    private HashSet<Character> uniqueCharacters;

    // TODO: Srednia liczba znakow w linii, srednia liczbba slow w linii, znak najczesciej wystepujacy, najrzadziej
    // TODO: Do zmiany poczatkowy warunek ustawiania na zero, bo moze byc np. 0 polskich znakow
    // TODO: Sprawdzanei rozmiaru pliku > 1GB lub 0 bajtow
    public FileStatistics(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        fileContent = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        words = 0;
        chars = 0;
        nonWhiteChars = 0;
        asciiChars = 0;
        nonAsciiChars = 0;
        polishChars = 0;
        charsStats = new HashMap<Character, Integer>();
        uniqueCharacters = new HashSet<Character>();
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
            nonWhiteChars = line.replaceAll("\\s+", "").length();
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
            asciiChars += line.length() - line.replaceAll("^\\p{ASCII}*$", "").length();
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
            polishChars += line.length() - line.replaceAll("[ąćęłńóśźżĄĆĘŁŃÓŚŹŻ]", "").length();
        }
        return polishChars;
    }

    /**
     * @see #getNumOfChars()
     * @see #getNumOfPolishChars()
     * @return Procent (w stosunku do liczby wszystkich znakow) polskich znakow
     * w pliku
     */
    public double percentageOfPolishChars() {
        return (double) polishChars / chars * 100;
    }

    /**
     * @see #getNumOfWords()
     * @see #getNumOfNonWhiteChars();
     * @return Srednia dlugosc slowa
     */
    public double getAvgWordLength() {
        if (words < 1) {
            getNumOfWords();
        }
        if (nonWhiteChars < 1) {
            getNumOfNonWhiteChars();
        }
        return (double) words / nonWhiteChars;
    }

    /**
     * @see #getNumOfWords()
     * @see #getNumOfLines()
     * @return Srednia liczba slow w linii
     */
    public double getAvgWordsInLine() {
        if (words < 1) {
            getNumOfWords();
        }
        return (double) words / getNumOfLines();
    }

    /**
     * @see #getNumOfChars()
     * @see #getNumOfLines()
     * @return Srednia Liczba znakow w linii
     */
    public double getAvgCharsInLine() {
        if (chars < 1) {
            getNumOfChars();
        }
        return (double) chars / getNumOfLines();
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

    /**
     *
     * @return Set wystepujacych znakow w pliku
     */
    public Set<Character> getUniqueCharacters() {
        if (!uniqueCharacters.isEmpty()) {
            return uniqueCharacters;
        }
        uniqueCharacters = (HashSet<Character>) getCharsStats().keySet();
        return uniqueCharacters;
    }

    /**
     *
     * @return Znak najczesciej wystepujacy
     */
    public Character getMostFrequentCharacter() {
        if (charsStats.isEmpty()) {
            getCharsStats();
        }
        return Collections.max(charsStats.entrySet(),
                (value1, value2) -> value1.getValue() - value2.getValue())
                .getKey();
    }

    /**
     *
     * @return Znak najrzadziej wystepujacy
     */
    public Character getLeastFrequentCharacter() {
        if (charsStats.isEmpty()) {
            getCharsStats();
        }
        return Collections.min(charsStats.entrySet(),
                (value1, value2) -> value1.getValue() - value2.getValue())
                .getKey();
    }

    public void printFile() {
        fileContent.forEach(System.out::println);
    }
}
