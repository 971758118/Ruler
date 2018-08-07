package com.solo.ruler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RulerActivity extends AppCompatActivity {


    private RulerView rulerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(rulerView = new RulerView(this));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        if (rulerView != null) {
            rulerView.setLineX(savedInstanceState.getFloat("lineX"));
            rulerView.setKedu(savedInstanceState.getInt("kedu"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // TODO Auto-generated method stub
        if (rulerView != null) {
            outState.putFloat("lineX", rulerView.getLineX());
            outState.putInt("kedu", rulerView.getKedu());
        }
        super.onSaveInstanceState(outState);
    }

}
