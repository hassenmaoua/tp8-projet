package esprit.tp8hassenmaoua6.controller;

import esprit.tp8hassenmaoua6.entity.ProjetDetail;
import esprit.tp8hassenmaoua6.service.projetdetail.ProjetDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Web Services pour la gestion ProjetDetails")
@RestController
@AllArgsConstructor
@RequestMapping("/projet-detail")
public class ProjetDetailController {
    private final ProjetDetailService projetDetailService;

    @PostMapping("/ajouter")
    public ProjetDetail addProjetDetailAndProjetDetailDetail(@RequestBody ProjetDetail body) {
        ProjetDetail projetDetail = projetDetailService.addProjetDetail(body);
        return projetDetail;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjetDetail>> getAllProjetDetails() {
        List<ProjetDetail> projetDetailList = projetDetailService.retrieveAllProjetDetails();

        if (!projetDetailList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(projetDetailList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjetDetail> getProjetDetailById(@PathVariable Long id) {
        ProjetDetail projetDetail = projetDetailService.retrieveProjetDetail(id);
        if (projetDetail != null) {
            return ResponseEntity.status(HttpStatus.OK).body(projetDetail);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/modifier")
    public ResponseEntity<ProjetDetail> updateProjetDetail(@RequestBody ProjetDetail argProjetDetail) {
        ProjetDetail projetDetail = projetDetailService.retrieveProjetDetail(argProjetDetail.getId());
        if (projetDetail == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        ProjetDetail updatedProjetDetail = projetDetailService.modifyProjetDetail(argProjetDetail);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProjetDetail);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Object> deleteProjetDetail(@PathVariable Long id) {
        projetDetailService.removeProjetDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
