package se.lexicon.ecutb.lukas;
import org.junit.Assert;
import org.junit.Test;

public class AppTest 
{
        String guess = "a"; //om guess innehåller mer än 1 bokstav blir checkvalid felaktig
        String invalidGuess = "ab";
        String wrongGuess = "q";
        String guessword = "hacker";//användes för att prova checkwin, test failar när testet slumpar hacker som ska ge true
        String wrongWord = "cow";
        HangMan game = new HangMan(guessword);

        @Test
        public void checkValid(){
        boolean valid = game.checkValid(guess);
        Assert.assertEquals(true, valid);
        //Returnar true pga a finns i ordet hacker.
        }
        @Test
        public void checkValidFalse(){
        boolean valid = game.checkValid(invalidGuess);
        Assert.assertEquals(false, valid);
        //Skriver "letter not found. wrong guess." samt returnar falskt pga två bokstäver ej är en bokstav eller hela ordet
    }
        @Test
        public void saveValidTrue(){
        char[] temp = guess.toCharArray();
        char letter = game.saveValid(guess);
        Assert.assertEquals(temp[0], letter);
        //Returnerar gissningen om den läggs in på rätt ställe. Jämför gissningen som förs in med gissningen som returneras.
        //Skriver även ut gissningen på rätt plats i gissningsarrayet. "_a___"
        }
        @Test
        public void saveValidFalse(){
        char letter = game.saveValid(wrongGuess);
        Assert.assertEquals('_', letter);
        //Sparar gissningen om den är rätt vilket den inte är. Då ska den returnera '_' från chararray som görs här
        //Skriver även ut gissningen på rätt plats i gissningsarrayet om gissningen är rätt, som ej görs då gissningen ej stämmer.
    }
        @Test
        public void checkWinTrue(){
        boolean win = game.checkWin(guessword);
        Assert.assertEquals(true, win);
        //kollar om man vinner om man gissar rätt ord, returnerar true pga vinst
        }
        @Test
        public void checkWinFalse(){
        boolean win = game.checkWin(wrongWord);
        Assert.assertEquals(false, win);
        //kollar om man vinner om man gissar fel ord, returnerar falskt pga ej vinst
        }

}
