package se.lexicon.ecutb.lukas;
import java.util.Scanner;
public class HangMan {
    private String secretWord;
    private int guessAmount = 1;
    private static Scanner sc = new Scanner(System.in);
    private char[] guessArray;
    private StringBuilder madeGuesses;
    private boolean winner = false;

    public HangMan(String secretWord){
        this.secretWord = secretWord;
        madeGuesses = new StringBuilder();
        guessArray = new char[secretWord.length()];
        setupArray();
    }

    public void setupArray(){ for (int i=0; i<secretWord.length(); i++) {  guessArray[i] = '_'; } }

    public char[] run(String guess) {
        while (!winner && guessAmount != 9) {
            System.out.println("Guess " + guessAmount + "/8");
            String temp = madeGuesses.toString();
            if (temp.contains(guess)) {
                System.out.println("You've already guessed " + guess);
            } else if (!temp.contains(guess)) {
                boolean valid = false;
                int index = 0;
                if ((guess.length() > 1 && guess.length()<secretWord.length())){
                 System.out.println("Letter not found. To guess a word, please guess a word of the same length as the secret word."); }
                if (secretWord.contains(guess) && guess.length() == 1){
                    System.out.println("Correct! \n");
                    if(secretWord.contains(guess)){
                        index = secretWord.indexOf(guess);
                        char convertedGuess = guess.charAt(0);
                        if (guess.length() == 1){
                            guessArray[index] = convertedGuess;
                            for (int i=0; i<guessArray.length; i++){ System.out.print(guessArray[i]);  }
                        }
                    }
                    valid = true;
                }
                else if (!secretWord.equalsIgnoreCase(guess)) { System.out.println("Wrong guess."); }
                if (!valid){ guessAmount = guessAmount + 1; }
            }
            if (secretWord.equalsIgnoreCase(guess)){
                winner = true;
                for (int i=0; i<guessArray.length; i++){ guessArray[i]= guess.charAt(i); }
            }
            String winners = new String(guessArray);
            if (winners.equalsIgnoreCase(secretWord)){ winner = true; }
            if (winner){ System.out.println("\nYou win! The word was "+secretWord); break; }
            if (guessAmount == 9){ System.out.println("You lose.");break; }
            if (guess.length() == 1 || guess.length() == secretWord.length()) { madeGuesses.append(" " + guess); }
            System.out.println("\nYour guesses:" + madeGuesses);
            break;
        }
        return guessArray;
    }
}
