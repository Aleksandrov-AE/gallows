package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ScoreBoard {
    private static final int MAX_MISTAKE = 7;
    private static final char MASK = '_';
    private char[] searchWord;
    private char[] table;

    private final List<Character> enteredLetter = new ArrayList<>();
    private int countMistake;
    private int countRightLetter;
    private final String path = "nouns.txt";

    public ScoreBoard() {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String line;
            List<String> dictinory = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (line.length() <= MAX_MISTAKE) {
                    dictinory.add(line);
                }
            }
            int randomWordNUm = new Random().nextInt(dictinory.size() - 1);
            searchWord = dictinory.get(randomWordNUm).toCharArray();
            table = new char[searchWord.length];
            Arrays.fill(table, MASK);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkLetter(char input) {
        boolean result = false;
        boolean letterWas = enteredLetter.contains(input);
        enteredLetter.add(input);
        if (letterWas) {
            System.out.println("\u001B[31mТакая буква уже вводилась\u001B[0m");
            enteredLetter.add(input);
            return true;
        }
        enteredLetter.add(input);
        for (int i = 0; i < searchWord.length; i++) {
            if (input == searchWord[i]) {
                table[i] = input;
                countRightLetter++;
                result = true;
            }
        }
        if (!result) {
            countMistake++;
        }
        return result;
    }

    public void printScoreBoard() {
        System.out.print("SearcheWord:");
        for (char c : table) {
            System.out.print(c);
        }
        System.out.println("\nОшибки: " + countMistake);
    }

    public String checkGameState() {
        if (countMistake < MAX_MISTAKE) {
            if (table.length != countRightLetter) {
                return Main.NOT_FINISH;
            }  else {
                return Main.WIN;
            }
        }
        return Main.LOSS;
    }
}
