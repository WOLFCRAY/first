package com.alemyapp.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mycontext = (TextView) findViewById(R.id.textTap);
        registerForContextMenu(mycontext);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast toast1= Toast.makeText(this,"Item copied",Toast.LENGTH_LONG);
                toast1.show();
                return true;
            case R.id.item2:
                final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);
                Snackbar snackbar = Snackbar.make(mLayout,"FANCY A SNACK WHILE YOU REFRESH?",Snackbar.LENGTH_LONG).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restores!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });
               // Toast toast2 = Toast.makeText(this,"Item downloaded", Toast.LENGTH_LONG );
                //toast2.show();
                //return true;
                snackbar.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.item3){
            Toast toast = Toast.makeText(this,"Intfecting",Toast.LENGTH_LONG);
            toast.show();
        }
        if(id == R.id.item4){
            Toast toast = Toast.makeText(this,"Fixing",Toast.LENGTH_LONG);
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }
}