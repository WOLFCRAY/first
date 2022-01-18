package com.alemyapp.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {
    SwipeRefreshLayout swipeLayout;
    WebView miVisorWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tap con opciones en texto
//        TextView mycontext = (TextView) findViewById(R.id.textTap);
//        registerForContextMenu(mycontext);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        miVisorWeb = (WebView) findViewById(R.id.myweb);
        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        miVisorWeb.loadUrl("https://thisartworkdoesnotexist.com/");
        //mantener presionado para las opciones
        registerForContextMenu(miVisorWeb);

    }

    //DIALOGO MODAL
    public void showAlertDialogButtinClicked(Main activityMain){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //MaterialAlertDialogBuilder builder1 = new MaterialAlertDialogBuilder(this);

//      //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Notificación");
        builder.setMessage("¿Quieres volver al login?");
        builder.setIcon(R.drawable.ic_mando);

        // un XML a medida para el diálogo
        //builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(Main.this, Login.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(Main.this, ButtonAppBar.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    // ***     DM         ***

//    // EXPANDABLE CARD
//    ExpandableCardView card = findViewById(R.id.profile);
// card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
//        @Override
//        public void onExpandChanged(View v, boolean isExpanded) {
//            Toast.makeText(Main.this, isExpanded ? "Expanded!" :
//                    "Collapsed!", Toast.LENGTH_SHORT).show();
//        }
//    });




    //METODO PARA RECARGAR LA PAGINA
    protected SwipeRefreshLayout.OnRefreshListener
        mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(Main.this,"Esto es arte",Toast.LENGTH_LONG);
            toast0.show();

            miVisorWeb.reload();

            swipeLayout.setRefreshing(false);
        }
    };
    //METODO DEL MENU PARA COPIAR Y DESCARGAR CON TOAST
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.copiar:
                Toast toast1= Toast.makeText(this,"Item copied",Toast.LENGTH_LONG);
                toast1.show();
                return true;
            case R.id.descarga:
                final ConstraintLayout mLayout = findViewById(R.id.myMainConstraint);
                Snackbar snackbar = Snackbar.make(mLayout,"Quieres detener la descarga?",Snackbar.LENGTH_LONG).setAction("SI", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(mLayout, "Descarga cancelada", Snackbar.LENGTH_SHORT);
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
    //METODOS PARA EL MENU TOLBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        //AlertDialog
        if(id == R.id.mando){
            showAlertDialogButtinClicked(Main.this);
        }
        //Toast
        if(id == R.id.buscar){
            Toast toast = Toast.makeText(this,"Buscando",Toast.LENGTH_LONG);
            toast.show();
        }
        if(id == R.id.corazon){
            Toast toast = Toast.makeText(this,"Agregado a favoritos",Toast.LENGTH_LONG);
            toast.show();
        }
        //Toast y AlertDIalog
        if(id == R.id.perfil){
            showAlertDialogButtinClicked(Main.this);
            Toast toast = Toast.makeText(this,"Si aceptas debes iniciar sesion",Toast.LENGTH_LONG);
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }
}