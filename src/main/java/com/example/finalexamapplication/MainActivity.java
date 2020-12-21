package com.example.finalexamapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner country;
    ListView lv;
    TextView capitalcity,totalAmount;
    public static double grandTotal=0;
    public static String name="";
    ArrayList<Places> placeList = new ArrayList<>();
    public static ArrayList<Places>tempList = new ArrayList<>();
    String cats[]={"Canada","USA","England"};
    private AdapterView<Adapter> add;

    public void fillData(){
    placeList.add(new Places(cats[0],"ottawa","Niagara falls", 100, "niagara"));
        placeList.add(new Places(cats[0],"ottawa","CN tower", 30, "cntower"));
        placeList.add(new Places(cats[0],"ottawa","The Butchart Gardens", 30, "butchart"));
        placeList.add(new Places(cats[0],"ottawa","Norte Dame Basilica", 50, "notredame"));
        placeList.add(new Places(cats[1],"Washington","Statue of Liberty", 90, "liberty"));
        placeList.add(new Places(cats[1],"Washington","White House", 60, "whitehouse"));
        placeList.add(new Places(cats[1],"Washington","Times Square", 75, "timessquare"));
        placeList.add(new Places(cats[2],"London","Big Ben", 30, "bigben"));
        placeList.add(new Places(cats[2],"London","Westminster Abbey", 25, "abbey"));
        placeList.add(new Places(cats[2],"London","Hyde Park", 15, "hyde"));
    }
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillData();
        country=findViewById(R.id.spCountry);
        lv=findViewById(R.id.placesLV);
        capitalcity=findViewById(R.id.capitalText);
        totalAmount=findViewById(R.id.totalPrice);
        totalAmount.setText(String.format("%.2f",grandTotal));


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,cats);
        country.setAdapter(aa);
        country.setOnItemSelectedListener(this);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                grandTotal = tempList.get(i).getPrice();
                name=tempList.get(i).getCountry();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (grandTotal ==0)
                    Toast.makeText(getApplicationContext(),"Please select a country",Toast.LENGTH_LONG).show();
                else{
                    int itemQty = Integer.parseInt(capitalcity.getText().toString());
                    double total = grandTotal*itemQty*0.15;
                    grandTotal+=total;
                    totalAmount.setText(String.format("%.2f",grandTotal)); }
            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        tempList.clear();
        fillTempList(cats[i]);

        lv.setAdapter(new PlacesAdapter(this,tempList));
    }

    private void fillTempList(String cat) {
        for(int i=0;i<placeList.size();i++)
            if(cat.equals(placeList.get(i).country))
                tempList.add(placeList.get(i));
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}