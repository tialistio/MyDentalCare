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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class EstimateScore extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button next;
    public static int totalscore = 0;
    private Spinner spinnerage;
    private static final String[] paths = {"20-29","30-39","40-49","50-59","60-69",">70"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimatescore);

        //Set the Age Spinner
        spinnerage = (Spinner)findViewById(R.id.spiner_age);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(EstimateScore.this, android.R.layout.simple_spinner_item, paths);
        spinnerage.setAdapter(adapter);
        spinnerage.setOnItemSelectedListener(this);
        //----------------------------------------------------------

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Estimate My Score");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        next = (Button)findViewById(R.id.bt_estimate_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EstimateScore.this, EstimateScore2.class);
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

    //show the question detail

    public void ShowDetail(View v) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(EstimateScore.this);
        builder1.setCancelable(true);
        AlertDialog alertDialog;

        builder1.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        switch (v.getId()) {
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
            case R.id.tv_detail3:
                builder1.setMessage("Missing teeth due to disease are often an indicator for higher future disease risk.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail4:
                builder1.setMessage("Tooth pain when exposed to hot or cold or when chewing may be a sign of tooth decay.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
           case R.id.tv_detail5:
                builder1.setMessage("Sugary or starchy snacks and beverages include candy, cookies, baked goods, chips, cereals, crackers, bread, soda, energy or sport drinks, fruit juices, or chewing gum containing sugar.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail6:
                builder1.setMessage("Routine dental check-ups are the best way to detect oral health problems before they become serious. The frequency of visits depends on your level of risk for various oral health conditions. Once a year is usually adequate for those at low risk of oral diseases but check with your dentist for what is best for you.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail7:
                builder1.setMessage("Normal saliva production is critical to protect your teeth from the risk of tooth decay. Dry mouth can happen to anyone occasionally, such as when you're nervous or dehydrated. If the condition persists, there are a number of potential causes. Illnesses such as diabetes, Parkinson's disease and Sjogren's syndrome can affect the salivary glands. Cancer treatments, particularly radiation to the head and neck and many types of chemotherapy can damage the salivary glands and cause dry mouth. Over 400 medications interfere with the body's natural ability to produce saliva. These include medications for such common conditions as high blood pressure, diabetes, asthma, allergies, anxiety and depression, among others. Depending on the cause of your dry mouth, your health care provider can recommend appropriate treatment.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail8:
                builder1.setMessage("People that undergo major health changes often neglect their oral health while undergoing life-saving or life-changing therapy for their disease. They may also begin taking medications that cause dry mouth. Your risk for tooth decay can increase dramatically after these life-changing events. Check with your dentist for guidance.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
            case R.id.tv_detail9:
                builder1.setMessage("When you are asleep, you are swallowing much less than when you are awake. This means that your body does not need to produce nearly as much saliva as it does when you are awake. If there is sugar for the bacteria in your mouth to feed off of during this time, the risk of the acids eating away at your enamel is much greater. When you brush your teeth before going to bed, you minimize this risk quite a bit.");
                alertDialog = builder1.create();
                alertDialog.show();
                break;
        }

    }
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
