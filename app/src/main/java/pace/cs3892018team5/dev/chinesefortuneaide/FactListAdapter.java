package pace.cs3892018team5.dev.chinesefortuneaide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnnychen on 2018/4/16.
 */

public class FactListAdapter extends ArrayAdapter<fact> {

    private Context mContext;
    int mResource;

    public FactListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<fact> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String fact = getItem(position).getFact();
        int image = getItem(position).getImage();

        fact fact1 = new fact(fact,image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvFact = (TextView) convertView.findViewById(R.id.fact);
        ImageView img = (ImageView) convertView.findViewById(R.id.fact_image);

        tvFact.setMovementMethod(new ScrollingMovementMethod());
        tvFact.setText(fact);
        img.setImageResource(image);

        return convertView;
    }
}
