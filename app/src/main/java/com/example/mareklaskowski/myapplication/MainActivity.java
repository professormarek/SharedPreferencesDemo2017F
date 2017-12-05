package com.example.mareklaskowski.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("onCreate was called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        //by the way we can use system.out.println, cool!!
        System.out.println("onStop was called!");
        System.out.println("let's play with breakpoints!");
    }
}
