package com.example.ru_itech.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ru_itech.About;
import com.example.ru_itech.Profile;
import com.example.ru_itech.R;
import com.example.ru_itech.Resources;
import com.example.ru_itech.Structure.RecyclerStructure;
import com.example.ru_itech.adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements View.OnClickListener {

    RecyclerView recycler;
    View v;
    Context mcontext;
    ImageView profile,resources;
    CardView about;


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mcontext = container.getContext();
        v= inflater.inflate(R.layout.fragment_home, container, false);

        profile = v.findViewById(R.id.profile);
        resources = v.findViewById(R.id.resources);
        about = v.findViewById(R.id.about);

        profile.setOnClickListener(this);
        resources.setOnClickListener(this);
        about.setOnClickListener(this);

        //loading data to the recycler view
        loadData();
        return v;
    }



    public void loadData(){

        recycler = v.findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mcontext);
        recycler.setLayoutManager(layoutManager);

        List<RecyclerStructure> myItems = new ArrayList<>();
      //  myItems.add(new RecyclerStructure(R.drawable.test2,"test description","12.3.2019","Nairobi"));
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));
        myItems.add(new RecyclerStructure(R.drawable.testimage,"test description","12.3.2019","Nairobi"));


        RecyclerAdapter adapter = new RecyclerAdapter(mcontext,myItems);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        Intent i ;

        switch (v.getId()){

            case R.id.profile:
                i = new Intent(mcontext, Profile.class);
                startActivity(i);
                break;
            case R.id.resources:
                i = new Intent(mcontext, Resources.class);
                startActivity(i);
                break;
            case R.id.about:
                i = new Intent(mcontext, About.class);
                startActivity(i);
                break;
        }

    }
}
