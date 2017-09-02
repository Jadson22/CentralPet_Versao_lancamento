package appcentralpet.com.newcentralpet;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Suporte extends Fragment {

    private Toolbar toolbar_suporte;

    RelativeLayout compartilheid;
    RelativeLayout twitterid;
    RelativeLayout contatoid;

    public Suporte() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_suporte, container, false);

        toolbar_suporte = (Toolbar) view.findViewById(R.id.toolbar_suporte);
        toolbar_suporte.setTitle("Suporte");


        compartilheid = (RelativeLayout) view.findViewById(R.id.compartilheid);
        compartilheid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.setType("text/plain");
                it.putExtra(Intent.EXTRA_TEXT, "Baixe o aplicativo Central Pet! \n https://.....");
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

        return view;
    }

}
