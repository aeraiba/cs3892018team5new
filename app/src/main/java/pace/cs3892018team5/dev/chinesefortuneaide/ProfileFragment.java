package pace.cs3892018team5.dev.chinesefortuneaide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inf, ViewGroup vg, Bundle b){

        View v = inf.inflate(R.layout.profile, null);
        Score s = Score.get(getContext());
        ((TextView)v.findViewById(R.id.score)).setText(s.getScore()+"");
        ((RatingBar)v.findViewById(R.id.rating)).setRating(s.getRating());
        return v;
    }
}
