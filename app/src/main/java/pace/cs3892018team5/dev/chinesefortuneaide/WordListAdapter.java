package pace.cs3892018team5.dev.chinesefortuneaide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnnychen on 2018/4/16.
 */

public class WordListAdapter extends ArrayAdapter<word> {
    private Context mContext;
    int mResource;

    public WordListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<word> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String CHS = getItem(position).getCHS();
        String ENG = getItem(position).getENG();

        word word = new word(CHS,ENG);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvCHS = (TextView) convertView.findViewById(R.id.CHS);
        TextView tvENG = (TextView) convertView.findViewById(R.id.ENG);

        tvCHS.setText(CHS);
        tvENG.setText(ENG);

        return convertView;
    }
}
