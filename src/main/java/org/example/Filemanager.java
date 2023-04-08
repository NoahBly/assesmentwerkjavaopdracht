package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filemanager {

    public static boolean saveScores(String filename,String player1, int triesplayer1) {

        try {
            File scoreFile = new File(filename);
            FileWriter pen = new FileWriter(scoreFile);
            BufferedWriter printer = new BufferedWriter(pen);
            printer.write(player1 + " has had this many times before game got completed " + triesplayer1 );
            printer.newLine();
            printer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Geen toegang tot locatie: " + "C:/Filemanagerexamplesoefening/scoregame.txt");
            return false;
        }
    }


    public static boolean saveScores2(String filename, String player2, int triesplayer2) {

        try {
            File scoreFile = new File(filename);
            FileWriter pen = new FileWriter(scoreFile);
            BufferedWriter printer = new BufferedWriter(pen);
            printer.write(player2 + " has had this many times before game got completed " + triesplayer2 );
            printer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Geen toegang tot locatie: " + "C:/Filemanagerexamplesoefening/scoregame.txt");
            return false;
        }
    }


}
