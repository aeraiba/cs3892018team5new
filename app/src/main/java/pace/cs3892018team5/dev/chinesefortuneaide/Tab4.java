package pace.cs3892018team5.dev.chinesefortuneaide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Tab4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab4.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab4 newInstance(String param1, String param2) {
        Tab4 fragment = new Tab4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab4, container, false);
        ListView listFact = view.findViewById(R.id.list_fact);

        ArrayList<fact> factArrayList = new ArrayList<>();

        factArrayList.add(new fact("China has great physical diversity. The eastern plains and southern coasts of the country consist of fertile lowlands and foothills and is the location of most of China's agricultural output and human population. The southern areas of the country (South of the Yangtze River) consist of hilly and mountainous terrain. The west and north of the country are dominated by sunken basins (such as the Gobi and the Taklamakan), rolling plateaus, and towering massifs. It contains part of the highest tableland on earth, the Tibetan Plateau, and has much lower agricultural potential and population.", R.mipmap.chinese_map));
        factArrayList.add(new fact("The Spring Festival falls on the 1st day of the 1st lunar month, often one month later than the Gregorian calendar. It originated in the Shang Dynasty (c. 1600 BC-c. 1100 BC) from the people's sacrifice to gods and ancestors at the end of an old year and the beginning of a new one.", R.mipmap.spring_festival));
        factArrayList.add(new fact("The Duanwu Festival, also often known, especially in the West, as the Dragon Boat Festival, is a traditional holiday originating in China, occurring near the summer solstice. It is also known as Zhongxiao Festival (Chinese: 忠孝節; pinyin: Zhōngxiàojié), commemorating fealty and filial piety. The festival now occurs on the 5th day of the 5th month of the traditional Chinese calendar, which is the source of the festival's alternative name, the Double Fifth Festival",R.mipmap.dragon_boat));
        factArrayList.add(new fact("Chinese people celebrate the festival with many traditional and meaningful activities, such as eating dinner with family, hanging lanterns, guessing lantern riddles, and worshipping the moon. Since 2008, the festival has been a 3-day public holiday in mainland China. In 2018, the holiday will be September 24–6, combining the National Day holiday and a three weekend days.", R.mipmap.moon_cake));
        factArrayList.add(new fact("As the landmark of Guangzhou, the Canton Tower (Guangzhou Tower) lies at the south bank of the Pearl River, facing Haixinsha Island to the north. As the highest TV tower in China and the third highest in the world, the tower has been a must-see scenic spot in Guangzhou. From the top, visitors have a birds-eye view of the whole city. Inside the tower are wonderful entertainment items, romantic restaurants with delicious food and several fine lookout platforms for shooting photos, some of them holding many top world records.", R.mipmap.canton_tower));
        factArrayList.add(new fact("In the Chinese language the word tao means \"way,\" indicating a way of thought or life. There have been several such ways in China's long history, including Confucianism and Buddhism. In about the 6th century BC, under the influence of ideas credited to a man named Lao-tzu, Taoism became \"the way\". like Confucianism, it has influenced every aspect of Chinese culture.", R.mipmap.bagua));
        factArrayList.add(new fact("Confucius was China’s most famous Philosopher. He lived in Ancient China during the Zhou Dynasty. Confucius was a government official, and during his lifetime (he lived from 551 to 479 B.C. ) he saw growing disorder and chaos in the system. Perhaps due to the turmoil and injustices he saw, he set himself to develop a new moral code based on respect, honesty, education, kindness and strong family bonds. His teachings later became the basis for religious and moral life throughout China. ", R.mipmap.kongzi));
        factArrayList.add(new fact("In the winter season, when chilly temperatures and frigid winds   prevail over the land, people like to eat food that instantly warms their bodies and lifts their spirits. For that, the hot pot is a delicious and hearty choice. Families or groups of friends sit around a table and eat from a steaming pot in the middle, cooking and drinking and chatting. Eating hot  pot is not a passive activity: diners must select morsels of prepared raw food from plates scattered around the table, place them in the pot, wait for them to cook, fish them out of the soup, dip them in the preferred sauce, and then eat them hot", R.mipmap.hotpot));
        factArrayList.add(new fact("Written Chinese (Chinese: 中文; pinyin: zhōngwén) comprises Chinese characters (汉字/漢字; pinyin: Hànzì, literally \"Han characters\") used to represent the Chinese language. Chinese characters do not constitute an alphabet or a compact syllabary. Rather, the writing system is roughly logosyllabic; that is, a character generally represents one syllable of spoken Chinese and may be a word on its own or a part of a polysyllabic word. ", R.mipmap.handwrite));


        FactListAdapter adapter = new FactListAdapter(getActivity().getApplicationContext(), R.layout.adapter_fact, factArrayList);

        listFact.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
