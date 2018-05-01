package pace.cs3892018team5.dev.chinesefortuneaide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    private LinearLayout starCont;

    @Override
    public View onCreateView(LayoutInflater inf, ViewGroup vg, Bundle b){

        View v = inf.inflate(R.layout.profile, null);
        Score s = Score.get(getContext());
        ((TextView)v.findViewById(R.id.score)).setText(s.getScore()+"");
        starCont = v.findViewById(R.id.star_cont);
        addRating(s.getRating());
        return v;
    }

    private void addRating(int rating){
        starCont.removeAllViews();
        for(int i=0;i<rating;i++){
            ImageView im = new ImageView(getContext());
            im.setImageResource(R.mipmap.star);
            im.setPadding(10,0,0,0);
            starCont.addView(im);
        }
    }
}
