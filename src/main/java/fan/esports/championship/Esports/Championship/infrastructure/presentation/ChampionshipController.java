package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.*;
import fan.esports.championship.Esports.Championship.core.enums.ChampionshipType;
import fan.esports.championship.Esports.Championship.core.enums.Games;
import fan.esports.championship.Esports.Championship.core.usecases.championship.*;
import fan.esports.championship.Esports.Championship.core.usecases.matches.SetMatchChampionshipIdCase;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.CreateRankingCase;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.CreateRegistrationCase;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.FindRegistrationByIdCase;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.ChampionshipDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.RegistrationDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.ChampionshipCreationDto;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewRanking;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.RegistrationProof;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.championships.ChampionshipDtoMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.RankingDtoMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.registration.RegistrationDtoMapper;
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
    private final CreateRankingCase createRankingCase;
    private final SetChampionshipRankingCase setChampionshipRankingCase;
    private final RankingDtoMapper rankingDtoMapper;
    private final UpdateChampionshipCase updateChampionshipCase;
    private final DeleteChampionshipCase deleteChampionshipCase;
    private final FindAllChampionshipsCase findAllChampionshipsCase;
    private final FindChampionshipByIdCase  findChampionshipByIdCase;
    private final SubscribeRegistrationCase  subscribeRegistrationCase;
    private final SubscribeMatchCase  subscribeMatchCase;
    private final RegistrationDtoMapper registrationDtoMapper;
    private final FindAvailableChampionshipsCase findAvailableChampionshipsCase;
    private final FindExpiredChampionshipsCase findExpiredChampionshipsCase;
    private final FindByGameNameCase findByGameNameCase;
    private final FindByChampionshipTypeCase findByChampionshipTypeCase;
    private final FindByChampionshipFormatCase findByChampionshipFormatCase;
    private final CreateRegistrationCase createRegistrationCase;
    private final SetMatchChampionshipIdCase setMatchChampionshipIdCase;

    public ChampionshipController(ChampionshipDtoMapper mapper, CreateChampionshipCase createChampionshipCase, CreateRankingCase createRankingCase, SetChampionshipRankingCase setChampionshipRankingCase, RankingDtoMapper rankingDtoMapper, UpdateChampionshipCase updateChampionshipCase, DeleteChampionshipCase deleteChampionshipCase, FindAllChampionshipsCase findAllChampionshipsCase, FindChampionshipByIdCase findChampionshipByIdCase, SubscribeRegistrationCase subscribeRegistrationCase, SubscribeMatchCase subscribeMatchCase, RegistrationDtoMapper registrationDtoMapper, FindAvailableChampionshipsCase findAvailableChampionshipsCase, FindExpiredChampionshipsCase findExpiredChampionshipsCase, FindByGameNameCase findByGameNameCase, FindByChampionshipTypeCase findByChampionshipTypeCase, FindByChampionshipFormatCase findByChampionshipFormatCase, CreateRegistrationCase createRegistrationCase, SetMatchChampionshipIdCase setMatchChampionshipIdCase) {
        this.mapper = mapper;
        this.createChampionshipCase = createChampionshipCase;
        this.createRankingCase = createRankingCase;
        this.setChampionshipRankingCase = setChampionshipRankingCase;
        this.rankingDtoMapper = rankingDtoMapper;
        this.updateChampionshipCase = updateChampionshipCase;
        this.deleteChampionshipCase = deleteChampionshipCase;
        this.findAllChampionshipsCase = findAllChampionshipsCase;
        this.findChampionshipByIdCase = findChampionshipByIdCase;
        this.subscribeRegistrationCase = subscribeRegistrationCase;
        this.subscribeMatchCase = subscribeMatchCase;
        this.registrationDtoMapper = registrationDtoMapper;
        this.findAvailableChampionshipsCase = findAvailableChampionshipsCase;
        this.findExpiredChampionshipsCase = findExpiredChampionshipsCase;
        this.findByGameNameCase = findByGameNameCase;
        this.findByChampionshipTypeCase = findByChampionshipTypeCase;
        this.findByChampionshipFormatCase = findByChampionshipFormatCase;
        this.createRegistrationCase = createRegistrationCase;
        this.setMatchChampionshipIdCase = setMatchChampionshipIdCase;
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ChampionshipCreationDto championshipDTO){
        Map<String, Object> response = new HashMap<>();

        Championship championship = mapper.toDomain(championshipDTO);

        Championship createdChampionship = createChampionshipCase.execute(championship);

        NewRanking ranking = new NewRanking(null, createdChampionship.id());
        Ranking newRanking = rankingDtoMapper.toDomain(ranking);
        Ranking createdRanking = createRankingCase.execute(newRanking);

        setChampionshipRankingCase.execute(createdChampionship.id(), createdRanking.id());

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
        List<Championship> foundChampionships = findAvailableChampionshipsCase.execute();
        response.put("Available Championships", foundChampionships
                .stream()
                .map(mapper::toInfo)
                .collect(Collectors.toList()));
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

    @PostMapping("submitregistration/{championshipId}")
    public ResponseEntity<?> subscribeRegistration(@PathVariable String championshipId){

        RegistrationDTO registrationDto = new RegistrationDTO(null, null, championshipId, null);

        Registration registration = registrationDtoMapper.toDomain(registrationDto);
        Registration createdRegistration = createRegistrationCase.execute(registration);

        Championship subscribedChampionship = subscribeRegistrationCase.execute(championshipId, createdRegistration.id());

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping("submitteamregistration/{championshipId}")
    public ResponseEntity<?> submitTeamRegistration(@PathVariable String championshipId, @RequestParam String teamId){

        RegistrationDTO registrationDto = new RegistrationDTO(null, teamId, championshipId, null);

        Registration registration = registrationDtoMapper.toDomain(registrationDto);
        Registration createdRegistration = createRegistrationCase.execute(registration);

        subscribeRegistrationCase.execute(championshipId, createdRegistration.id());

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PatchMapping("subscribematch/{championshipId}/{matchId}")
    public ResponseEntity<?> subscribeMatch(@PathVariable String championshipId, @PathVariable String matchId){
        Map<String, Object> response = new HashMap<>();
        Championship championship = findChampionshipByIdCase.execute(championshipId);
        Championship subscribedChampionship = subscribeMatchCase.execute(championshipId, matchId);
        setMatchChampionshipIdCase.execute(matchId, championshipId);
        response.put("Match submitted: ", mapper.toDto(subscribedChampionship));
        return ResponseEntity.ok(response);
    }
}


