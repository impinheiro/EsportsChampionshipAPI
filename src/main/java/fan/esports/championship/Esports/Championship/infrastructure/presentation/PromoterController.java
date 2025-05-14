package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.enums.RegistrationStatus;
import fan.esports.championship.Esports.Championship.core.usecases.promoters.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.RegistrationStatusQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/promoter")

public class PromoterController {

    private final FindProprietaryChampionshipsCase findProprietaryChampionshipsCase;
    private final FindPendingRegistrationsCase findPendingRegistrationsCase;
    private final FindPendingTeamRegistrationsCase findPendingTeamRegistrationsCase;
    private final ChangeRegistrationsStatusCase changeRegistrationsStatusCase;

    public PromoterController(FindProprietaryChampionshipsCase findProprietaryChampionshipsCase, FindPendingRegistrationsCase findPendingRegistrationsCase, FindPendingTeamRegistrationsCase findPendingTeamRegistrationsCase, ChangeRegistrationsStatusCase changeRegistrationsStatusCase) {
        this.findProprietaryChampionshipsCase = findProprietaryChampionshipsCase;
        this.findPendingRegistrationsCase = findPendingRegistrationsCase;
        this.findPendingTeamRegistrationsCase = findPendingTeamRegistrationsCase;
        this.changeRegistrationsStatusCase = changeRegistrationsStatusCase;
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

    @PutMapping("/manageRegistrations/{id}")
    public ResponseEntity<?> manageRegistrations(@PathVariable String id, @RequestBody RegistrationStatusQuery status) {
        changeRegistrationsStatusCase.execute(id, status.name().toUpperCase());
        return ResponseEntity.ok().build();
    }
}
