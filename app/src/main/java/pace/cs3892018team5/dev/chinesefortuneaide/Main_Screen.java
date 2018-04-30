package pace.cs3892018team5.dev.chinesefortuneaide;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TableLayout;

public class Main_Screen extends AppCompatActivity implements  Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener, Tab4.OnFragmentInteractionListener, Tab5.OnFragmentInteractionListener{
    //public static int SPLASH_TIME_OUT = 4000;

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen);
       // new Handler().postDelayed(new Runnable() {
         //   @Override
        //    public void run() {
              //  Intent homeIntent = new Intent(Main_Screen.this, HomeActivity.class);
              //  startActivity(homeIntent);
                //finish();
           // }
       // }, SPLASH_TIME_OUT);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.profile_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.fortune_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.han_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.book_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.quiz_icon));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
