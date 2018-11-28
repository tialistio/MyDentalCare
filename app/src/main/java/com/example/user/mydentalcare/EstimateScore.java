package com.example.user.mydentalcare;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

public class EstimateScore extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimatescore);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Estimate My Score");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_activity, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //show the question detail

    public void ShowDetail(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(EstimateScore.this);
        builder1.setCancelable(true);
        AlertDialog alertDialog;

        builder1.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        switch (v.getId()){
            case R.id.tv_detail1:
                builder1.setMessage("If all of your teeth are missing, you are no longer at risk for tooth decay or gum disease but you should still have dental check ups to observe your lips, cheeks, tongue, floor of the mouth and other soft tissues for signs of oral cancer or other sores that can develop at these sites.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail2:
                builder1.setMessage("A past history of fillings or crowns (caps) is often the best predictor for future needs. No dental restoration is permanent. The life expectancy of a filling or crown depends on many factors including diet, oral hygiene practices, and oral habits like bruxing, grinding, ice chewing or other possibly destructive oral habits.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
        }
    }
}
