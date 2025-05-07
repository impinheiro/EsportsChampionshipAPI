package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.usecases.promoters.FindPendingRegistrationsCase;
import fan.esports.championship.Esports.Championship.core.usecases.promoters.FindPendingTeamRegistrationsCase;
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
    private final FindPendingRegistrationsCase findPendingRegistrationsCase;
    private final FindPendingTeamRegistrationsCase findPendingTeamRegistrationsCase;

    public PromoterController(FindProprietaryChampionshipsCase findProprietaryChampionshipsCase, FindPendingRegistrationsCase findPendingRegistrationsCase, FindPendingTeamRegistrationsCase findPendingTeamRegistrationsCase) {
        this.findProprietaryChampionshipsCase = findProprietaryChampionshipsCase;
        this.findPendingRegistrationsCase = findPendingRegistrationsCase;
        this.findPendingTeamRegistrationsCase = findPendingTeamRegistrationsCase;
    }

    @GetMapping("findChampionships")
    public ResponseEntity<?> findProprietaryChampionshipsCase() {
        List<Championship> championships = findProprietaryChampionshipsCase.execute();
        return ResponseEntity.ok(championships);
    }

    @GetMapping("findPendingRegistrations")
    public ResponseEntity<?> findPendingRegistrationsCase() {
        List<Registration> registrations = findPendingRegistrationsCase.execute();
        return ResponseEntity.ok(registrations);
    }

    @GetMapping("/team/findPendingRegistrations")
    public ResponseEntity<?> findPendingTeamRegistrationsCase() {
        List<TeamRegistration> registrations = findPendingTeamRegistrationsCase.execute();
        return ResponseEntity.ok(registrations);
    }
}
