package se.lexicon.ecutb.lukas;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args ) {
        String[] words = {"hacker", "formidable", "machine", "rain", "water" };
        String secretWord = words[(int) (Math.random() * words.length)];
        System.out.println("Welcome to Hangman. Make a guess consisting of a character or the whole word. You got 8 guesses.");
        boolean keepAlive = true;

        HangMan game = new HangMan(secretWord); //lägg allt i hangman?
        do {
            game.run();

            //////////////
            System.out.println("Do you want to quit? Press Y to quit, press any key to continue.");
            switch(HangMan.getString().trim().toLowerCase()){
                case "y":
                    keepAlive = false;
                    System.out.println("Bye!");
                    break;
            }
        }while(keepAlive);

    }


}
