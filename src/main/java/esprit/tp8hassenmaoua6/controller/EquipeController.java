package esprit.tp8hassenmaoua6.controller;

import esprit.tp8hassenmaoua6.entity.Equipe;
import esprit.tp8hassenmaoua6.service.equipe.EquipeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Web Services pour la gestion Equipes")
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {
    private final EquipeService equipeService;

    @PostMapping("/ajouter")
    public Equipe addEquipeAndEquipeDetail(@RequestBody Equipe body) {
        Equipe equipe = equipeService.addEquipe(body);
        return equipe;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Equipe>> getAllEquipes() {
        List<Equipe> equipeList = equipeService.retrieveAllEquipes();

        if (!equipeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(equipeList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        Equipe equipe = equipeService.retrieveEquipe(id);
        if (equipe != null) {
            return ResponseEntity.status(HttpStatus.OK).body(equipe);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/modifier")
    public ResponseEntity<Equipe> updateEquipe(@RequestBody Equipe argEquipe) {
        Equipe equipe = equipeService.retrieveEquipe(argEquipe.getId());
        if (equipe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Equipe updatedEquipe = equipeService.modifyEquipe(argEquipe);

        return ResponseEntity.status(HttpStatus.OK).body(updatedEquipe);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Object> deleteEquipe(@PathVariable Long id) {
        equipeService.removeEquipe(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
