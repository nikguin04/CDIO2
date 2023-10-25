import com.g16.game.Game;
import com.g16.game.LanguagePack;
import com.g16.game.Player;
import com.g16.game.SettingsMenu;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class PrintTest {
 
    
    @Test
    public void TestDiceRollDelay() {
        long begin = System.nanoTime();
        //Starting the watch
        Game.InitializeGame(true);
        //End time
        long end = System.nanoTime();
        long time = end-begin;
        Assert.assertTrue(time < 333 * 1000000); // lower than 333 ms;
    }
}
