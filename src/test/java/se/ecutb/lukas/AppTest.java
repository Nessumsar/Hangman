package se.lexicon.ecutb.lukas;
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
public class AppTest 
{
        private HangMan game = new HangMan("hacker");

        @Test
        public void RunCorrectLetter(){
            char[] testchar;
           testchar = game.run("a");
          String temp = Arrays.toString(testchar);
           Assert.assertEquals("[_, a, _, _, _, _]", temp);
        }
    @Test
    public void RunWrongLetter(){
        char[] testchar;
        testchar = game.run("q");
        String temp = Arrays.toString(testchar);
        Assert.assertEquals("[_, _, _, _, _, _]", temp);
    }
    @Test
    public void RunWrongWord(){
        char[] testchar;
        testchar = game.run("packer");
        String temp = Arrays.toString(testchar);
        Assert.assertEquals("[_, _, _, _, _, _]", temp);
    }
    @Test
    public void RunCorrectWord(){
        char[] testchar ;
        testchar = game.run("hacker");
        String temp = Arrays.toString(testchar);
        Assert.assertEquals("[h, a, c, k, e, r]", temp);
    }

}
