package com.example.lzz;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Afragment aFragment;
    private ImageView btn,btn2,btn3,btn4;
    private Bfragment bFragment ;
    private Cfragment cFragment;
    private Dfragment dFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.image1);
        btn2=findViewById(R.id.image2);
        btn3=findViewById(R.id.image3);
        btn4=findViewById(R.id.image4);
        btn.setImageResource(R.drawable.sousuo1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setImageResource(R.drawable.sousuo2);
                btn2.setImageResource(R.drawable.saoyisao1);
                btn3.setImageResource(R.drawable.nongchang1);
                btn4.setImageResource(R.drawable.wode1);
                if(aFragment == null)
                {
                    aFragment=new Afragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,aFragment).commitAllowingStateLoss();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setImageResource(R.drawable.sousuo1);
                btn2.setImageResource(R.drawable.saoyisao2);
                btn3.setImageResource(R.drawable.nongchang1);
                btn4.setImageResource(R.drawable.wode1);
                if(bFragment == null)
                {
                    bFragment=new Bfragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).commitAllowingStateLoss();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setImageResource(R.drawable.sousuo1);
                btn2.setImageResource(R.drawable.saoyisao1);
                btn3.setImageResource(R.drawable.nongchang2);
                btn4.setImageResource(R.drawable.wode1);
                if(cFragment == null)
                {
                    cFragment=new Cfragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,cFragment).commitAllowingStateLoss();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setImageResource(R.drawable.sousuo1);
                btn2.setImageResource(R.drawable.saoyisao1);
                btn3.setImageResource(R.drawable.nongchang1);
                btn4.setImageResource(R.drawable.wode2);
                if(dFragment == null)
                {
                    dFragment=new Dfragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,dFragment).commitAllowingStateLoss();
            }
        });
        aFragment=new Afragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFragment).commitAllowingStateLoss();
    }


}

