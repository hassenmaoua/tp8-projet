package esprit.tp8hassenmaoua6.service.projet;

import esprit.tp8hassenmaoua6.entity.Projet;

import java.util.List;

public interface IProjetService {
    List<Projet> retrieveAllProjets();

    Projet retrieveProjet(Long projetId);

    Projet addProjetAndProjetDetailAndAssign(Projet projet);

    void assignProjetDetailToProjet(Long projetId, Long projetDetailId);
    void assignProjetToEquipe(Long projetId, Long equipeId);

    void removeProjet(Long projetId);

    Projet modifyProjet(Projet projet);
}
