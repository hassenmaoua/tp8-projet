package esprit.tp8hassenmaoua6.repository;

import esprit.tp8hassenmaoua6.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
