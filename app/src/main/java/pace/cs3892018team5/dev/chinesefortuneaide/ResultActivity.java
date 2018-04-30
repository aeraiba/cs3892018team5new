package pace.cs3892018team5.dev.chinesefortuneaide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView mGrade, mFinalScore;
    Button mRetryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = findViewById(R.id.outOf);
        mRetryButton = findViewById(R.id.retry);
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        mFinalScore.setText("You scored " + score + " out of 4" );

        if (score == 4){
            mGrade.setText("Outstanding");
        }else if (score == 3){
            mGrade.setText("Good Work");
        }else if (score == 2) {
            mGrade.setText("Good Effort");
        }else {
            mGrade.setText("Go over your notes");
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultActivity.this, Quiz2_Screen.class));
                ResultActivity.this.finish();
            }
        });
    }
}

