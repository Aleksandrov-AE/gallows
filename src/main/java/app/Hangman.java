package app;

import java.util.List;

public class Hangman {
     private List<String> hangmanState;
     private int currentState;
     {
          hangmanState = List.of("\u001B[31m  +---+\n" +
                          "      |\n" +
                          "      |\n" +
                          "      |\n" +
                          "      |\n" +
                          "      |\n" +
                          "=========\u001B[0m",
                  "\u001B[31m  +---+\n" +
                  "  |   |\n" +
                  "      |\n" +
                  "      |\n" +
                  "      |\n" +
                  "      |\n" +
                  "=========\u001B[0m"
                  , "\u001B[31m  +---+\n" +
                          "  |   |\n" +
                          "  0   |\n" +
                          "      |\n" +
                          "      |\n" +
                          "      |\n" +
                          "=========\u001B[0m"
                  , "\u001B[31m  +---+\n" +
                          "  |   |\n" +
                          "  0   |\n" +
                          "  |   |\n" +
                          "      |\n" +
                          "      |\n" +
                          "=========\u001B[0m"
                  , "\u001B[31m  +---+\n" +
                  "  |   |\n" +
                  "  0   |\n" +
                  " /|   |\n" +
                  "      |\n" +
                  "      |\n" +
                  "=========\u001B[0m"
                  , "\u001B[31m  +---+\n" +
                  "  |   |\n" +
                  "  0   |\n" +
                  " /|\\  |\n" +
                  "      |\n" +
                  "      |\n" +
                  "=========\u001B[0m"
                  , "\u001B[31m  +---+\n" +
                  "  |   |\n" +
                  "  0   |\n" +
                  " /|\\  |\n" +
                  " /    |\n" +
                  "      |\n" +
                  "=========\u001B[0m"
                  , "\u001B[31m  +---+\n" +
                  "  |   |\n" +
                  "  0   |\n" +
                  " /|\\  |\n" +
                  " / \\  |\n" +
                  "      |\n" +
                  "GAME OVER\n" +
                  "=========\u001B[0m");
     }

     public void printhangman() {
          System.out.println(hangmanState.get(currentState));
     }

     public void changeState() {
          currentState++;
     }

     public int getCurrentState() {
          return currentState;
     }
}

