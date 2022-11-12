/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pwo.projekt.stats;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import pwo.projekt.stats.utils.FileType;

/**
 *
 * @author gman
 */
public class FileMetadataTest {

    private FileMetadata metadata;

    @BeforeAll
    public void testCreateObject() {
        try {
            metadata = new FileMetadata("./testFile");
            assertTrue(true);
            System.out.println("Obiekt zostal utworzony");
        } catch (Exception e) {
            System.out.println("Nie udalo sie utworzyc obiektu");
            assertTrue(false);
            System.out.println(e);
        }
    }

    @Test
    public void testGetCreationTime() {
        assertEquals(metadata.getCreationTime()
                .toInstant().atZone(ZoneId.of("Europe/Warsaw"))
                .toLocalDateTime()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), 
                "2022-11-12 12:33:23");
        System.out.println("Data utworzenia pliku");
    }
    
    @Test
    public void testGetFileType() {
        assertEquals(metadata.getFileType(), FileType.REGULAR);
    }
    
    @Test
    public void testGetFileSize(){
        assertEquals(metadata.getFileSize(), 133);
    }
}
