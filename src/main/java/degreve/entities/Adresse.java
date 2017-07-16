package degreve.entities;

import java.io.Serializable;

/**
 * Created by Simon on 11-12-16.
 */
public class Adresse implements Serializable{
    int codePostal;
    int id;
    String numero;
    String rue;
    String ville;

    public Adresse(){}
    public Adresse(int cP, int id, String num, String rue, String ville){
        if(cP>0)codePostal=cP;
        if(id>0)this.id=id;
        if(num!=null)numero=num;
        if(rue!=null)this.rue=rue;
        if(ville!=null)this.ville=ville;
    }

    public String toString(){
        return "Adresse n°"+id+": "+"numero "+numero+" "+rue+" "+codePostal+" "+ville;
    }
}
