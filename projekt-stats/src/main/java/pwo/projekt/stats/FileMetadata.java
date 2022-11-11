/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.projekt.stats;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import pwo.projekt.stats.utils.FileType;

/**
 * Mozliwe statystyki: Liczba linii, liczba slow (na
 * podstawie spacji), liter Liczba znakow (ogolnie), (polskich), % polskich
 * znakow Srednia dlugosc slowa Histogram najczesciej wystepujacych znakow
 *
 * Klasa pozwala na uzyskanie podstawowych meta informacji o pliku, takie jak
 * data utworzenia, modyfikacji, ostatniego dostepu do pliku, typ pliku
 *
 * @author gman
 */
public class FileMetadata {

    private final BasicFileAttributes basicAttributes;
    private final FileOwnerAttributeView ownerAttributes;
    
    public FileMetadata(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        basicAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);
        ownerAttributes = Files.getFileAttributeView(filePath, FileOwnerAttributeView.class);
    }

    public FileTime getCreationTime() {
        return basicAttributes.creationTime();
    }
    
    public FileTime getLastAccessTime() {
        return basicAttributes.lastAccessTime();
    }
    
    public FileTime getLastModificationTime() {
        return basicAttributes.lastModifiedTime();
    }
    
    public FileType getFileType() {
        if(basicAttributes.isRegularFile()) return FileType.REGULAR;
        if(basicAttributes.isDirectory()) return FileType.DIRECTORY;
        if(basicAttributes.isSymbolicLink()) return FileType.SYMLINK;
        return FileType.OTHER;
    }
    
    public long getFileSize() {
        return basicAttributes.size();
    }
    
    public String getOwner(){
        try {
            return ownerAttributes.getOwner().getName();
        } catch (IOException ex) {
            return "Unknown";
        }
    }
}
