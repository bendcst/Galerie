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
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private Date venduLe;
    
    @Column(unique=true)
    @NonNull
    private float prixVente;
    
    @ManyToOne
    private Personne client;
    
    @ManyToOne
    private Exposition lieuDeVente;
    
    @OneToOne
    private Tableau oeuvres;

    public Date getVenduLe() {
        return venduLe;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public Personne getClient() {
        return client;
    }

    public Exposition getLieuDeVente() {
        return lieuDeVente;
    }

    public Tableau getOeuvres() {
        return oeuvres;
    }
    
    
}
