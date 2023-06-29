package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ScoreBoard {
    private static final int MAX_MISTAKE = 7;
    private final String dictinoryPath = "nouns.txt";
    private final List<String> dictinory = new ArrayList<>();
    private char[] searchWord;
    private char[] table;

    private int countMistake;

    public ScoreBoard() {

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/App/nouns.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() <= MAX_MISTAKE) {
                    dictinory.add(line);
                }
            }
            int randomWordNUm = new Random().nextInt(dictinory.size() - 1);
            searchWord = dictinory.get(randomWordNUm).toCharArray();
            table = new char[searchWord.length];
            Arrays.fill(table, '_');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkLetter(char input) {
        boolean result = false;
        for (int i = 0; i < searchWord.length; i++) {
            if (input == searchWord[i]) {
                if (table[i] == input) {
                    System.out.println("Такая буква уже есть");
                    return true;
                }
                table[i] = input;
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
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i]);
        }
        System.out.println("\nОшибки: " + countMistake);
    }

    public String checkTable() {
        if (countMistake < MAX_MISTAKE) {
            for (char ch : table) {
                if (ch == '_') {
                    return Main.NOT_FINISH;
                }
            }
            return Main.WIN;
        }
       return Main.LOSS;
    }
}
