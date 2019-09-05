package se.lexicon.ecutb.lukas;

import java.util.Scanner;

public class Methods {
    private int maxGuesses = 8;
    private int guessAmount;
    private static Scanner sc = new Scanner(System.in);
    private static String[] words = {"hacker", "formidable", "computer", "machine", "rain", "water" };
    private static  String secretWord = words[(int) (Math.random() * words.length)];
    private char guessarray[] = new char[secretWord.length()];
    private StringBuilder sb = new StringBuilder();
    private StringBuilder madeGuesses = new StringBuilder();
    private boolean winner = false;

    public String getMadeGuesses() {
        String gissningar = madeGuesses.toString();
        return gissningar;
    }

    public void HangMan() {
        run();
    }

    public int getGuessAmount() {
        return guessAmount;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

    public int setGuessAmount(int guessAmount) {
        guessAmount++;
        this.guessAmount = guessAmount;
        return this.guessAmount;
    }

    public void getGuessAmount(int guessAmount){
        this.guessAmount = guessAmount;
    }

    public char[] setupGuessArray(){
        for (int i=0; i<secretWord.length(); i++)
        {
            guessarray[i] = '_';
        }
        return guessarray;
    }

    public StringBuilder saveGuessToSb(String guess){
        sb.append(guess);
        return sb;
    }

    public void setMadeGuesses(StringBuilder madeGuesses) {
        this.madeGuesses = madeGuesses;
    }

    public boolean checkWin(String guess) {
        boolean win = false;
        if (secretWord.equalsIgnoreCase(guess)){
            win = true;
        }
        String winners = new String(guessarray);
        if (winners.equalsIgnoreCase(secretWord)){
            win = true;
        }
        return win;
    }

    public void saveValid (String guess){
        int index = secretWord.indexOf(guess);
        char convertedGuess = guess.charAt(0);
        guessarray[index] = convertedGuess;
        for (int i=0; i<guessarray.length; i++){
            System.out.print(guessarray[i]);
        }
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

    public boolean checkGuess(String guess){
        boolean sant = false;
        sant = checkValid(guess);
        return sant;
    }

    //////////////// User Input
    public static String getString(){
        return sc.nextLine();
    }

    public void sparagissning(String guess){
        String temp = madeGuesses.toString();
        if (temp.contains(guess)) {
            System.out.println("You've already guessed " + guess);
        } else if (!temp.contains(guess)) {
            if (!checkGuess(guess)){
                getGuessAmount(setGuessAmount(getGuessAmount()));
            }
        }
    }
    public void presentera(){
        System.out.println("Make a guess. The word is " + secretWord.length() + " characters long.");
        System.out.println("Guess " + getGuessAmount() + "/" + getMaxGuesses());

    }

    public void run() {

        while (!winner && getGuessAmount() != getMaxGuesses()) {
           presentera();
            String guess = getString();
                if (checkWin(guess)){
                    System.out.println("You win! The word was "+secretWord);
                    break;
                }
            sparagissning(guess);
            setMadeGuesses(saveGuessToSb(guess));
            System.out.println("Your guesses: " + madeGuesses);
            break;
        }
    }



    }











