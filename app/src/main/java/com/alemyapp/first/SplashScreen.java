package com.alemyapp.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //GLIDE FOR LOADING GIRLS
        ImageView mFondo = findViewById(R.id.inicio);
        Glide.with(this)
                //.load(R.drawable.girl)
                .load("https://images.unsplash.com/photo-1506869640319-fe1a24fd76dc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80")
                //.load("https://images.unsplash.com/photo-1489549132488-d00b7eee80f1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80")
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.dark_blue)))
                .transition(DrawableTransitionOptions.withCrossFade(100))
                //.circleCrop()
                .into(mFondo);
    }
    public void openLogin(View v){
        Intent intent = new Intent(SplashScreen.this, Login.class);
        startActivity(intent);
    }
}