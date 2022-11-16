/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pwo.projekt.cli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elizakoziol8
 */
public class DataDisplayTest {
    
    public DataDisplayTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of printHeadline method, of class DataDisplay.
     */
    @Test
    public void testPrintHeadline() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String[] headline = new String[21];
        headline[0] = "Sciezka do pliku";
        headline[1] = "Data utworzenia pliku";
        for (int z=2; z<21;z++) {
                headline[z] = "";
        }
        DataDisplay.printHeadline(headline);
        String expHeadline = "";
        for (int z=0; z<21;z++) {
                expHeadline = expHeadline + String.format("%-40s", headline[z]);
        }
        String expResult = "\n--------------------------------Statystyki dla plikow---------------------------------\n"+ expHeadline + "\n";
        assertEquals(expResult, outContent.toString());
    }

    /**
     * Test of printFilesData method, of class DataDisplay.
     */
    @Test
    public void testPrintFilesData() {
        System.out.println("printFilesData");
        int filesAmount = 0;
        Object[][] filesData = null;
        DataDisplay.printFilesData(filesAmount, filesData);
    }
    
}
