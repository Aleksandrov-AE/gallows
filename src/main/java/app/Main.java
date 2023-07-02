package app;


import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static final String WIN = "Победил игрок";
    public static final String LOSS = "Победил Hangman";
    public static final String NOT_FINISH = "Игра продолжается";

    public static void main(String[] args) {
        do {
            System.out.println(System.getProperty("user.dir"));
            startRound();
            System.out.println("1. New game");
            System.out.println("2. Exit");
            String s = scanner.next();
            if (Objects.equals(s.toLowerCase(), "2")) {
                scanner.close();
                return;
            }
        } while (true);
    }

    public static void startRound() {
        ScoreBoard scoreBoard = new ScoreBoard();
        Hangman hagman = new Hangman();
        hagman.printhangman();
        gameLoop(scoreBoard, hagman);
    }

    public static void gameLoop(ScoreBoard scoreBoard, Hangman hagman) {
        do {
            scoreBoard.printScoreBoard();
            char ch = inputLetter();
            if (!scoreBoard.checkLetter(ch)) {
                hagman.changeState();
            }
            hagman.printhangman();
            String state = scoreBoard.checkGameState();
            if (!Objects.equals(state, NOT_FINISH)) {
                System.out.println("******" + state + "******");
                System.out.println("========================");
                return;
            }
        } while (true);
    }

    public static char inputLetter() {
        do {
            System.out.print("Введите букву: ");
            char ch = scanner.next().charAt(0);
            if (Character.UnicodeBlock.CYRILLIC.equals(Character.UnicodeBlock.of(ch))) {
                return Character.toLowerCase(ch);
            } else {
                System.out.println("\u001B[31m ВВедите букву на кирилице\u001B[0m");
            }
        } while (true);
    }
}
