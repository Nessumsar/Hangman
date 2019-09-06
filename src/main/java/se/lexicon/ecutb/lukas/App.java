package se.lexicon.ecutb.lukas;

public class App 
{


    public static void main( String[] args ) {
        String[] words = {"hacker", "formidable", "machine", "rain", "water" };
        String secretWord = words[(int) (Math.random() * words.length)];
        System.out.println("Welcome to Hangman. Make a guess consisting of a character or the whole word. You got 8 guesses.");
        boolean keepAlive = true;
        HangMan game = new HangMan(secretWord);
        do {
            game.run();
            keepAlive = game.continuePlaying();
        }while(keepAlive);
    }
}
