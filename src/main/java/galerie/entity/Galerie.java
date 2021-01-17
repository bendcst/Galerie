package galerie.entity;
import java.util.*;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA

public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    private float chiffreAffAnnuel = 0;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    @OneToMany(mappedBy = "organisateur")
    List<Exposition> evenements = new LinkedList<>();
    
    
    public float CAannuel(int annee){
        evenements.forEach((expo) -> {
            if(expo.getDebut().getYear() == annee){
                chiffreAffAnnuel += expo.getSommeVentes();
            }
    });
        return chiffreAffAnnuel;
    }

}
