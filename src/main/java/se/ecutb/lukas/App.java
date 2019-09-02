package se.ecutb.lukas;
import java.util.Scanner;
/**
 * Hangman
 * Grunder att bygga på
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Välkommen till HangMan. Regler: Du har 8 gissningar. Du kan gissa på en bokstav eller hela ordet.");
        boolean keepAlive = true;
        do {
            HangMan game = new HangMan("ska ändras");
            UserInterface session = new UserInterface(game);
            session.run();
            //////////////
            System.out.println("Do you want to quit? (Y/N)");
            switch(UserInput.getString().trim().toLowerCase()){
                case "y":
                    keepAlive = false;
                    System.out.println("Bye!");
                    break;
            }
        }while(keepAlive);

    }

    public static char[] stringToChar(){
        String testString = "abcdefghijklmnopqrstuvwxyzåäö";
        char[] stringToCharArray = testString.toCharArray();
        return stringToCharArray;
    }
    public static String gissning (String input) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Gissa en bokstav.");
        if (sc.hasNextInt()){
            System.out.println("Det är ingen bokstav. Du skrev "+sc.nextInt());
        } else
            input = sc.nextLine();
        return input;
    }
    }

/*
 System.out.println(stringToChar());
        String a = "";
        Scanner sc = new Scanner(System.in);
        int maxGuess = 8;
        int guessNumber = 0;
        String secretWord = "klasskampen";
        String stringGuesses[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","å","ä","ö"};

        boolean spela = true;
        while(spela){
            String madeGuess = gissning(a);
            System.out.println(madeGuess);
            if(guessNumber == maxGuess){
                System.out.println("Du förlorade.");
                        break;
            }
        } //whileslut
 */