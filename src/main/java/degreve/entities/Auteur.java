package degreve.entities;

import java.io.Serializable;

/**
 * Created by Simon on 12-12-16.
 */
public class Auteur implements Serializable{
    int id;
    String nom;

    public Auteur(){}
    public Auteur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
