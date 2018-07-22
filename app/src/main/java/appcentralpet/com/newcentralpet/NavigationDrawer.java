package appcentralpet.com.newcentralpet;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import java.io.Serializable;


import appcentralpet.com.newcentralpet.BancoMeusPets.Cadastro;
import appcentralpet.com.newcentralpet.BancoMeusPets.PetList;
import appcentralpet.com.newcentralpet.BancoMeusPets.SQLiteHelper;
import appcentralpet.com.newcentralpet.ListExpansivel.DuvFrequentes;

import appcentralpet.com.newcentralpet.Vacinas.Vacinas;
import appcentralpet.com.newcentralpet.mapa.MapaClinicaActivity;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Serializable{


    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        //Notificação


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Vacinas");
        setSupportActionBar(toolbar);

        sqLiteHelper = new SQLiteHelper(this, "PetDB.sqlite", null, 4);
        sqLiteHelper.queryData( "CREATE TABLE IF NOT EXISTS PET (Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR, " +
                "sexo VARCHAR, " +
                "raca VARCHAR, " +
                "tipo VARCHAR, " +
                "idade VARCHAR, " +
                "image BLOB)");


        FragmentManager fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameprincipal, new Vacinas()).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        //notificação();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_cadastro) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameprincipal, new Cadastro()).commit();
            getSupportActionBar().setTitle("Novo Pet");

        } else if (id == R.id.nav_meusPets) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameprincipal, new PetList()).commit();
            getSupportActionBar().setTitle("Meus Pets");

        } else if (id == R.id.nav_vacina) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameprincipal, new Vacinas()).commit();
            getSupportActionBar().setTitle("Vacinas");

        } else if (id == R.id.nav_clinicas) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameprincipal, new fragMap()).commit();
            getSupportActionBar().setTitle("Clínicas e Petshops");

        } else if (id == R.id.nav_duvFreq) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameprincipal, new DuvFrequentes()).commit();
            getSupportActionBar().setTitle("Dúvidas Frequentes");

        } else if (id == R.id.nav_suporte) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameprincipal, new Suporte()).commit();
            getSupportActionBar().setTitle("Suporte");

        } else if (id == R.id.nav_ong) {
            Intent ong = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/anjosdequatrop4tas"));
            startActivity(ong);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    }





