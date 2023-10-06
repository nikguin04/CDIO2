import com.g16.game.LanguagePack;

public class LanguageTest {
    public static void main(String[] args) {
        LanguagePack lpack = new LanguagePack("english.json");

        System.out.println("str1: " + lpack.getString("str1")); 
        System.out.println("str2: " + lpack.getString("str2")); 
        System.out.println("str3 (World): " + String.format(lpack.getString("str3"), "World")); 
    }
}