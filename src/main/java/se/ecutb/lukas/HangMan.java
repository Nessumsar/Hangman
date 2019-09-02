package se.ecutb.lukas;

import java.util.Scanner;

public class HangMan {
        private int maxGuesses;
        private String secretWord;
        private int guessAmount;

        public HangMan(String secretWord){
                this.secretWord = secretWord;
                guessAmount = 1;
                maxGuesses = 8;
        }

        public String  getSecretWord() {
                return secretWord;
        }

        public int getGuessAmount() {
                return guessAmount;
        }

        public int getMaxGuesses() {
                return maxGuesses;
        }

        public void setGuessAmount(int guessAmount) {
                this.guessAmount = guessAmount;
        }

        public void setMaxGuesses(int maxGuesses) {
                this.maxGuesses = maxGuesses;
        }

        public void setSecretWord(String secretWord) {
                this.secretWord = secretWord;
        }

        public boolean guess(String guess){
                guessAmount++;
                if (guess == secretWord){
                        System.out.println("Wrong guess");
                        return false;
                } else{
                        System.out.println("Correct!");
                        return true;
                }
        }


}
