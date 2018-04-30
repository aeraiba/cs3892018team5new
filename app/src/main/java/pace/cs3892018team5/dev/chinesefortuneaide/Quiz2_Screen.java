package pace.cs3892018team5.dev.chinesefortuneaide;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.FirebaseDatabase;

public class Quiz2_Screen extends AppCompatActivity {

    private TextView mScoreView;
    private TextView mQuestion;
    private ImageView mImage;

    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4 ;
    private ImageButton mplay;

    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String mAnswer, mAudio;
    private Score score;


    private Firebase mQuestionRef, mChoice1Ref, mChoice2Ref, mChoice3Ref, mChoice4Ref, mAnswerRef, imageRef, audioRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_quiz2__screen);
        score = Score.get(this);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestion = (TextView) findViewById(R.id.question);
        mImage = findViewById(R.id.image);

        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        mplay = findViewById(R.id.play);


        updateQuestion();
        setupEndActivityButton();

        //Button 1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice1.getText().equals(mAnswer)) {

                    mScore = mScore +1;
                    score.add(mQuestionNumber, true);
                    updateScore(mScore);
                    updateQuestion();
                } else {
                    score.add(mQuestionNumber, false);
                    updateQuestion();
                }
            }
        });

        //Button 2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice2.getText().equals(mAnswer)) {
                    score.add(mQuestionNumber, true);
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                } else {
                    score.add(mQuestionNumber, false);
                    updateQuestion();
                }
            }
        });

        //Button 3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice3.getText().equals(mAnswer)) {
                    score.add(mQuestionNumber, true);
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                } else {
                    score.add(mQuestionNumber, false);
                    updateQuestion();
                }
            }
        });

        //Button 4
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mButtonChoice4.getText().equals(mAnswer)) {
                    score.add(mQuestionNumber, true);
                    mScore = mScore + 1;
                    updateScore(mScore);
                } else {
                    score.add(mQuestionNumber, false);
                    score.save();
                }
            }

        });

        mplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAudio!=null){
                    MediaPlayer mp = MediaPlayer.create(Quiz2_Screen.this, getResources().getIdentifier(mAudio,"raw", getPackageName()));

                        mplay.setVisibility(View.INVISIBLE);
                        mp.start();
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mplay.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                }

        });
    }





    private void updateScore(int score) {
        mScoreView.setText(" " + mScore);
    }

    private void updateQuestion() {

        mplay.setVisibility(View.INVISIBLE);
        score.save();

        mQuestionRef = new Firebase("https://cs389firebaseproject.firebaseio.com/" + mQuestionNumber + "/question");
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
        mChoice1Ref = new Firebase("https://cs389firebaseproject.firebaseio.com/" + mQuestionNumber + "/choice1");
        mChoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice2Ref = new Firebase("https://cs389firebaseproject.firebaseio.com/" + mQuestionNumber + "/choice2");
        mChoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice3Ref = new Firebase("https://cs389firebaseproject.firebaseio.com/" + mQuestionNumber + "/choice3");
        mChoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice4Ref = new Firebase("https://cs389firebaseproject.firebaseio.com/" + mQuestionNumber + "/choice4");
        mChoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice4.setText(choice);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mAnswerRef = new Firebase("https://cs389firebaseproject.firebaseio.com/"+ mQuestionNumber +"/answer");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        imageRef = new Firebase("https://cs389firebaseproject.firebaseio.com/"+ mQuestionNumber +"/image");
        imageRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String image = dataSnapshot.getValue(String.class);

                    if(image!=null)
                        mImage.setImageResource(getResources().getIdentifier(image, "mipmap", getPackageName()));
                    else
                        mImage.setImageDrawable(null);
                }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        audioRef = new Firebase("https://cs389firebaseproject.firebaseio.com/"+ mQuestionNumber +"/audio");
        audioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAudio = dataSnapshot.getValue(String.class);
                if(mAudio!=null) mplay.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        if (mQuestionNumber == 4) {

            Intent i = new Intent(Quiz2_Screen.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("finalScore", mScore);
            i.putExtras(bundle);
            Quiz2_Screen.this.finish();
            startActivity(i);
        }

        mQuestionNumber++;

    }
    //back to fragment button


    private void setupEndActivityButton(){
        Button btn = (Button) findViewById(R.id.quit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }

        });
    }

}