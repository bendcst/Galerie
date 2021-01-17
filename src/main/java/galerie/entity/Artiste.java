/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import galerie.entity.Tableau;
import javax.persistence.*;
import lombok.NonNull;
import java.util.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Benjamin
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity

public class Artiste extends Personne {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private String biographie;
    
    @OneToMany(mappedBy = "auteur")
    List<Tableau> oeuvres = new LinkedList<>();

    public String getBiographie() {
        return biographie;
    }

    public List<Tableau> getOeuvres() {
        return oeuvres;
    }
    
    
    
}
