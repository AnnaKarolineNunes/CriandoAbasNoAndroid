# Criando Abas em apps Android 

## Descrição
Este projeto, desenvolvido em Java, tem como objetivo a implementação de abas em aplicativos Android, proporcionando uma experiência de navegação intuitiva entre diferentes seções. Para alcançar esse propósito, foi utilizada a biblioteca SmartTabLayout
## Funcionalidades
- Navegação entre abas, cada uma com um conteudo distinto

## Passo a passo
Passo 1: Configurar as dependências, no modulo build.gradle. Utilize o link para acessar a bibioteca : https://github.com/ogaclejapan/SmartTabLayout/
    ```

      dependencies {
      implementation fileTree(dir: 'libs', include: ['*.jar'])
      implementation 'androidx.appcompat:appcompat:1.0.2'
      implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
      implementation 'androidx.legacy:legacy-support-v4:1.0.0'
      testImplementation 'junit:junit:4.12'
      androidTestImplementation 'androidx.test.ext:junit:1.1.0'
      androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
  
      // Dependencias para as abas
      implementation 'com.ogaclejapan.smarttablayout:library:2.0.0@aar'
  
      //Optional: see how to use the utility.
      implementation 'com.ogaclejapan.smarttablayout:utils-v4:2.0.0@aar'
  }

Passo 2: Configurar o arquivo XMl para as abas. Adicione este trecho de código no meio do activity_main.xml Antes: 

    ```

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".MainActivity">
       
    </LinearLayout>

Depois:
    ```

        <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".MainActivity">
        <com.ogaclejapan.smarttablayout.SmartTabLayout
            android:id="@+id/viewpagertab"
            android:layout_width="match_parent"
            android:layout_height="48dp"
            app:stl_indicatorAlwaysInCenter="false"
            app:stl_indicatorWithoutPadding="false"
            app:stl_indicatorInFront="false"
            app:stl_indicatorInterpolation="smart"
            app:stl_indicatorGravity="bottom"
            app:stl_indicatorColor="#40C4FF"
            app:stl_indicatorThickness="4dp"
            app:stl_indicatorWidth="auto"
            app:stl_indicatorCornerRadius="2dp"
            app:stl_overlineColor="#4D000000"
            app:stl_overlineThickness="0dp"
            app:stl_underlineColor="#4D000000"
            app:stl_underlineThickness="1dp"
            app:stl_dividerColor="#4D000000"
            app:stl_dividerThickness="1dp"
            app:stl_defaultTabBackground="?attr/selectableItemBackground"
            app:stl_defaultTabTextAllCaps="true"
            app:stl_defaultTabTextColor="#FC000000"
            app:stl_defaultTabTextSize="12sp"
            app:stl_defaultTabTextHorizontalPadding="16dp"
            app:stl_defaultTabTextMinWidth="0dp"
            app:stl_distributeEvenly="false"
            app:stl_clickable="true"
            app:stl_titleOffset="24dp"
            app:stl_drawDecorationAfterTab="false"
            />
    
        <androidx.viewpager.widget.ViewPager
            android:id="@+id/viewpager"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_below="@id/viewpagertab"
            />
    </LinearLayout>

Passo 3: Criar referencias para os componentes viewpagertab e viewpager no MainActivity.java

    ```

    public class MainActivity extends AppCompatActivity {
    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smartTabLayout = findViewById(R.id.viewpagertab);
        viewPager = findViewById(R.id.viewpager);

    }
}

Passo 4: Configurar as abas dentro do método onCreate no MainActivity.java

    ```

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

    
## Tecnologias Utilizadas
- Linguagem de programação: Java

## Visão Geral do Código
O código possibilita a criação de abas dinamicas com conteúdos distintos, simulando a interface do famoso app Youtube

Sinta-se à vontade para explorar, modificar e expandir o código para adicionar funcionalidades adicionais, se necessário.
