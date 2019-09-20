package se.lexicon.ecutb.lukas;
public class HangMan {
    private String secretWord;
    private int guessAmount = 1;
    private char[] guessArray;
    private StringBuilder madeGuesses;
    private boolean winner = false;
    private boolean valid = false;

    HangMan(String secretWord){
        this.secretWord = secretWord;
        madeGuesses = new StringBuilder();
        guessArray = new char[secretWord.length()];
        setupArray();
    }

    private void setupArray(){ for (int i=0; i<secretWord.length(); i++) {  guessArray[i] = '_'; } }

    char[] checkGuess(String guess){
        String temp = madeGuesses.toString();
        if (temp.contains(guess)) {
            System.out.println("You've already guessed " + guess);
        } else if (!temp.contains(guess)) {
            int index = 0;
            if ((guess.length() > 1 &&
                    (guess.length()<secretWord.length() || guess.length()>secretWord.length()))){
         System.out.println("Letter not found. To guess a word, please guess a word of the same length as the secret word."); }
            if (secretWord.contains(guess) && guess.length() == 1){
                System.out.println("Correct! \n");

                if(secretWord.contains(guess)){
                    index = secretWord.indexOf(guess);
                    char convertedGuess = guess.charAt(0);
                    guessArray[index] = convertedGuess;
                        for (char c : guessArray) { System.out.print(c); }
                }
                valid = true;
            } else if (!secretWord.equalsIgnoreCase(guess) &&
            (guess.length() == 1 || guess.length() == secretWord.length())) { System.out.println("Wrong guess."); }
            if (!valid){ guessAmount = guessAmount + 1; }
        }
        return guessArray;
    }

    char[] checkWin(String guess){
        if (secretWord.equalsIgnoreCase(guess)){
            winner = true;
            for (int i=0; i<guessArray.length; i++){ guessArray[i]= guess.charAt(i); }
        }
        String winners = new String(guessArray);
        if (winners.equalsIgnoreCase(secretWord)){ winner = true; }
        if (winner){ System.out.println("\nYou win! The word was "+secretWord); }
        if (guessAmount == 9){ System.out.println("You lose.");}
        if (guess.length() == 1 || guess.length() == secretWord.length()) { madeGuesses.append(" " + guess); }
        System.out.println("\nYour guesses:" + madeGuesses);
        return guessArray;
    }

    char[] run(String guess) {
        while (!winner && guessAmount != 9) {
            System.out.println("Guess " + guessAmount + "/8");
            if (guess.equalsIgnoreCase("0")){
                System.out.println("Exiting program.");
                break;
            }
            checkGuess(guess);
            checkWin(guess);
            break;
        }
        return guessArray;
    }
}
