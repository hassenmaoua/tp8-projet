package esprit.tp8hassenmaoua6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    String technologie;
    Long cout;
    Date dateDebut;

    @OneToOne(mappedBy = "projetDetail", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    Projet projet;
}
