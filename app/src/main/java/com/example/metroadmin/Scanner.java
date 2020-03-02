package com.example.metroadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Scanner extends AppCompatActivity {
    Intent i;
    String stnid,ticketid;
    IntentIntegrator qrscan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        i=getIntent();
        stnid=i.getStringExtra("Station");
        Toast.makeText(Scanner.this,stnid,Toast.LENGTH_LONG).show();
        qrscan = new IntentIntegrator(this);
        qrscan.initiateScan();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents().substring(0,3).equals(stnid)) {
                Toast.makeText(this, "GATES OPENING", Toast.LENGTH_LONG).show();
            } else {
                  Toast.makeText(this,"WRONG STATION",Toast.LENGTH_LONG).show();
                }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
