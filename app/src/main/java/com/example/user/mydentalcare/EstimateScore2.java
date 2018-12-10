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
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.ScrollView;

public class EstimateScore2 extends AppCompatActivity {


    public static ScrollView scrollView2;
    public static int totalscore2 = 0;
    public static int radioButtonID = 0;
    public static int selectedId = 0;
    public static String selected ="";
    View radioButton ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimatescore2);

        scrollView2 = (ScrollView)findViewById(R.id.scroll2);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Estimate My Score");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button next = (Button)findViewById(R.id.bt_estimate2_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gettotalscore();
                Intent intent = new Intent(EstimateScore2.this, Result.class);
                startActivity(intent);

            }
        });
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

    public void ShowDetails(View v){
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
            case R.id.tv_detail2:
                builder1.setMessage("When periodontal (gum) disease progresses past the early, easily treated stage, surgery is often necessary to correct problems related to loss of the supporting bone and gum tissues.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail3:
                builder1.setMessage("Sugary or starchy snacks and beverages include candy, cookies, baked goods, chips, cereals, crackers, bread, soda, energy or sport drinks, fruit juices, or chewing gum containing sugar.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail4:
                builder1.setMessage("Routine dental check-ups are the best way to detect oral health problems before they become serious. The frequency of visits depends on your level of risk for various oral health conditions. Once a year is usually adequate for those at low risk of oral diseases but check with your dentist for what is best for you.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail5:
                builder1.setMessage("There are a number of risk factors for gum disease, but smoking is one of the most significant. In fact, smoking can even lower the chances of successful treatment. The severity of gum disease and how well it responds to treatment is related to other key disease modifying factors including diabetes and genetics.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail6:
                builder1.setMessage("Normal saliva production is critical to protect your teeth from the risk of tooth decay. Dry mouth can happen to anyone occasionally, such as when you're nervous or dehydrated. If the condition persists, there are a number of potential causes. Illnesses such as diabetes, Parkinson's disease and Sjogren's syndrome can affect the salivary glands. Cancer treatments, particularly radiation to the head and neck and many types of chemotherapy can damage the salivary glands and cause dry mouth. Over 400 medications interfere with the body's natural ability to produce saliva. These include medications for such common conditions as high blood pressure, diabetes, asthma, allergies, anxiety and depression, among others. Depending on the cause of your dry mouth, your health care provider can recommend appropriate treatment.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail7:
                builder1.setMessage("There are a number of risk factors for gum disease, but smoking is one of the most significant. In fact, smoking can even lower the chances of successful treatment. The severity of gum disease and how well it responds to treatment is related to other key disease modifying factors including diabetes and genetics.");
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

    public void gettotalscore(){
        RadioGroup rg2_1 = (RadioGroup)findViewById(R.id.rg2_1);
        radioButtonID = rg2_1.getCheckedRadioButtonId();
        radioButton = rg2_1.findViewById(radioButtonID);
        selectedId = rg2_1.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

        RadioGroup rg2_2 = (RadioGroup)findViewById(R.id.rg2_2);
        radioButtonID = rg2_2.getCheckedRadioButtonId();
        radioButton = rg2_2.findViewById(radioButtonID);
        selectedId = rg2_2.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

        RadioGroup rg2_4 = (RadioGroup)findViewById(R.id.rg2_4);
        radioButtonID = rg2_4.getCheckedRadioButtonId();
        radioButton = rg2_4.findViewById(radioButtonID);
        selectedId = rg2_4.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

        RadioGroup rg2_5 = (RadioGroup)findViewById(R.id.rg2_5);
        radioButtonID = rg2_5.getCheckedRadioButtonId();
        radioButton = rg2_5.findViewById(radioButtonID);
        selectedId = rg2_5.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

        RadioGroup rg2_6 = (RadioGroup)findViewById(R.id.rg2_6);
        radioButtonID = rg2_6.getCheckedRadioButtonId();
        radioButton = rg2_6.findViewById(radioButtonID);
        selectedId = rg2_6.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

        RadioGroup rg2_7 = (RadioGroup)findViewById(R.id.rg2_7);
        radioButtonID = rg2_7.getCheckedRadioButtonId();
        radioButton = rg2_7.findViewById(radioButtonID);
        selectedId = rg2_7.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

        RadioGroup rg2_8 = (RadioGroup)findViewById(R.id.rg2_8);
        radioButtonID = rg2_8.getCheckedRadioButtonId();
        radioButton = rg2_8.findViewById(radioButtonID);
        selectedId = rg2_8.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

        RadioGroup rg2_9 = (RadioGroup)findViewById(R.id.rg2_9);
        radioButtonID = rg2_9.getCheckedRadioButtonId();
        radioButton = rg2_9.findViewById(radioButtonID);
        selectedId = rg2_9.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

        RadioGroup rg2_10 = (RadioGroup)findViewById(R.id.rg2_10);
        radioButtonID = rg2_10.getCheckedRadioButtonId();
        radioButton = rg2_10.findViewById(radioButtonID);
        selectedId = rg2_10.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

        RadioGroup rg2_11 = (RadioGroup)findViewById(R.id.rg2_11);
        radioButtonID = rg2_11.getCheckedRadioButtonId();
        radioButton = rg2_11.findViewById(radioButtonID);
        selectedId = rg2_11.indexOfChild(radioButton);
        selected = String.valueOf(selectedId);
        sum_score(selectedId);

    }

    public void sum_score(int score){
        totalscore2 = totalscore2 + score;
    }
}
