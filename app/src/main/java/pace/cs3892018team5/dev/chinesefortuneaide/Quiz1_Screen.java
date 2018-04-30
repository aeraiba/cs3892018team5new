package pace.cs3892018team5.dev.chinesefortuneaide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import static pace.cs3892018team5.dev.chinesefortuneaide.R.id.btnFalse;

public class Quiz1_Screen extends AppCompatActivity {

    private TextView mScoreView;
    private TextView mQuestion;

    public Button myButtonTrue, myButtonFalse;

     private int mScore = 0;
     private String mAnswer;
     private int mQuestionNumber = 4;

    public Firebase mQuestionRef, mChoice1Ref, mChoice2Ref,mAnswerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_quiz1__screen);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         //setSupportActionBar(toolbar);

        mScoreView = (TextView)findViewById(R.id.score1);
        mQuestion = (TextView)findViewById(R.id.question1);

        myButtonTrue = (Button)findViewById(R.id.btnTrue);
        myButtonFalse = (Button)findViewById(R.id.btnFalse);


        updateQuestion();
        //Button 1
        myButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myButtonTrue.getText().equals(mAnswer)){

                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });

        //Button 2
        myButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myButtonFalse.getText().equals(mAnswer)){

                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });



    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
        //String temp = mScore + "";
       // mScoreView.setText(temp);
    }

    public void updateQuestion() {
        mQuestionRef = new Firebase("https://cs389firebaseproject.firebaseio.com/" + mQuestionNumber + "/questione");
        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                mQuestion.setText(question);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mChoice1Ref = new Firebase("https://cs389firebaseproject.firebaseio.com/" + mQuestionNumber + "/choice1e");
        mChoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                myButtonTrue.setText(choice);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice2Ref = new Firebase("https://cs389firebaseproject.firebaseio.com/" + mQuestionNumber + "/choice2e");
        mChoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                myButtonFalse.setText(choice);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mAnswerRef = new Firebase("https://cs389firebaseproject.firebaseio.com/" + mQuestionNumber + "/answere");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        if (mQuestionNumber == 7) {

            Intent i = new Intent(Quiz1_Screen.this, ResultActivity2.class);
            Bundle bundle = new Bundle();
            bundle.putInt("finalScore", mScore);
            i.putExtras(bundle);
            Quiz1_Screen.this.finish();
            startActivity(i);
        }
        mQuestionNumber++;





    }
}