package com.example.user.mydentalcare;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.user.mydentalcare.EstimateScore2.totalscore2;
import static com.example.user.mydentalcare.EstimateScore2.scrollView2;
import static com.example.user.mydentalcare.EstimateScore.scrollView1;


public class Result extends AppCompatActivity {

    ImageView disease_risk_iv;
    ImageView disease_score_iv;
    TextView disease_risk_tv;
    TextView disease_score_tv;
    String score_img = "";

    //===============email part
    private ScrollView scrollViews1;
    private ScrollView scrollViews2;
    private Button btn;
    public static Bitmap bitScroll1;
    public static Bitmap bitScroll2;
    public File imagePath;
    public File imagePath1;
    public File imagePath2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        System.out.println("Total score = " + totalscore2);

        //==============email part
        scrollViews1 = scrollView1;
        scrollViews2 = scrollView2;
        btn = (Button)findViewById(R.id.SendEmail);

        //check permission
        //Check permissions
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED)) {
            // permissions already given
        } else {
            // request permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
        }
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED)) {
            // permissions already given
        } else {
            // request permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
        }

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build());
        //========================================

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                bitScroll1 = getBitmapFromView(scrollViews1, scrollViews1.getChildAt(0).getHeight(), scrollViews1.getChildAt(0).getWidth());
                bitScroll2 = getBitmapFromView(scrollViews2, scrollViews2.getChildAt(0).getHeight(), scrollViews2.getChildAt(0).getWidth());
                saveBitmap(bitScroll1,"1");
                saveBitmap(bitScroll2,"2");
                shareScreenshot(imagePath1,imagePath2);
            }
        });


        //=======================================================

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
            disease_risk_iv.setImageResource(R.drawable.report_1);
            disease_risk_tv.setText(R.string.low_risk);
            disease_score_iv.setImageResource(R.drawable.report_1);
            disease_score_tv.setText(R.string.healty_gum);
        }
        else if(totalscore2<20){
            score_img = "report_2";
            disease_risk_iv.setImageResource(R.drawable.report_2);
            disease_risk_tv.setText(R.string.medium_risk);
            disease_score_iv.setImageResource(R.drawable.report_2);
            disease_score_tv.setText(R.string.mild_periodontitis);
        }
        else {
            score_img = "report_3";
            disease_risk_iv.setImageResource(R.drawable.report_3);
            disease_risk_tv.setText(R.string.high_risk);
            disease_score_iv.setImageResource(R.drawable.report_3);
            disease_score_tv.setText(R.string.periodontitis);
        }

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
        totalscore2 = 0;
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

    // Save Screenshot Part
    private Bitmap getBitmapFromView(View view, int height, int width) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return bitmap;
    }


    public void saveBitmap(Bitmap bitmap, String number) {
        String mPath = Environment.getExternalStorageDirectory().toString() + "/" + "report"+ number + ".jpeg";
        imagePath = new File(mPath);


        //set the url
        String mPath1 = Environment.getExternalStorageDirectory().toString() + "/" + "report1" + ".jpeg";
        String mPath2 = Environment.getExternalStorageDirectory().toString() + "/" + "report2"+ ".jpeg";
        imagePath1 = new File(mPath1);
        imagePath2 = new File(mPath2);

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(imagePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(getApplicationContext(),imagePath.getAbsolutePath()+"", Toast.LENGTH_LONG).show();
            Log.e("ImageSave", "Saveimage");
        } catch (FileNotFoundException e) {
            Log.e("GREC", e.getMessage(), e);
        } catch (IOException e) {
            Log.e("GREC", e.getMessage(), e);
        }


    }

    /*  Share Screenshot  */
    private void shareScreenshot(File file1, File file2) {
        Uri uri = Uri.fromFile(file1);//Convert file path into Uri for sharing
        Uri uri2 = Uri.fromFile(file2);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.sharing_text));
        intent.putExtra(Intent.EXTRA_STREAM, uri);//pass uri here
        intent.putExtra(Intent.EXTRA_STREAM, uri2);
        startActivity(Intent.createChooser(intent, getString(R.string.share_title)));
    }
}
