package com.example.metroadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
Button btn;
String[] host = {"Aluva", "Pulinchodu","Companypadi","Ambattukav","Muttom","Kalamassery","Cusat","Pathadipalam","Edapally","Changampuzha Park","Palarivattom","J. L. N. Stadium","Kaloor","Town Hall","M. G. Road","Maharaja's College","Ernakulam South","Kadavanthra","Elamkulam","Vyttila","Thaikoodam"};
Spinner station;
String strtstation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        station = findViewById(R.id.gender);
        station.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, host);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        station.setAdapter(aa);
        btn=findViewById(R.id.button);
        switch(station.getSelectedItem().toString()) {
            case "Aluva":
                strtstation="ALV";
                break;
            case "Pulinchodu":
                strtstation="PLD";
                break;
            case "Companypadi":
                strtstation="CPD";
                break;
            case "Ambattukav":
                strtstation="AMK";
                break;
            case "Muttom":
                strtstation="MTM";
                break;
            case "Kalamassery":
                strtstation="KLM";
                break;
            case "Cusat":
                strtstation="CST";
                break;
            case "Pathadipalam":
                strtstation="PTP";
                break;
            case "Edapally":
                strtstation="EDP";
                break;
            case "Changampuzha Park":
                strtstation="CHP";
                break;
            case "Palarivattom":
                strtstation="PLV";
                break;
            case "J. L. N. Stadium":
                strtstation="JLN";
                break;
            case "Kaloor":
                strtstation="KLR";
                break;
            case "Town Hall":
                strtstation="THL";
                break;
            case "M. G. Road":
                strtstation="MGR";
                break;
            case "Maharaja's College":
                strtstation="MHC";
                break;
            case "Ernakulam South":
                strtstation="ELS";
                break;
            case "Kadavanthra":
                strtstation="KDV";
                break;
            case "Elamkulam":
                strtstation="ELK";
                break;
            case "Vyttila":
                strtstation="VYT";
                break;
            case "Thaikoodam":
                strtstation="THM";
                break;
            default:
                strtstation="000000";
                break;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,strtstation,Toast.LENGTH_LONG).show();
                Intent iore=new Intent(getApplicationContext(),Scanner.class);
                iore.putExtra("Station",strtstation);
                startActivity(iore);
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        Toast.makeText(MainActivity.this,"Host Station Not Selected",Toast.LENGTH_SHORT).show();


    }

}

