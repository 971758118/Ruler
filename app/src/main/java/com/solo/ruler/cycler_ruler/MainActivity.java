package com.solo.ruler.cycler_ruler;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.solo.ruler.R;
import com.solo.ruler.RulerActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiaxu on 2018-08-06
 */

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_PHONE_PERMISSIONS = 0;
    private TextView mRuler, mCyclerRuler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPermission();

        mRuler = findViewById(R.id.tv_ruler);
        mCyclerRuler = findViewById(R.id.tv_cycler_ruler);

        mRuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RulerActivity.class);
                startActivity(intent);
            }
        });
        mCyclerRuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CyclerRulerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initPermission() {
        final List<String> permissionsList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ((checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED))
                permissionsList.add(Manifest.permission.CAMERA);
            if (permissionsList.size() == 0) {
            } else {
                requestPermissions(permissionsList.toArray(new String[permissionsList.size()]), REQUEST_PHONE_PERMISSIONS);
            }
        }
    }
}
