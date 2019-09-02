package se.ecutb.lukas;

public class UserInterface {
    private HangMan game;
    private boolean winner;

    public UserInterface(HangMan game){
        this.game = game;
    }
    public void run(){
        while (!winner & game.getGuessAmount() == game.getMaxGuesses()){
            System.out.println("Guess: "+game.getGuessAmount()+ "/ "+game.getMaxGuesses());
            System.out.println("Make a guess");
            String guess = UserInput.getString();
            winner = game.guess(guess);

        }
    }
    public int stringToInt(String input){
        return Integer.parseInt(input);
    }
}
