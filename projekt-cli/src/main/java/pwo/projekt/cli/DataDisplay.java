/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.projekt.cli;

/**
 *
 * @author elizakoziol8
 */
public class DataDisplay {
    
    public static void printHeadline(String[] headline) {
        System.out.println("");
        System.out.println("--------------------------------Statystyki dla plikow---------------------------------");
        for (int z=0; z<21;z++) {
                System.out.printf("%-40s", headline[z]);
        }
        System.out.println("");
    }
    
    public static void printFilesData(int filesAmount, Object[][] filesData) {
        for (int x=0; x<filesAmount;x++) {
            for (int y=0; y<21;y++) {
                  System.out.printf("%-40s", filesData[x][y]);
            }
                System.out.println("");
        }
    }
    
}
