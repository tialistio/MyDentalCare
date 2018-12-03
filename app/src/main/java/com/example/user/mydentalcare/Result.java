package com.example.user.mydentalcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.user.mydentalcare.EstimateScore2.totalscore2;

public class Result extends AppCompatActivity {

    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        score = (TextView)findViewById(R.id.tv_result_score);
        score.setText("Score : " + String.valueOf(totalscore2));

    }
}
