package degreve.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Simon on 12-12-16.
 */
public class Livre implements Serializable{
    //[{"type":"livre","editeurs":[],"id":33,"titre":"911","adaptations":[],"auteurs":[]}
    String type;
    List<Editeur> editeurs;
    int id;
    String titre;
    List<Adaptation> adaptations;
    List<Auteur> auteurs;

    public Livre(){}
    public Livre(String type, List<Editeur>edits, int id, String titre,
                 List<Adaptation>adapt, List<Auteur> auteurs){
        this.type=type;this.editeurs=edits;this.titre=titre;
        this.adaptations=adapt;this.auteurs=auteurs;
    }

    public String getType() {
        return type;
    }

    public List<Editeur> getEditeurs() {
        return editeurs;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public List<Adaptation> getAdaptations() {
        return adaptations;
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }
}
