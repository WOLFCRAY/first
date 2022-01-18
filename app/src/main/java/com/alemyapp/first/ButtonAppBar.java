package com.alemyapp.first;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.bottomappbar.BottomAppBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ButtonAppBar extends AppCompatActivity {
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonappbar);

        //cast al xml
        BottomAppBar bottomappbar = findViewById(R.id.bottom_app_bar);

        //click event en el FAB
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonAppBar.this,"FAB clicked",Toast.LENGTH_SHORT).show();
            }
        });

        //click event en el hamburguer
        bottomappbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonAppBar.this,"Menu clicked",Toast.LENGTH_SHORT).show();

            }
        });
        //click event en el buttom bar menu item
        bottomappbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.heart:
                            Toast.makeText(ButtonAppBar.this,"add to favorite", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.search:
                            Toast.makeText(ButtonAppBar.this,"search", Toast.LENGTH_SHORT).show();
                            break;
                    }
                return false;
            }
        });
    }
}
