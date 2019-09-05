package se.lexicon.ecutb.lukas;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    String[] words = {"hacker", "formidable", "machine", "rain", "water" };
    String secretWord = words[(int) (Math.random() * words.length)];
        String guess = "a";
        boolean sann = true;
        HangMan game = new HangMan(secretWord);

        @Test
        public void checkValid(){
            Assert.assertEquals(sann, secretWord.contains(guess));
        }

        @Test
    public void saveValid(){
         char letter = game.saveValid(guess);
            Assert.assertEquals('a', letter);
        }
        @Test
        public void checkWin(){
            boolean win = game.checkWin(guess);
            Assert.assertEquals(false, win);
        }

}
