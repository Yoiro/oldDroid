package degreve.entities;

import java.io.Serializable;

/**
 * Created by Simon on 11-12-16.
 */
public class Editeur implements Serializable {
    Adresse adresse;
    int id;
    String nom;

    public Editeur(){}
    public Editeur(Adresse adresse, int id, String nom){
        if(adresse!=null)this.adresse=adresse;
        if(id>0)this.id=id;
        if(nom!=null)this.nom=nom;
    }

    public String getNom() {return nom;}
    public Adresse getAdresse(){return adresse;}
    public int getId(){return id;}

    public String toString(){
        return "adresse:[ "+adresse.toString()+"]id:["+id+"]\nnom:["+nom+"]+\n";
    }
}
