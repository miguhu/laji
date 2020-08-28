package com.example.lzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Bfragment extends Fragment {
    private TextView mTvTitle;
    private Button btn_photo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        btn_photo= (Button)view.findViewById(R.id.btn_photo);
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), Saoyisao.class);
                startActivity(i);
            }
        });
        return view;
    }



    @Override
            public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
                super.onViewCreated(view, savedInstanceState);
            }

    }
