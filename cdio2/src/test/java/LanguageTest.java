import com.g16.game.LanguagePack;

import org.junit.Assert;
import org.junit.Test;

public class LanguageTest {

    public String[] expectedLanguageIndexes = {
        "str1", "str2", "str3"
    };
    @Test
    public void TestExpectedIndexesEnglish() {
        LanguagePack lpack = new LanguagePack("english.json");
        Assert.assertArrayEquals(lpack.getIndexes(), expectedLanguageIndexes);
    }

    @Test
    public void TestEnglishLanguagePack() {
        LanguagePack lpack = new LanguagePack("english.json");

        Assert.assertEquals("Hello, World!", lpack.getString("str1"));

        //System.out.println("str1: " + lpack.getString("str1")); 
        //System.out.println("str2: " + lpack.getString("str2")); 
        //System.out.println("str3 (World): " + String.format(lpack.getString("str3"), "World")); 
    }
}