import com.g16.game.LanguagePack;
import com.g16.game.SettingsMenu;

import org.junit.Assert;
import org.junit.Test;

public class LanguageTest {

    public String[] expectedLanguageIndexes = {
        "square_2", "square_3", "square_4", "square_5", "square_6", "square_7", "square_8", "square_9", "square_10", "square_11", "square_12", 
    };
    @Test
    public void TestExpectedIndexesEnglish() {
        LanguagePack lpack = new LanguagePack("english");
        Assert.assertArrayEquals(lpack.getIndexes(), expectedLanguageIndexes);
    }

    @Test
    public void TestEnglishLanguagePack() {
        LanguagePack lpack = new LanguagePack("english");

        Assert.assertEquals("You have made your way to a Tower, and found %d money!", lpack.getString("square_2"));

        //System.out.println("str1: " + lpack.getString("str1")); 
        //System.out.println("str2: " + lpack.getString("str2")); 
        //System.out.println("str3 (World): " + String.format(lpack.getString("str3"), "World")); 
    }

    @Test
    public void TestLanguageSettings() {
        System.out.println("asdasdasdas");
        LanguagePack.getAllPacks();
    }
}