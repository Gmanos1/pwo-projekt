/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.projekt.stats.utils;

/**
 *
 * @author gman
 */
public enum FileType {
    REGULAR,
    DIRECTORY,
    SYMLINK,
    OTHER;
    
    @Override
    public String toString() {
        return this.toString().toLowerCase();
    }
}
