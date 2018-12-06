package com.example.user.mydentalcare;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.user.mydentalcare.EstimateScore2.totalscore2;

public class Result extends AppCompatActivity {

    ImageView disease_risk_iv;
    ImageView disease_score_iv;
    TextView disease_risk_tv;
    TextView disease_score_tv;
    String score_img = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //setting toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Result");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //-----------------------------------------------

        disease_risk_iv = (ImageView)findViewById(R.id.iv_disease_risk);
        disease_risk_tv = (TextView)findViewById(R.id.tv_disease_risk);
        disease_score_iv = (ImageView)findViewById(R.id.iv_disease_score);
        disease_score_tv = (TextView)findViewById(R.id.tv_disease_score);

        if(totalscore2<10){
            score_img = "report_1";
        }

        disease_risk_iv.setImageResource(R.drawable.report_1);
        disease_risk_tv.setText(R.string.low_risk);
        disease_score_iv.setImageResource(R.drawable.report_1);
        disease_score_tv.setText(R.string.healty_gum);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_activity, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(Result.this, HomeActivity.class);
        startActivity(intent);
        return true;
    }

    public void showdetailss(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(Result.this);
        builder1.setCancelable(true);
        AlertDialog alertDialog;

        builder1.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        switch (v.getId()){
            case R.id.ib_detail1:
                builder1.setMessage(R.string.disease_risk_detail);
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.ib_detail2:
                builder1.setMessage(R.string.disease_score_detail);
                alertDialog = builder1.create();
                alertDialog.show();
                break;
        }
    }
}
