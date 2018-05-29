package mlhvproductions.controluz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

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

        Button btnDSala= (Button)findViewById(R.id.btnDesconectarSala);
        Button btnDQuarto= (Button)findViewById(R.id.btnDesconectarQuarto);

        /*TODO Sugiro usar ToggleButton que é mais fácil - Obrigado pela ideia, pra mim era desconhecido
         *  Deixei ele por cima dos outros no layout, depois você arruma
         */
        //Quarto
        ToggleButton btnLigaDesligaQuarto = findViewById(R.id.btnLigaDesligaQuarto);
        btnLigaDesligaQuarto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //TODO Fazer as inclusões no Banco de dados
                    Toast.makeText(getApplicationContext(),"Luzes do quarto ligadas", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Luzes do quarto desligadas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    //Sala
        ToggleButton btnLigaDesligaSala = findViewById(R.id.btnLigaDesligaSala);
//        https://developer.android.com/guide/topics/ui/controls/togglebutton
        btnLigaDesligaSala.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //TODO Fazer as inclusões no Banco de dados
                    Toast.makeText(getApplicationContext(),"Luzes da sala ligadas", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Luzes da sala desligadas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Adicionar ação nos botões
        addAcaoNoBotao(btnDSala, R.string.strDesconectar);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_github) {
            // Handle the github link
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/wyvern800/controluz")));
            Log.e(TAG, "onNavigationItemSelected #1");
        } else if (id == R.id.nav_historico) {
            startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
            Log.e(TAG, "onNavigationItemSelected #2");
        } else if (id == R.id.nav_sobre) {
            startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            Log.e(TAG, "onNavigationItemSelected #3");
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
