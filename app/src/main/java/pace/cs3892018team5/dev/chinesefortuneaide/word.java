package pace.cs3892018team5.dev.chinesefortuneaide;

/**
 * Created by johnnychen on 2018/4/16.
 */

public class word {
    private String CHS;
    private String ENG;

    public word(String CHS, String ENG) {
        this.CHS = CHS;
        this.ENG = ENG;
    }

    public String getCHS() {
        return CHS;
    }

    public void setCHS(String CHS) {
        this.CHS = CHS;
    }

    public String getENG() {
        return ENG;
    }

    public void setENG(String ENG) {
        this.ENG = ENG;
    }
}
