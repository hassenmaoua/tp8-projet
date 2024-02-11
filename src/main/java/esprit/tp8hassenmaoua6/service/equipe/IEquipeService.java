package esprit.tp8hassenmaoua6.service.equipe;

import esprit.tp8hassenmaoua6.entity.Equipe;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> retrieveAllEquipes();

    public Equipe retrieveEquipe(Long equipeId);

    public Equipe addEquipe(Equipe equipe);

    public void removeEquipe(Long equipeId);

    public Equipe modifyEquipe(Equipe equipe);
}
