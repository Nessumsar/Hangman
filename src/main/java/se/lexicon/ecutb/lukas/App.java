package se.lexicon.ecutb.lukas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Welcome to Hangman. Make a guess consisting of a character or the whole word. You got 8 guesses.");
        boolean keepAlive = true;
        Methods game = new Methods();
        game.setupGuessArray();
        do {
            game.HangMan();

            //////////////
            System.out.println("Do you want to quit? Press Y to quit, press any key to continue.");
            switch(Methods.getString().trim().toLowerCase()){
                case "y":
                    keepAlive = false;
                    System.out.println("Bye!");
                    break;
            }
        }while(keepAlive);

    }
}
