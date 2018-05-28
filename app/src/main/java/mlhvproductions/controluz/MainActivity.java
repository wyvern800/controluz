package mlhvproductions.controluz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Botão ON Sala
        /**btnOnSala.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), getApplicationContext().getString(R.string.txtOnline), Toast.LENGTH_LONG).show();
                Log.e(TAG, "onClick #1");
            }*
        });*/

        Button btnOnSala= (Button)findViewById(R.id.btnLigarSala);
        Button btnOffSala= (Button)findViewById(R.id.btnDesligarSala);
        Button btnDSala= (Button)findViewById(R.id.btnDesconectarSala);
        Button btnOnQuarto= (Button)findViewById(R.id.btnLigarQuarto);
        Button btnOffQuarto= (Button)findViewById(R.id.btnDesligarQuarto);
        Button btnDQuarto= (Button)findViewById(R.id.btnDesconectarQuarto);

        //Adicionar ação nos botões
        addAcaoNoBotao(btnOnSala, R.string.strOnline);
        addAcaoNoBotao(btnOffSala, R.string.strOffline);
        addAcaoNoBotao(btnDSala, R.string.strDesconectar);
        addAcaoNoBotao(btnOnQuarto, R.string.strOnline);
        addAcaoNoBotao(btnOffQuarto, R.string.strOffline);
        addAcaoNoBotao(btnDQuarto, R.string.strDesconectar);

    }

    public void addAcaoNoBotao(Button btn, final int a) {
        btn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {
        Toast.makeText(view.getContext(), getApplicationContext().getString(a), Toast.LENGTH_LONG).show();
        Log.e(TAG, "onClick button");
        }
        });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            Log.e(TAG, "onBackPressed");
        } else {
            super.onBackPressed();
            Log.e(TAG, "onBackPressed");
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_github) {
            // Handle the github link
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/wyvern800/controluz")));
            Toast.makeText(this, getApplicationContext().getString(R.string.op1), Toast.LENGTH_LONG).show();
            Log.e(TAG, "onNavigationItemSelected #1");
        } else if (id == R.id.nav_historico) {
            startActivity(new Intent(this, HistoryActivity.class));
            Toast.makeText(this,getApplicationContext().getString(R.string.op2), Toast.LENGTH_LONG).show();
            Log.e(TAG, "onNavigationItemSelected #2");
        } else if (id == R.id.nav_sobre) {
            startActivity(new Intent(this, AboutActivity.class));
            Toast.makeText(this,getApplicationContext().getString(R.string.op3), Toast.LENGTH_LONG).show();
            Log.e(TAG, "onNavigationItemSelected #3");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
