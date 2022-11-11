/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.projekt.stats.utils;

/**
 * Typ wyliczeniowy odnoszacy sie do typu pliku
 * Mozliwe typy: REGULAR, DIRECTORY, SYMLINK, OTHER
 * 
 * @author gman
 */
public enum FileType {
    REGULAR,
    DIRECTORY,
    SYMLINK,
    OTHER;
    
    /**
     * 
     * @return Tekstowa reprezentacja
     */
    @Override
    public String toString() {
        return this.toString().toLowerCase();
    }
}
