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
public class Personne {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private float budgetAnneeArtiste = 0;
    
    @Column(unique=true)
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "client")
    List<Transaction> achats = new LinkedList<>();

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public List<Transaction> getAchats() {
        return achats;
    }
    
    public float budgetArt(int annee){
        achats.forEach((achat) ->{
            if (achat.getVenduLe().getYear() == annee){
                budgetAnneeArtiste += achat.getPrixVente();
            }
    });
        return budgetAnneeArtiste;
}
}
