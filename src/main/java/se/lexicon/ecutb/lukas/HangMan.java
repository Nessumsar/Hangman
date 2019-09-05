package se.lexicon.ecutb.lukas;

import java.util.Scanner;

public class HangMan {
    private String secretWord;
    private int maxGuesses = 8;
    private int guessAmount;
    private static Scanner sc = new Scanner(System.in);
    private char guessarray[];
    private StringBuilder sb;
    private StringBuilder madeGuesses = new StringBuilder();
    private boolean winner = false;

    public HangMan(String secretWord){
        this.secretWord = secretWord;
        sb = new StringBuilder();
        guessarray = new char[secretWord.length()];
        setupGuessArray();
    }


    public int setGuessAmount(int guessAmount) {
        guessAmount++;
        this.guessAmount = guessAmount;
        return this.guessAmount;
    }

    public int getGuessAmount(int guessAmount){
        this.guessAmount = guessAmount;
        return this.guessAmount;
    }

    public void setupGuessArray(){
        for (int i=0; i<secretWord.length(); i++)
        {
            guessarray[i] = '_';
        }
    }

    public StringBuilder saveGuessToSb(String guess){
        sb.append(guess);
        return sb;
    }

    public void setMadeGuesses(StringBuilder madeGuesses) {
        this.madeGuesses = madeGuesses;
    }

    public boolean checkWin(String guess) {
        if (secretWord.equalsIgnoreCase(guess)){
            winner = true;
        }
        String winners = new String(guessarray);
        if (winners.equalsIgnoreCase(secretWord)){
            winner = true;
        }

        return winner;
    }

    public char saveValid (String guess){
        int index = secretWord.indexOf(guess);
        char convertedGuess = guess.charAt(0);
        guessarray[index] = convertedGuess;
        for (int i=0; i<guessarray.length; i++){
            System.out.print(guessarray[i]);
        }
        return convertedGuess;
    }

    public boolean checkValid (String guess) {
        boolean valid = false;
        if (secretWord.contains(guess)){
            System.out.println("Correct!");
            saveValid(guess);
            System.out.println("");
            valid = true;
        }
        else if (!secretWord.equalsIgnoreCase(guess)){
            System.out.println("Wrong guess.");
        }
        return valid;
    }

    public static String getString(){
        return sc.nextLine();
    }

    public void sparagissning(String guess){
        String temp = madeGuesses.toString();
        if (temp.contains(guess)) {
            System.out.println("You've already guessed " + guess);
        } else if (!temp.contains(guess)) {
            if (!checkValid(guess)){
                getGuessAmount(setGuessAmount(getGuessAmount(guessAmount)));
            }
        }
    }
    public void presentera(){
        System.out.println("Make a guess. The word is " + secretWord.length() + " characters long.");
        System.out.println("Guess " + getGuessAmount(guessAmount) + "/8");
    }

    public boolean run() {
        boolean done = false;
        while (!winner && getGuessAmount(guessAmount) != 8) {
            presentera();
            String guess = getString();
            sparagissning(guess);
            if (checkWin(guess)){
                System.out.println("You win! The word was "+secretWord);
                done = true;
            }
            setMadeGuesses(saveGuessToSb(guess));
            System.out.println("Your guesses: " + madeGuesses);
            break;
        }
        return done;
    }

}
