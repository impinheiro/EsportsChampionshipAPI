package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Registration;
import fan.esports.championship.Esports.Championship.core.domain.TeamRegistration;
import fan.esports.championship.Esports.Championship.core.usecases.championship.*;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.FindRegistrationByIdCase;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.FindTeamRegistrationByIdCase;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.ChampionshipDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.ChampionshipCreationDto;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.RegistrationProof;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.championships.ChampionshipDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/championship")
public class ChampionshipController {

    private final FindTeamRegistrationByIdCase findTeamRegistrationByIdCase;
    private final ChampionshipDtoMapper mapper;
    private final CreateChampionshipCase createChampionshipCase;
    private final UpdateChampionshipCase updateChampionshipCase;
    private final DeleteChampionshipCase deleteChampionshipCase;
    private final FindAllChampionshipsCase findAllChampionshipsCase;
    private final FindChampionshipByIdCase  findChampionshipByIdCase;
    private final SubscribeRegistrationCase  subscribeRegistrationCase;
    private final SubscribeMatchCase  subscribeMatchCase;
    private final FindRegistrationByIdCase findRegistrationByIdCase;
    private final FindAvailableChampionshipsCase findAvailableChampionshipsCase;
    private final FindExpiredChampionshipsCase findExpiredChampionshipsCase;
    private final FindByGameNameCase findByGameNameCase;
    private final FindByChampionshipTypeCase findByChampionshipTypeCase;
    private final FindByChampionshipFormatCase findByChampionshipFormatCase;

    public ChampionshipController(ChampionshipDtoMapper mapper, CreateChampionshipCase createChampionshipCase, UpdateChampionshipCase updateChampionshipCase, DeleteChampionshipCase deleteChampionshipCase, FindAllChampionshipsCase findAllChampionshipsCase, FindChampionshipByIdCase findChampionshipByIdCase, SubscribeRegistrationCase subscribeRegistrationCase, SubscribeMatchCase subscribeMatchCase, FindRegistrationByIdCase findRegistrationByIdCase, FindTeamRegistrationByIdCase findTeamRegistrationByIdCase, FindAvailableChampionshipsCase findAvailableChampionshipsCase, FindExpiredChampionshipsCase findExpiredChampionshipsCase, FindByGameNameCase findByGameNameCase, FindByChampionshipTypeCase findByChampionshipTypeCase, FindByChampionshipFormatCase findByChampionshipFormatCase) {
        this.mapper = mapper;
        this.createChampionshipCase = createChampionshipCase;
        this.updateChampionshipCase = updateChampionshipCase;
        this.deleteChampionshipCase = deleteChampionshipCase;
        this.findAllChampionshipsCase = findAllChampionshipsCase;
        this.findChampionshipByIdCase = findChampionshipByIdCase;
        this.subscribeRegistrationCase = subscribeRegistrationCase;
        this.subscribeMatchCase = subscribeMatchCase;
        this.findRegistrationByIdCase = findRegistrationByIdCase;
        this.findTeamRegistrationByIdCase = findTeamRegistrationByIdCase;
        this.findAvailableChampionshipsCase = findAvailableChampionshipsCase;
        this.findExpiredChampionshipsCase = findExpiredChampionshipsCase;
        this.findByGameNameCase = findByGameNameCase;
        this.findByChampionshipTypeCase = findByChampionshipTypeCase;
        this.findByChampionshipFormatCase = findByChampionshipFormatCase;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ChampionshipCreationDto championshipDTO){
        Map<String, Object> response = new HashMap<>();
        Championship championship = mapper.toDomain(championshipDTO);
        createChampionshipCase.execute(championship);
        response.put("Championship created: ", mapper.toDto(championship));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Map<String, Object> response = new HashMap<>();
        Championship championship = findChampionshipByIdCase.execute(id);
        response.put("Championship", mapper.toDto(championship));
        return ResponseEntity.ok(response);
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll(){
        Map<String, Object> response = new HashMap<>();
        List<Championship> foundChampionships = findAllChampionshipsCase.execute();
        response.put("Championships: ", foundChampionships
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(response);
    }

    @GetMapping("findAvailable")
    public ResponseEntity<?> findAvailable(){
        Map<String, Object> response = new HashMap<>();
        response.put("Available Championships", findAvailableChampionshipsCase.execute());
        return ResponseEntity.ok(response);
    }

    @GetMapping("findExpired")
    public ResponseEntity<?> findAllChampionships(){
        Map<String, Object> response = new HashMap<>();
        response.put("Expired Championships", findExpiredChampionshipsCase.execute());
        return ResponseEntity.ok(response);
    }

    @GetMapping("findByGameName")
    public ResponseEntity<?> findByGameName(@RequestParam String gameName){
        List<ChampionshipDTO> championships = findByGameNameCase.execute(gameName).stream().map(mapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(championships);
    }

    @GetMapping("findByType")
    public ResponseEntity<?> findByType(@RequestParam String type){
        List<ChampionshipDTO> championships = findByChampionshipTypeCase.execute(type).stream().map(mapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(championships);
    }

    @GetMapping("findByFormat")
    public ResponseEntity<?> findByFormat(@RequestParam String format){
        List<ChampionshipDTO> championships = findByChampionshipFormatCase.execute(format).stream().map(mapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(championships);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ChampionshipDTO championshipDTO){
        Map<String, Object> response = new HashMap<>();
        Championship updatedData = mapper.toDomain(championshipDTO);
        Championship championship = updateChampionshipCase.execute(id, updatedData);
        response.put("Championship updated", mapper.toDto(championship));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Map<String, Object> response = new HashMap<>();
        deleteChampionshipCase.execute(id);
        response.put("Success", "Championship of id " + id + " has been deleted.");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @PatchMapping("subscriberegistration/{championshipId}/{registrationdId}")
    public ResponseEntity<?> subscribeRegistration(@PathVariable String championshipId, @PathVariable String registrationdId){
        Championship subscribedChampionship = subscribeRegistrationCase.execute(championshipId, registrationdId);
        RegistrationProof proof;
        if(subscribedChampionship.type().toString() == "INDIVIDUAL"){
            Registration registration = findRegistrationByIdCase.execute(registrationdId);
            proof = new RegistrationProof(
                    registration.user().name(),
                    subscribedChampionship.startDate(),
                    subscribedChampionship.rules(),
                    subscribedChampionship.awardDescription()
            );
        }else{
            TeamRegistration registration = findTeamRegistrationByIdCase.execute(registrationdId);
            proof = new RegistrationProof(
                    registration.team().name(),
                    subscribedChampionship.startDate(),
                    subscribedChampionship.rules(),
                    subscribedChampionship.awardDescription()
            );
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(proof);
    }

    @PatchMapping("subscribematch/{championshipId}/{matchId}")
    public ResponseEntity<?> subscribeMatch(@PathVariable String championshipId, @PathVariable String matchId){
        Map<String, Object> response = new HashMap<>();
        Championship subscribedChampionship = subscribeMatchCase.execute(championshipId, matchId);
        response.put("Match submitted: ", mapper.toDto(subscribedChampionship));
        return ResponseEntity.ok(response);
    }
}


