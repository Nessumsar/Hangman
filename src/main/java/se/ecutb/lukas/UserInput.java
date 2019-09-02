package se.ecutb.lukas;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static String getString(){
        return sc.nextLine();
    }
    public static int getInt(){
        boolean valid = false;
        int number = 0;
        while (!valid){

            try{
                number = Integer.parseInt(getString().trim());
                valid = true;
            }catch(NumberFormatException exceptionName){
                System.out.println("Invalid format.");
            }
        }
        return number;
    }
}
