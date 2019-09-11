package se.lexicon.ecutb.lukas;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AppTest 
{
        String guess = "a";
        String wrongGuess = "q";
        String guessword = "hacker";
        String wrongWord = "packer";
        HangMan game = new HangMan(guessword);

        @Test
        public void RunCorrectLetter(){
            char[] testchar = new char [5];
           testchar = game.run(guess); //Act
          String temp = Arrays.toString(testchar);
           Assert.assertEquals("[_, a, _, _, _, _]", temp);
            //Testar om run returnerar array med a på rätt plats vilket görs
        }
    @Test
    public void RunWrongLetter(){
        char[] testchar = new char [5];
        testchar = game.run(wrongGuess); //Act
        String temp = Arrays.toString(testchar);
        Assert.assertEquals("[_, _, _, _, _, _]", temp);
        //Testar om run returnerar tomt array vid gissning på fel bokstav
    }
    @Test
    public void RunWrongWord(){
        char[] testchar = new char [5];
        testchar = game.run(wrongWord); //Act
        String temp = Arrays.toString(testchar);
        Assert.assertEquals("[_, _, _, _, _, _]", temp);
        //Testar om run returnerar ett tomt array om man gissar fel ord
    }
    @Test
    public void RunCorrectWord(){
        char[] testchar = new char [5];
        testchar = game.run("hacker"); //Act
        String temp = Arrays.toString(testchar);
        Assert.assertEquals("[h, a, c, k, e, r]", temp);
        //Testar om run returnerar rätt ord vid gissning på rätt ord
    }
}

