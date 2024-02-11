package esprit.tp8hassenmaoua6.repository;

import esprit.tp8hassenmaoua6.entity.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail, Long> {
}
