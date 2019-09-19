package se.lexicon.ecutb.lukas;
import java.util.Scanner;
public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] words = {"hacker", "formidable", "machine", "rain", "water"};
        String secretWord = words[(int) (Math.random() * words.length)];
        char[] temp;
        System.out.println("Welcome to Hangman. Make a guess consisting of a character or the whole word. You got 8 guesses.");
        HangMan game = new HangMan(secretWord);
            System.out.println("Make a guess. The word is " + secretWord.length() + " characters long.");
           do {
                String guess = sc.next();
                temp = game.run(guess);
            }while (temp.equals(secretWord.toCharArray()));
    }
}
