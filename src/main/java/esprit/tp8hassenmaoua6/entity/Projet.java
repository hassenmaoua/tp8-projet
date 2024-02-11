package esprit.tp8hassenmaoua6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String sujet;

    @OneToOne(cascade = CascadeType.ALL)
    ProjetDetail projetDetail;

    @ManyToMany(
            mappedBy = "projets",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)

    @ToString.Exclude
    Set<Equipe> equipes;
}
