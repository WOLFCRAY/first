package com.alemyapp.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * @author Alex
 */
public class Login extends AppCompatActivity {
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //GLIDE FOR LOADING GIRLS
        ImageView mGirl = findViewById(R.id.girl);
        Glide.with(this)
                .load(R.drawable.girl)
                //.load("https://images.unsplash.com/photo-1574686120856-a27b4a5e47d8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1052&q=80")
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.dark_blue)))
                .transition(DrawableTransitionOptions.withCrossFade(100))
                //.circleCrop()
                .into(mGirl);
        logo = (ImageView) findViewById(R.id.logo);
        Animation traslacion = AnimationUtils.loadAnimation(this, R.anim.anim);
        //icono.startAnimation(rotate);
        logo.startAnimation(traslacion);
    }

    public void openMain(View v){
        Intent intent = new Intent(Login.this, Main.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void openSignup(View v){
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }
}
