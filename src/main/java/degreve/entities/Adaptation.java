package degreve.entities;

import java.io.Serializable;

/**
 * Created by Simon on 12-12-16.
 */
public class Adaptation implements Serializable{
    int annee;
    int id;
    String titre;

    public Adaptation(){}
    public Adaptation(int annee, int id, String titre) {
        this.annee = annee;
        this.id = id;
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }
}
