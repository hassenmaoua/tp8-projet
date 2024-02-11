package esprit.tp8hassenmaoua6.service.projetdetail;

import esprit.tp8hassenmaoua6.entity.ProjetDetail;
import esprit.tp8hassenmaoua6.repository.ProjetDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetDetailService implements IProjetDetailService {
    private final ProjetDetailRepository projetDetailRepository;


    @Override
    public List<ProjetDetail> retrieveAllProjetDetails() {
        return projetDetailRepository.findAll();
    }

    @Override
    public ProjetDetail retrieveProjetDetail(Long id) {
        return projetDetailRepository.findById(id).get();
    }

    @Override
    public ProjetDetail addProjetDetail(ProjetDetail projetDetail) {
        return projetDetailRepository.save(projetDetail);
    }

    @Override
    public void removeProjetDetail(Long id) {
        projetDetailRepository.deleteById(id);
    }

    @Override
    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail) {
        return projetDetailRepository.save(projetDetail);
    }
}
