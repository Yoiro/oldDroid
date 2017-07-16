package degreve.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Simon on 11-12-16.
 */
public class Publication implements Serializable{
    //{"editeurs":[],"id":33,"titre":"911"}
    List<Editeur> editeurs;
    int id;
    String nom;

    public Publication(){}
    public Publication(List<Editeur> edit, int id, String titre){
        editeurs=edit;
        this.id=id;
        this.nom=titre;
    }

    public List<Editeur> getEditeurs(){return editeurs;}
    public int getId(){return id;}
    public String getTitre(){return nom;}
}
