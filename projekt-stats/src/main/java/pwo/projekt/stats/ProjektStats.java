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

    public static void main(String[] args) {
        FileType fileType = FileType.DIRECTORY;
        System.out.println(fileType.toString());
        try {
            FileMetadata stats = new FileMetadata("/home/opensuse/eliza/abc");
            System.out.println(stats.getOwner());
        } catch (Exception e) {
            System.out.println("Nie mozna odczytac pliku");
        }
    }
}
