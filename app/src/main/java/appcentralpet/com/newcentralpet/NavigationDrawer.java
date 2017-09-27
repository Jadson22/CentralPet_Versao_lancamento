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
import appcentralpet.com.newcentralpet.ListExpansivel.DuvFrequentes;
import appcentralpet.com.newcentralpet.Vacinas.Vacinas;
import appcentralpet.com.newcentralpet.mapa.MapaClinicaActivity;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Serializable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Novo Pet");
        setSupportActionBar(toolbar);

        Cadastro cadastro = new Cadastro();
        cadastro.getClass();


        FragmentManager fragmentManager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameprincipal, new Cadastro()).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
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
            //getSupportFragmentManager().beginTransaction().replace(R.id.frameprincipal, new MapaClinicaActivity()).commit();
            Intent intent = new Intent(NavigationDrawer.this, MapaClinicaActivity.class);
            startActivity(intent);

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
