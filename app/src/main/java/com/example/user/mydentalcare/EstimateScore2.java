package com.example.user.mydentalcare;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

public class EstimateScore2 extends AppCompatActivity {

    public static int totalscore2 = 0;
    public static int radioButtonID = 0;
    public static int selectedId = 0;
    public static String selected ="";
    View radioButton ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimatescore2);

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

    public void ShowDetail(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(EstimateScore2.this);
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
                builder1.setMessage("Periodontal (gum) disease is a common problem with the mouth, and bleeding when brushing can be one of the first signs. Gum disease is caused by bacteria that infect the gums. The mildest form of gum disease is called gingivitis and usually causes the gums to bleed easily when brushed. Start brushing and flossing properly every day and this will typically clear up on its own within a week or so. If left alone, early, easy to treat gum problems can lead to swollen, sore gums, bone loss, loose teeth, and a much more difficult problem to treat.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;

        }
    }

    public void ButtonOnclick (View view){
        switch (view.getId()){
            case R.id.bt_estimate2_prev:
                Intent intent = new Intent(EstimateScore2.this, EstimateScore.class);
                startActivity(intent);
                break;

        }
    }
}
