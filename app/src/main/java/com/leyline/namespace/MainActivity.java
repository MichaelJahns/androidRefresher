package com.leyline.namespace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCourierDot(View view) {
        Intent intent = new Intent(this, DotActivity.class);
        startActivity(intent);
    }

    public void onCourierBar(View view) {
        Intent intent = new Intent(this, BarActivity.class);
        startActivity(intent);
    }
}
