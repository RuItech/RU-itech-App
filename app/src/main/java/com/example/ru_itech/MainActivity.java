package com.example.ru_itech;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ru_itech.Structure.RecyclerStructure;
import com.example.ru_itech.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        List<RecyclerStructure> myItems = new ArrayList<>();
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));


        RecyclerAdapter adapter = new RecyclerAdapter(this,myItems);
        recycler.setAdapter(adapter);

        }

}
