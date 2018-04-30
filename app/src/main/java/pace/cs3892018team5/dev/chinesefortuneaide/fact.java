package pace.cs3892018team5.dev.chinesefortuneaide;

/**
 * Created by johnnychen on 2018/4/16.
 */

public class fact {
    String fact;
    int image;

    public fact(String fact, int image) {
        this.fact = fact;
        this.image = image;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
