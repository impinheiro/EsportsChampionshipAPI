package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.usecases.championship.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.ChampionshipDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.ChampionshipCreationDto;
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

    private final ChampionshipDtoMapper mapper;
    private final CreateChampionshipCase createChampionshipCase;
    private final UpdateChampionshipCase updateChampionshipCase;
    private final DeleteChampionshipCase deleteChampionshipCase;
    private final FindAllChampionshipsCase findAllChampionshipsCase;
    private final FindChampionshipByIdCase  findChampionshipByIdCase;
    private final SubscribeRegistrationCase  subscribeRegistrationCase;
    private final SubscribeMatchCase  subscribeMatchCase;

    public ChampionshipController(ChampionshipDtoMapper mapper, CreateChampionshipCase createChampionshipCase, UpdateChampionshipCase updateChampionshipCase, DeleteChampionshipCase deleteChampionshipCase, FindAllChampionshipsCase findAllChampionshipsCase, FindChampionshipByIdCase findChampionshipByIdCase, SubscribeRegistrationCase subscribeRegistrationCase, SubscribeMatchCase subscribeMatchCase) {
        this.mapper = mapper;
        this.createChampionshipCase = createChampionshipCase;
        this.updateChampionshipCase = updateChampionshipCase;
        this.deleteChampionshipCase = deleteChampionshipCase;
        this.findAllChampionshipsCase = findAllChampionshipsCase;
        this.findChampionshipByIdCase = findChampionshipByIdCase;
        this.subscribeRegistrationCase = subscribeRegistrationCase;
        this.subscribeMatchCase = subscribeMatchCase;
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
        Map<String, Object> response = new HashMap<>();
        Championship subscribedChampionship = subscribeRegistrationCase.execute(championshipId, registrationdId);
        response.put("Registration submitted: ", mapper.toDto(subscribedChampionship));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("subscribematch/{championshipId}/{matchId}")
    public ResponseEntity<?> subscribeMatch(@PathVariable String championshipId, @PathVariable String matchId){
        Map<String, Object> response = new HashMap<>();
        Championship subscribedChampionship = subscribeMatchCase.execute(championshipId, matchId);
        response.put("Match submitted: ", mapper.toDto(subscribedChampionship));
        return ResponseEntity.ok(response);
    }
}
