package mlhvproductions.controluz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;

public class HistoryActivity2 extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener  {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private final static String TAG = "HistoryActivity2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //TODO Fazer leitura do Banco aqui
        FormatoDeDados item1 = new FormatoDeDados("Exemplo1", "25/05/2015");
        FormatoDeDados item2 = new FormatoDeDados("Exemplo2", "25/05/2018");

        ArrayList<FormatoDeDados> lista = new ArrayList<>();

        lista.add(item1);
        lista.add(item2);


        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(lista);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        //TODO você pode incluir método para fechar o app aqui
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_github) {
            // Handle the github link
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/wyvern800/controluz")));
            Log.e(TAG, "onNavigationItemSelected #1");
        } else if (id == R.id.nav_historico) {
            //Não chama a tela de novo
        } else if (id == R.id.nav_sobre) {
            startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            Log.e(TAG, "onNavigationItemSelected #3");
        }
        //TODO incluir método para voltar para main


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
