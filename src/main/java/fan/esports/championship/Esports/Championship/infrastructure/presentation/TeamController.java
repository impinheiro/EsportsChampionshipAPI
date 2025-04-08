package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Team;


import fan.esports.championship.Esports.Championship.core.usecases.team.CreateTeamCase;
import fan.esports.championship.Esports.Championship.core.usecases.team.GetAllTeamsCase;
import fan.esports.championship.Esports.Championship.core.usecases.team.GetTeamById;
import fan.esports.championship.Esports.Championship.core.usecases.team.UpdateTeamCase;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.team.TeamDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/teams")
public class TeamController {

    private final TeamDtoMapper mapper;
    private final CreateTeamCase createTeamCase;
    private final GetAllTeamsCase  getAllTeamsCase;
    private final UpdateTeamCase updateTeamCase;
    private final GetTeamById getTeamById;

    public TeamController(TeamDtoMapper mapper, CreateTeamCase createTeamCase, GetAllTeamsCase getAllTeamsCase, UpdateTeamCase updateTeamCase, GetTeamById getTeamById) {
        this.mapper = mapper;
        this.createTeamCase = createTeamCase;
        this.getAllTeamsCase = getAllTeamsCase;
        this.updateTeamCase = updateTeamCase;
        this.getTeamById = getTeamById;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String,Object>> createTeam(@RequestBody TeamDTO teamDto){
        Map<String, Object> response = new HashMap<>();
        Team team = mapper.toDomain(teamDto);
        response.put("Team", team.name());
        response.put("Team members: ",  team.members()
                .stream()
                .map(member -> member.nickname())
                .toList());
        Team newTeam = createTeamCase.execute(team);
        if(team != null){
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAllTeams(){
        List<Team> teams = getAllTeamsCase.execute();
        List<TeamDTO>  teamDTOs = teams.stream().map(mapper::toDTO).collect(Collectors.toList());
        if(teams != null){
            return ResponseEntity.ok(teamDTOs);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no teams registered yet");
        }
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<?> findTeamById(@PathVariable String id){
        Team teamFound = getTeamById.execute(id);
        if(teamFound == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team not found");
        } else{
            return ResponseEntity.ok(teamFound);
        }
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable String id, @RequestBody TeamDTO teamDTO){
        Map<String, Object> response = new HashMap<>();
        Team team = mapper.toDomain(teamDTO);
        updateTeamCase.execute(team, id);
        response.put("Message", "Team updated successfully");
        response.put("Team", updateTeamCase.execute(team, id));
        return ResponseEntity.ok(response);
    }
}
