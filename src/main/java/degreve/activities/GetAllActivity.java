package degreve.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import be.helha.degreve.la141353.degreve.R;
import degreve.async.GetAllAT;
import degreve.entities.Auteur;
import degreve.entities.Editeur;
import degreve.entities.Livre;
import degreve.entities.Magazine;
import degreve.entities.Publication;
import degreve.ui.Auteur_Ui_Adapter;
import degreve.ui.Editor_Ui_Adapter;
import degreve.ui.Livre_Ui_Adapter;
import degreve.ui.Magazine_Ui_Adapter;
import degreve.ui.Publication_Ui_Adapter;

public class GetAllActivity extends AppCompatActivity {

    private static final String TAG = "Simon";
    private Object o;
    private Button btnReturn_GetAll;
    private ListView lvGetAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);
        Intent i=getIntent();
        o=i.getSerializableExtra("Class");
        String classe=o.getClass().getSimpleName();
        btnReturn_GetAll=(Button) findViewById(R.id.btnReturn_GetAll);
        btnReturn_GetAll.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        lvGetAll=(ListView) findViewById(R.id.lvGetAll);

        if(classe.equals("Editeur")) {
            GetAllAT<Editeur> async=new GetAllAT<Editeur>(btnReturn_GetAll,lvGetAll,new Editeur(),getApplicationContext());
            async.execute();
        }
        else if(classe.equals("Publication")) {
                GetAllAT<Publication> async = new GetAllAT<Publication>(btnReturn_GetAll, lvGetAll, new Publication(), getApplicationContext());
                async.execute();
            }
        else if(classe.equals("Auteur")){
            GetAllAT<Auteur>async=new GetAllAT<Auteur>(btnReturn_GetAll,lvGetAll,new Auteur(),getApplicationContext());
            async.execute();
        } else if(classe.equals("Livre")){
            GetAllAT<Livre>async=new GetAllAT<Livre>(btnReturn_GetAll,lvGetAll,new Livre(),getApplicationContext());
            async.execute();
        } else if(classe.equals("Magazine")){
            GetAllAT<Magazine>async=new GetAllAT<Magazine>(btnReturn_GetAll,lvGetAll,new Magazine(),getApplicationContext());
            async.execute();
        }

        lvGetAll.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(o.getClass().getSimpleName().equals("Editeur")){
                    Editor_Ui_Adapter uiAdapter=(Editor_Ui_Adapter)lvGetAll.getAdapter();
                    Editeur selectedEditeur=uiAdapter.getItem(position);

                    Intent intentToDetails=new Intent(getApplicationContext(),DetailsActivity.class);
                    intentToDetails.putExtra("id",selectedEditeur.getId());
                    startActivity(intentToDetails);
                }else if(o.getClass().getSimpleName().equals("Livre")){
                    Livre_Ui_Adapter ui_adapter=(Livre_Ui_Adapter)lvGetAll.getAdapter();
                    Livre selectedLivre=ui_adapter.getItem(position);
                    Intent intentToDetails=new Intent(getApplicationContext(),DetailsActivity.class);
                    intentToDetails.putExtra("id",selectedLivre.getId());
                    startActivity(intentToDetails);
                }
                else if(o.getClass().getSimpleName().equals("Publication")){
                        Publication_Ui_Adapter uiAdapter=(Publication_Ui_Adapter)lvGetAll.getAdapter();
                        Publication selectedPublication=uiAdapter.getItem(position);
                        Intent intentToDetails=new Intent(getApplicationContext(),DetailsActivity.class);
                        intentToDetails.putExtra("id",selectedPublication.getId());
                        startActivity(intentToDetails);
                }

                else if(o.getClass().getSimpleName().equals("Auteur")){
                        Auteur_Ui_Adapter uiAdapter=(Auteur_Ui_Adapter)lvGetAll.getAdapter();
                        Auteur selectedAuteur=uiAdapter.getItem(position);
                        Intent intentToDetails=new Intent(getApplicationContext(),DetailsActivity.class);
                        intentToDetails.putExtra("id",selectedAuteur.getId());
                        startActivity(intentToDetails);
                }else if(o.getClass().getSimpleName().equals("Magazine")){
                    Magazine_Ui_Adapter uiAdapter=(Magazine_Ui_Adapter)lvGetAll.getAdapter();
                    Magazine selectedMag=uiAdapter.getItem(position);
                    Intent intentToDetails=new Intent(getApplicationContext(),DetailsActivity.class);
                    intentToDetails.putExtra("id",selectedMag.getId());
                    intentToDetails.putExtra("Class",new Magazine());
                    startActivity(intentToDetails);
                }

            }
        });


    }
}
