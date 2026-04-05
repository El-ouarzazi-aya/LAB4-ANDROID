package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button navBtnA, navBtnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navBtnA = findViewById(R.id.navBtnA);
        navBtnB = findViewById(R.id.navBtnB);

        if (savedInstanceState == null) {
            loadFragment(new FragmentOne(), false);
        }

        navBtnA.setOnClickListener(v -> loadFragment(new FragmentOne(), true));
        navBtnB.setOnClickListener(v -> loadFragment(new FragmentTwo(), true));
    }

    private void loadFragment(Fragment fragment, boolean stackIt) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.main_frame, fragment);

        if (stackIt) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}