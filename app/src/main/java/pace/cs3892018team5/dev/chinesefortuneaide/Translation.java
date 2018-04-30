package pace.cs3892018team5.dev.chinesefortuneaide;

import java.util.ArrayList;
import java.util.Random;


public class Translation extends Fortunes {
    public ArrayList<Fortunes> myFortunes;


    public  Translation()
    {
        super("", "");
        myFortunes = new ArrayList<Fortunes>();
        setFortune();
    }

//Fortune Class
    public void setFortune()
    {
        myFortunes.add(new Fortunes("There will be a happy romance for you shortly", "\n" +
                "不久你会有一个快乐的浪漫"));
        myFortunes.add(new Fortunes("Good news from afar may bring you a welcome visitor", "\n" +
                "来自远方的好消息可能会带给你一个欢迎的访客"));
        myFortunes.add(new Fortunes("The object of your desire comes closer", "你的欲望的目标更接近\n"));
        myFortunes.add(new Fortunes("Today will be a good day", "Today is a good day"));
        myFortunes.add(new Fortunes("He who slithers among the ground is not always a foe.", "\n" +
                "在地面上徘徊的人并不总是敌人"));
        myFortunes.add(new Fortunes("It is not necessary to show others you have change; the change will be obvious", "\n" +
                "没有必要向别人展示你有变化;变化将是显而易见的"));
        myFortunes.add(new Fortunes("You will recieve some high prize or award", "您将获得一些高奖或奖励\n"));
        myFortunes.add(new Fortunes("Your wish will come true", "你的愿望会成真"));
        myFortunes.add(new Fortunes("The cooler you think you are the dumber you look", "你认为你是你看起来很笨重的冷却器"));
        myFortunes.add(new Fortunes("Patience is key, a wait short or long will have its reward", "耐心是关键，等待很短或长久会有奖励"));
        myFortunes.add(new Fortunes("Be assertive when decisive action is needed", "在需要果断行动时坚持自信"));
        myFortunes.add(new Fortunes("Sing and rejoice, fortune is smiling on you", "唱歌欢乐，财富对你微笑"));
        myFortunes.add(new Fortunes("The smart thing to do is to begin trusting your intuitions", "聪明的事情是开始相信你的直觉\n"));

    }

    public String printFortune()
    {
        setFortune();
        Random ranNum = new Random();
        int index = ranNum.nextInt(myFortunes.size());
        return myFortunes.get(index).getRandomFortune();

    }

}
