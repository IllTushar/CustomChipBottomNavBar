package com.example.customnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity implements ChipNavigationBar.OnItemSelectedListener{
ChipNavigationBar chipNavigationBar;
FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());
      chipNavigationBar = findViewById(R.id.menu);
      chipNavigationBar.setOnItemSelectedListener(this);
    }
    private  void loadFragment(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.FrameLayout,fragment)
                    .commit();
        }
        else{
            Toast.makeText(this, "Fragment Error ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bottom,menu);
        return true;
    }

    @Override
    public void onItemSelected(int i) {
        Fragment fragment =null;
       switch (i){
           case R.id.homes:
               fragment = new HomeFragment();
               break;
           case R.id.search:
               fragment = new SearchFragment();
               break;
           case R.id.setting:
               fragment = new SettingFragment();
               break;

       }
       loadFragment(fragment);
    }
}