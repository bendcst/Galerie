/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author Benjamin
 */

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity

public class Exposition {
   
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private float sommeVentes = 0;
    
    @Column(unique=true)
    @NonNull
    private LocalDate debut;
    
    @Column(unique=true)
    @NonNull
    private String intitule;
    
    @Column(unique=true)
    private int duree;
    
    
    
    @ManyToMany(mappedBy = "accrochage")
    List<Tableau> oeuvres = new LinkedList<>();
    
    @ManyToOne
    private Galerie organisateur;
    
    @OneToMany(mappedBy = "lieuDeVente")
    List<Transaction> ventes = new LinkedList<>();

    public List<Transaction> getVentes() {
        return ventes;
    }

    public float getSommeVentes() {
        return sommeVentes;
    }

    public LocalDate getDebut() {
        return debut;
    }

    public String getIntitule() {
        return intitule;
    }

    public int getDuree() {
        return duree;
    }

    public List<Tableau> getOeuvres() {
        return oeuvres;
    }

    public Galerie getOrganisateur() {
        return organisateur;
    }
    
        
    
public float CA(Integer id){
    
    ventes.forEach((vente) -> {
    if(vente.getLieuDeVente().id == id){
        sommeVentes += vente.getPrixVente();
    }
});
    return sommeVentes;
}
}