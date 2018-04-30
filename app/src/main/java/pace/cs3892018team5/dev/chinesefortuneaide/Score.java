package pace.cs3892018team5.dev.chinesefortuneaide;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import java.util.HashMap;

public class Score {

    private final static String SCORE_PREF_NAME = "scores";

    private HashMap<Integer,Boolean> qaStat = new HashMap<>();
    private transient Context ctx;
    private transient Gson gson = new Gson();

    public static Score get(Context ctx) {
        String scJson = ctx.getSharedPreferences(ctx.getPackageName(), Context.MODE_PRIVATE).getString(SCORE_PREF_NAME, null);
         if (scJson == null)
            return new Score(ctx);

          else{


               Score s = new Gson().fromJson(scJson, Score.class);
            s.ctx = ctx;
            s.gson = new Gson();
            return s;
        }
    }

    private Score(Context ctx){

        this.ctx = ctx;
    }

    public void add(int qid, boolean stat){

        qaStat.put(qid, stat);
    }

    public int getRating(){
        Integer[] keys = qaStat.keySet().toArray(new Integer[]{});

        if(keys.length==0)
            return 0;
          int total = keys.length;
         int correct = 0;
        for(Integer key:keys)
            if(qaStat.get(key)==true)
                correct++;
        return (5/total)*correct;
    }

    public void save(){
          SharedPreferences.Editor editor = ctx.getSharedPreferences(ctx.getPackageName(), Context.MODE_PRIVATE).edit();
        editor.putString(SCORE_PREF_NAME, gson.toJson(this));
        editor.commit();
    }

    public int getScore(){
        Integer[] keys = qaStat.keySet().toArray(new Integer[]{});
        int correct = 0;
        for(Integer key:keys)
            if(qaStat.get(key)==true)
                correct++;
        return correct;
    }
}
