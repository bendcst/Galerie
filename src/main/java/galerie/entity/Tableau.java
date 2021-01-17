/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.util.*;
import javax.persistence.*;
import lombok.*;
/**
 *
 * @author Benjamin
 */
public class Tableau {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private String titre;
    
    @Column(unique=true)
    @NonNull
    private String support;
    
    @Column(unique=true)
    private int largeur;
    
    @Column(unique=true)
    private int hauteur;
    
    @ManyToMany
    List<Exposition> accrochages = new LinkedList<>();
    
    @ManyToOne
    private Artiste auteur;
    
    @OneToOne
    private Transaction vendu;

    public String getTitre() {
        return titre;
    }

    public String getSupport() {
        return support;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public List<Exposition> getAccrochages() {
        return accrochages;
    }

    public Artiste getAuteur() {
        return auteur;
    }

    public Transaction getVendu() {
        return vendu;
    }
    
    
}
