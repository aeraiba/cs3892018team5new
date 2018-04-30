package pace.cs3892018team5.dev.chinesefortuneaide;

import java.util.Random;
import java.util.ArrayList;

public class Fortunes {

    String fortune1;
    String fortune2;

    public Fortunes(String english, String translation){

    fortune1 = english;
    fortune2 = translation;

    }


    public void print()
    {
        System.out.println("Fortune of the day" + fortune1);
        System.out.println("Translation to Chinese" + fortune2);
    }

    public String getRandomFortune()
    {
        return  fortune1 + "\n" + "Translation in Chinese: " + fortune2;
    }





}

