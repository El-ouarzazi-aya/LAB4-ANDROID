package com.example.fragmentslab;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    private TextView display;
    private SeekBar slider;
    private int currentVal = 0;
    private static final String VAL_KEY = "currentVal";

    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        display = view.findViewById(R.id.tvValue);
        slider = view.findViewById(R.id.seekBar);

        if (savedInstanceState != null) {
            currentVal = savedInstanceState.getInt(VAL_KEY, 0);
            slider.setProgress(currentVal);
            display.setText("Niveau : " + currentVal);
        }

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar s, int val, boolean fromUser) {
                currentVal = val;
                display.setText("Niveau : " + val);
            }
            @Override public void onStartTrackingTouch(SeekBar s) {}
            @Override public void onStopTrackingTouch(SeekBar s) {}
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(VAL_KEY, currentVal);
    }
}