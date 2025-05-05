package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.usecases.promoters.FindProprietaryChampionshipsCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/promoter")

public class PromoterController {
    private final FindProprietaryChampionshipsCase findProprietaryChampionshipsCase;

    public PromoterController(FindProprietaryChampionshipsCase findProprietaryChampionshipsCase) {
        this.findProprietaryChampionshipsCase = findProprietaryChampionshipsCase;
    }

    @GetMapping("findChampionships")
    public ResponseEntity<?> findProprietaryChampionshipsCase() {
        List<Championship> championships = findProprietaryChampionshipsCase.execute();
        return ResponseEntity.ok(championships);
    }
}
