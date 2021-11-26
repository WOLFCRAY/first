package com.alemyapp.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //GLIDE FOR LOADING MAN
        ImageView mMan = findViewById(R.id.man);
        Glide.with(this)
                .load(R.drawable.hipman)
                //.load("https://images.unsplash.com/photo-1574686120856-a27b4a5e47d8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1052&q=80")
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.dark_blue)))
                .transition(DrawableTransitionOptions.withCrossFade(100))
                //.circleCrop()
                .into(mMan);
    }
    public void openMain(View v){
        Intent intent = new Intent(Signup.this, Main.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    
}