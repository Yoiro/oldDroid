package degreve.async;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import degreve.entities.Adresse;
import degreve.entities.Editeur;
import degreve.entities.Publication;

/**
 * Created by Simon on 12-12-16.
 */
public class GetByNameAT extends AsyncTask<String,Void,Publication>{
    private Button btnSearch;
    private ListView lvT;
    private Context context;
    private Object item;

    public GetByNameAT(Button btnSearch,ListView lv,Context context,Object obj){
        this.btnSearch=btnSearch;
        lvT=lv;
        this.context=context;
        item=obj;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        btnSearch.setEnabled(false);
    }

    @Override
    protected Publication doInBackground(String... params) {
        Publication singleResult=null;
        String name=params[0].replace(" ","%20");
        String findClass = item.getClass().getSimpleName();
        String urlSearch="http://52.31.3.254:11080/api-livres/services/api/"+findClass.toLowerCase()+"s/"+name;

        try {
            URL url=new URL(urlSearch);
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            InputStream response=connection.getInputStream();
            InputStreamReader reader=new InputStreamReader(response);
            BufferedReader in=new BufferedReader(reader);
            StringBuilder sb=new StringBuilder();
            String line;
            while((line=in.readLine())!=null){
                sb.append(line);
            }
            String jsonResult=sb.toString();
            JSONArray jsonArray=new JSONArray(jsonResult);
                List<Editeur> editeurs=new ArrayList<>();
                Publication temp;
                for(int cpt=0;cpt<jsonArray.length();cpt++){
                    JSONObject jsonPublication=jsonArray.getJSONObject(cpt);
                    if(!jsonPublication.isNull("editeurs")) {
                        JSONArray jsonEditeurs = jsonPublication.getJSONArray("editeurs");
                        for (int cptEdit = 0; cptEdit < jsonEditeurs.length(); cptEdit++) {
                            JSONObject currentEditeur = jsonEditeurs.getJSONObject(cptEdit);
                            JSONObject jsonAdresse = currentEditeur.getJSONObject("adresse");
                            int codePostal = jsonAdresse.getInt("codePostal");
                            int idAdresse = jsonAdresse.getInt("id");
                            String numero = jsonAdresse.getString("numero");
                            String rue = jsonAdresse.getString("rue");
                            String ville = jsonAdresse.getString("ville");
                            Adresse adresse = new Adresse(codePostal, idAdresse, numero, rue, ville);

                            int idEditeur = currentEditeur.getInt("id");
                            String nomEdit = currentEditeur.getString("nom");

                           Editeur current = new Editeur(adresse, idEditeur, nomEdit);
                        }
                    }
                    int id=jsonPublication.getInt("id");
                    String titre=jsonPublication.getString("titre");

                    temp=new Publication(editeurs,id,titre);

                    if(titre.equals(name)){
                        singleResult=temp;
                    }
                }
            return singleResult;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
