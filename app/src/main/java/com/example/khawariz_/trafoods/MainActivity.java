package com.example.khawariz_.trafoods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public DataAdapter dataAdapter;
    public RecyclerView recyclerView;
    public ArrayList<DataModel> dataModelArrayList=new ArrayList<DataModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputData("Babat Gongso","artikel_1.html");
        inputData("Garang Asem","artikel_2.html");
        inputData("Lumpia","artikel_3.html");
        inputData("Mie Kopyok","artikel_4.html");
        inputData("Soto Bangkong","artikel_5.html");
        inputData("Kue Spekuk","artikel_6.html");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        dataAdapter = new DataAdapter (this,dataModelArrayList);
        recyclerView.setAdapter(dataAdapter);

        DataModel headerModel = new DataModel();
        headerModel.setViewType(2);
        dataModelArrayList.add(0,headerModel);

        DataModel footerModel = new DataModel();
        footerModel.setViewType(3);
        dataModelArrayList.add(footerModel);
    }

    public void inputData(String judul,String konten){
        DataModel dataModel = new DataModel();
        dataModel.setJudul(judul);
        dataModel.setKonten(konten);
        dataModel.setViewType(1);
        dataModelArrayList.add(dataModel);
    }

}