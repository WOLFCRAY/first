package com.alemyapp.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * @author am8DAM2
 */
public class SplashScreen extends AppCompatActivity {
    ImageView icono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //SIRVE PARA HACER LA TRANSICION ENTRE EL SPLASH Y EL LOGIN
        openLogin(true);
        //GLIDE FOR LOADING GIRLS
        ImageView mFondo = findViewById(R.id.inicio);
//        Glide.with(this)
//                //.load(R.drawable.girl)
//                .load("https://images.unsplash.com/photo-1506869640319-fe1a24fd76dc?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1470&q=80")
//                //.load("https://images.unsplash.com/photo-1489549132488-d00b7eee80f1?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80")
//                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.dark_blue)))
//                .transition(DrawableTransitionOptions.withCrossFade(100))
//                //.circleCrop()
//                .into(mFondo);

        icono = (ImageView) findViewById(R.id.logo);
        //Animation rotate = AnimationUtils.loadAnimation(this, R.anim.anim);
        Animation traslate = AnimationUtils.loadAnimation(this, R.anim.traslacion);
        //icono.startAnimation(rotate);
        icono.startAnimation(traslate);
    }
    //SIRVE PARA HACER LA TRANSICION ENTRE EL SPLASH Y EL LOGIN
    public void openLogin(boolean locationPermission){
        /*Intent intent = new Intent(SplashScreen.this, Login.class);
        startActivity(intent);*/
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
            }
        }, 3000);
    }
}