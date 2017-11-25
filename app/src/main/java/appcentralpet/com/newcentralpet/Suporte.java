package appcentralpet.com.newcentralpet;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class Suporte extends Fragment {

    RelativeLayout avalieid;
    RelativeLayout compartilheid;
    RelativeLayout twitterid;
    RelativeLayout contatoid;
    RelativeLayout politica;

    public Suporte() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_suporte, container, false);

        avalieid = (RelativeLayout) view.findViewById(R.id.avalieid);
        avalieid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ava = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=appcentralpet.com.newcentralpet"));
                startActivity(ava);
            }
        });

        compartilheid = (RelativeLayout) view.findViewById(R.id.compartilheid);
        compartilheid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("text/plain");
                it.putExtra(Intent.EXTRA_TEXT, "Baixe o aplicativo Central Pet! \n Download em: https://play.google.com/store/apps/details?id=appcentralpet.com.newcentralpet");
                startActivity(it);
            }
        });

        twitterid = (RelativeLayout) view.findViewById(R.id.twitterid);
        twitterid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/appcentralpet"));
                startActivity(it);
            }
        });

        contatoid = (RelativeLayout) view.findViewById(R.id.contatoid);
        contatoid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/mail/u/0/#inbox?compose=new"));
                startActivity(intent);
            }
        });

        politica = (RelativeLayout) view.findViewById(R.id.politica);
        politica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent poli = new Intent(getContext(), PoliticaDePrivacidade.class);
                startActivity(poli);
            }
        });

        return view;
    }

}
