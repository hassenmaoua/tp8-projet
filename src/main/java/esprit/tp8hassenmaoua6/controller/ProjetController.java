package esprit.tp8hassenmaoua6.controller;

import esprit.tp8hassenmaoua6.entity.Projet;
import esprit.tp8hassenmaoua6.service.projet.ProjetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Web Services pour la gestion Projets")
@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetController {
    private final ProjetService projetService;

    @Operation(description = "Assing projet a une equipe")
    @PutMapping("/assign-projet")
    public ResponseEntity<String> assignProjetToEquipe(@RequestParam(name = "projetId") Long projetId, @RequestParam(name = "equipeId") Long equipeId) {
        projetService.assignProjetToEquipe(projetId, equipeId);
        return ResponseEntity.status(HttpStatus.OK).body("Assignée avec success");
    }

    @Operation(description = "Desaffecter ProjetDetail from Projet")
    @PutMapping("/desaffecter-projet-detail/{id}")
    public ResponseEntity<Projet> desaffecterProjetDetailFromProjet(@PathVariable Long id) {
        Projet projet = projetService.desaffecterProjetDetailFromProjet(id);
        return ResponseEntity.status(HttpStatus.OK).body(projet);
    }

    @Operation(description = "Desaffecter projet from equipe")
    @PutMapping("/desaffecter-projet-equipe")
    public ResponseEntity<String> desaffecterProjetFromEquipe(@RequestParam(name = "projetId") Long projetId, @RequestParam(name = "equipeId") Long equipeId) {
        projetService.desaffecterProjetFromEquipe(projetId, equipeId);
        return ResponseEntity.status(HttpStatus.OK).body("Dessafecter Projet from equipe avec success");
    }

    @Operation(description = "Ajouter un projet avec details")
    @PostMapping("/ajouter-projet-et-projet-detail")
    public Projet addProjetAndProjetDetail(@RequestBody Projet projet) {
        return projetService.addProjetAndProjetDetailAndAssign(projet);
    }

    @Operation(description = "Affecter un projet a projet details")
    @PutMapping("/affecter-projet-a-projet-detail/{projet-id}/{projet-detail-id}")
    public ResponseEntity<String> affecterProjetAProjetDetail(@PathVariable("projet-id") Long proejtId,
                                             @PathVariable("projet-detail-id") Long proejtDetailsId) {
        projetService.assignProjetDetailToProjet(proejtId, proejtDetailsId);
        return ResponseEntity.status(HttpStatus.OK).body("Projet affectée a projet details avec success");
    }

    @Operation(description = "Recupartion des tous les projets")
    @GetMapping("/all")
    public ResponseEntity<List<Projet>> getAllProjets() {
        List<Projet> projetList = projetService.retrieveAllProjets();

        if (!projetList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(projetList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(description = "Recupartion de projet by id")
    @GetMapping("{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        Projet projet = projetService.retrieveProjet(id);
        if (projet != null) {
            return ResponseEntity.status(HttpStatus.OK).body(projet);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    @Operation(description = "Modifier projet")
    @PutMapping("/modifier")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet argProjet) {
        Projet projet = projetService.retrieveProjet(argProjet.getId());
        if (projet == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Projet updatedProjet = projetService.modifyProjet(argProjet);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProjet);
    }

    @Operation(description = "Supprimer projet")
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Object> deleteProjet(@PathVariable Long id) {
        projetService.removeProjet(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
