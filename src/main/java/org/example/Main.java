package org.example;

import java.sql.SQLOutput;
import java.util.*;

import static org.example.Filemanager.saveScores;
import static org.example.Filemanager.saveScores2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");




        List<String> Letters = Arrays.asList("a", "b", "c", "d", "e");


        String letter1 = Letters.get(new Random().nextInt(Letters.size()));
        String letter2 = Letters.get(new Random().nextInt(Letters.size()));
        String letter3 = Letters.get(new Random().nextInt(Letters.size()));
        String letter4 = Letters.get(new Random().nextInt(Letters.size()));


        System.out.println(letter1 + letter2 + letter3 + letter4);


        String playername1 = "";
        String playername2 = "";
        String currentPlayer = "";
        int triesplayer1 = 0;
        int triesplayer2 = 0;

        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);

        System.out.println(" Voer de naam van de eerste speler en tweede speler in!");

        playername1 = input2.next();
        playername2 = input2.next();

        System.out.println(" De spelers die je hebt ingevoerd zijn:");
        System.out.println(playername1);
        System.out.println(playername2);
        currentPlayer = playername1;

        boolean almostWon = false;
        boolean hasplayerWon = false;
        while (hasplayerWon == false && triesplayer1 <=12 || triesplayer2 <=12) {

            if(currentPlayer.equals(playername1)) {
                if (triesplayer1 == 12) {
                    System.out.println(currentPlayer + " is out of tries! Game over!");
                    break;
                }
            }else {
                if (triesplayer2 == 12) {
                    System.out.println(currentPlayer + " is out of tries! Game over!");
                    break;
                }
            }


            boolean continuePlaying = true;
            System.out.println("Wil je verder spelen j/n?");
            String continuePlayingchoice = input3.next();


            switch (continuePlayingchoice) {
                case "j": // continue playing this game
                    System.out.println("Je hebt gekozen verder te gaan");
                    continuePlaying = true;
                    break;
                case "n": // stop playing this game
                    System.out.println("Je hebt gekozen te stoppen ");
                    continuePlaying = false;
                    break;
                default: // please enter valid answer
                    System.out.println(" Please enter a valid digit");
                    break;
            }

            if (continuePlaying == false) {
                System.out.println("Dit spel is geëindigd");
                break;
            }

            System.out.println(" Voer de letters in de je hebt gekozen!");

            Scanner input = new Scanner(System.in);

            String guessA = input.next();
            String guessB = input.next();
            String guessC = input.next();
            String guessD = input.next();

            System.out.println(" De letters die je hebt ingevoerd zijn:");
            System.out.println(guessA);
            System.out.println(guessB);
            System.out.println(guessC);
            System.out.println(guessD);

            hasplayerWon = guessA.equals(letter1) && guessB.equals(letter2) && guessC.equals(letter3) && guessD.equals(letter4);
            almostWon = guessA.equals(letter2)  || guessA.equals(letter1) || guessA.equals(letter3)  || guessA.equals(letter4)  || guessB.equals(letter1) || guessB.equals(letter2) || guessB.equals(letter3) || guessB.equals(letter4) || guessC.equals(letter1) || guessC.equals(letter2) || guessC.equals(letter3) || guessC.equals(letter4) || guessD.equals(letter1) || guessD.equals(letter2) || guessD.equals(letter4) || guessD.equals(letter3);


            if (hasplayerWon == true) {
                if(currentPlayer.equals(playername1)) {
                    triesplayer1++;
                System.out.println("Speler "+ currentPlayer +  " heeft gewonnen met " + triesplayer1 + " pogingen. De code is " + letter1 + letter2 + letter3 + letter4 );

                    boolean scoresSaved = saveScores("C:/Filemanagerexamplesoefening/score.txt", playername1,triesplayer1);

                    if(scoresSaved){
                        System.out.println("Scores opgesglagen op C schijf");
                    }
                    if(!scoresSaved) {
                        System.out.println("Scores konden niet worden opgeslagen");
                    }


                    break;
                }else {
                    triesplayer2++;
                    System.out.println("Speler "+ currentPlayer +  " heeft gewonnen met " + triesplayer2 + " pogingen. De code is " + letter1 + letter2 + letter3 + letter4 );
                    boolean scoresSaved = saveScores2("C:/Filemanagerexamplesoefening/score.txt", playername2,triesplayer2);

                    if(scoresSaved){
                        System.out.println("Scores opgesglagen op C schijf");
                    }
                    if(!scoresSaved) {
                        System.out.println("Scores konden niet worden opgeslagen");
                    }

                    break;
                }
            }else {
                System.out.println("Speler heeft het niet goed geraden");
                if(currentPlayer.equals(playername1) ){
                    triesplayer1 ++;
                    currentPlayer = playername2;
                }
                else{
                    triesplayer2 ++;
                    currentPlayer = playername1;
                }
            }




            if (almostWon) {
                System.out.println("Speler is er bijna!");

                if(guessA.equals(letter1)) {
                    System.out.println(guessA + "+");
                }

                if(guessB.equals(letter2)) {
                    System.out.println(guessB + "+");
                }


                if(guessC.equals(letter3)) {
                    System.out.println(guessC + "+");
                }


                if(guessD.equals(letter4)) {
                    System.out.println(guessD + "+");
                }


                if (guessA.equals(letter2) || guessA.equals(letter3) || guessA.equals(letter4)) {
                    System.out.println(guessA + "?");
                }
                if (guessB.equals(letter1) || guessB.equals(letter3) || guessB.equals(letter4)) {
                    System.out.println(guessB + "?");
                }
                if (guessC.equals(letter1) || guessC.equals(letter2) || guessC.equals(letter4)) {
                    System.out.println(guessC + "?");
                }
                if (guessD.equals(letter1) || guessD.equals(letter2) || guessD.equals(letter3)) {
                    System.out.println(guessD + "?");
                }

            }


        }

    }


}