package app;

import java.util.List;

public class Hangman {
     private final List<String> hangmanState;
     private int currentState;

     {
          hangmanState = List.of("""
                          \u001B[31m  +---+
                                |
                                |
                                |
                                |
                                |
                          =========\u001B[0m""",
                  """
                          \u001B[31m  +---+
                            |   |
                                |
                                |
                                |
                                |
                          =========\u001B[0m""",
                  """
                          \u001B[31m  +---+
                            |   |
                            0   |
                                |
                                |
                                |
                          =========\u001B[0m""",
                  """
                          \u001B[31m  +---+
                            |   |
                            0   |
                            |   |
                                |
                                |
                          =========\u001B[0m""",
                  """
                          \u001B[31m  +---+
                            |   |
                            0   |
                           /|   |
                                |
                                |
                          =========\u001B[0m""",
                  """
                          \u001B[31m  +---+
                            |   |
                            0   |
                           /|\\  |
                                |
                                |
                          =========\u001B[0m""",
                  """
                          \u001B[31m  +---+
                            |   |
                            0   |
                           /|\\  |
                           /    |
                                |
                          =========\u001B[0m""",
                  """
                          \u001B[31m  +---+
                            |   |
                            0   |
                           /|\\  |
                           / \\  |
                                |
                          GAME OVER
                          =========\u001B[0m""");
     }

     public void printhangman() {
          System.out.println(hangmanState.get(currentState));
     }

     public void changeState() {
          currentState++;
     }
}

