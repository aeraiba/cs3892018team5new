package pace.cs3892018team5.dev.chinesefortuneaide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;


public class HomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Handler handler = new Handler ();
        handler.postDelayed(new Runnable() {
            @Override
            public void run () {
                startActivity(new Intent(HomeActivity.this, Main_Screen.class));
                finish();
            }
        }, 4000);
    }
}
