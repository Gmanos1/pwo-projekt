/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pwo.projekt.stats;

import pwo.projekt.stats.utils.FileType;

/**
 *
 * @author gman
 */
public class ProjektStats {

    private static String testFile = "/home/gman/testFile";
    public static void main(String[] args) {
        FileType fileType = FileType.DIRECTORY;
        System.out.println(fileType.toString());
        try {
            FileMetadata meta = new FileMetadata(testFile);
            System.out.println(meta.getOwner());
            FileStatistics stats = new FileStatistics(testFile);
            //stats.printFile();
            System.out.println(stats.getNumOfLines());
            System.out.println(stats.getNumOfWords());
            System.out.println(stats.getNumOfChars());
            System.out.println(stats.getCharsStats());
        } catch (Exception e) {
        }

    }
}