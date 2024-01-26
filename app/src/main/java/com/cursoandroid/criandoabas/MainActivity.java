package com.cursoandroid.criandoabas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.cursoandroid.criandoabas.Fragment.EmAltaFragment;
import com.cursoandroid.criandoabas.Fragment.HomeFragment;
import com.cursoandroid.criandoabas.Fragment.InscricoesFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {
    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewpagertab);
        viewPager = findViewById(R.id.viewpager);

        //recupera o objeto da action bar
        getSupportActionBar().setElevation(0);

        // Configurar adapter para as abas
        FragmentPagerAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), // recupera o fragment manager
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class )// Nome e qual fragment é
                        .add("Inscrições", InscricoesFragment.class)// adiciona as abas
                        .add("Em alta", EmAltaFragment.class)// adiciona as abas
                .create()
        );

        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}
