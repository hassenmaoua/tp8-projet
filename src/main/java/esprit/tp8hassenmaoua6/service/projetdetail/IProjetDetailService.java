package esprit.tp8hassenmaoua6.service.projetdetail;

import esprit.tp8hassenmaoua6.entity.ProjetDetail;

import java.util.List;

public interface IProjetDetailService {
    public List<ProjetDetail> retrieveAllProjetDetails();

    public ProjetDetail retrieveProjetDetail(Long id);

    public ProjetDetail addProjetDetail(ProjetDetail projetDetail);

    public void removeProjetDetail(Long id);

    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail);
}
