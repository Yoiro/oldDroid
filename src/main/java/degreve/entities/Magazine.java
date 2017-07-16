package degreve.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Simon on 12-12-16.
 */
public class Magazine implements Serializable{
    String type;
    List<Editeur> editeurs;
    int id;
    String titre;
    String periodicite;

    public Magazine(){}
    public Magazine(String type, List<Editeur> editeurs, int id, String titre, String periodicite) {
        this.type = type;
        this.editeurs = editeurs;
        this.id = id;
        this.titre = titre;
        this.periodicite = periodicite;
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

    public String getPeriodicite() {
        return periodicite;
    }
}
