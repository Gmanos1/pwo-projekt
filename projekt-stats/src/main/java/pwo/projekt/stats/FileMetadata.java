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
 *
 * Klasa pozwala na uzyskanie podstawowych meta informacji o pliku, takie jak
 * data utworzenia, modyfikacji, ostatniego dostepu do pliku, typ pliku, jego
 * rozmiar i kto jest wlascicielem.
 *
 * @author gman
 */
public class FileMetadata {

    private final BasicFileAttributes basicAttributes;
    private final FileOwnerAttributeView ownerAttributes;
    
    /**
     * 
     * @param fileName Sciezka do pliku
     * @throws IOException 
     */
    public FileMetadata(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        basicAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);
        ownerAttributes = Files.getFileAttributeView(filePath, FileOwnerAttributeView.class);
    }

    /**
     * 
     * @return Data utworzenia pliku
     */
    public FileTime getCreationTime() {
        return basicAttributes.creationTime();
    }
    /**
     * 
     * @return Data ostatniego dostepu do pliku
     */
    public FileTime getLastAccessTime() {
        return basicAttributes.lastAccessTime();
    }
    /**
     * 
     * @return Data ostatniej modifykacji pliku
     */
    public FileTime getLastModificationTime() {
        return basicAttributes.lastModifiedTime();
    }
    /**
     * @see pwo.projekt.stats.utils.FileType
     * @return Typ podanego pliku
     */
    public FileType getFileType() {
        if(basicAttributes.isRegularFile()) return FileType.REGULAR;
        if(basicAttributes.isDirectory()) return FileType.DIRECTORY;
        if(basicAttributes.isSymbolicLink()) return FileType.SYMLINK;
        return FileType.OTHER;
    }
    
    /**
     * 
     * @return Rozmiar pliku
     */
    public long getFileSize() {
        return basicAttributes.size();
    }
    
    /**
     * 
     * @return Wlasciciel pliku
     */
    public String getOwner(){
        try {
            return ownerAttributes.getOwner().getName();
        } catch (IOException ex) {
            return "Unknown";
        }
    }
}