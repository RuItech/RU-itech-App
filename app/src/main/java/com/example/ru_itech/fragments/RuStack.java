package com.example.ru_itech.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ru_itech.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RuStack extends Fragment {


    public RuStack() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ru_stack, container, false);

    }

}
