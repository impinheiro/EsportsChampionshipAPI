package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.domain.Team;


import fan.esports.championship.Esports.Championship.core.usecases.team.*;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamMember;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.responses.TeamResponse;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.team.TeamDtoMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserDtoMapper;
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
    private final UserDtoMapper userDtoMapper;
    private final TeamDtoMapper teamDtoMapper;
    private final FindTeamScheduledMatches  findTeamScheduledMatches;

    public TeamController(TeamDtoMapper mapper, CreateTeamCase createTeamCase, GetAllTeamsCase getAllTeamsCase, UpdateTeamCase updateTeamCase, GetTeamById getTeamById, UserDtoMapper userDtoMapper, TeamDtoMapper teamDtoMapper, FindTeamScheduledMatches findTeamScheduledMatches) {
        this.mapper = mapper;
        this.createTeamCase = createTeamCase;
        this.getAllTeamsCase = getAllTeamsCase;
        this.updateTeamCase = updateTeamCase;
        this.getTeamById = getTeamById;
        this.userDtoMapper = userDtoMapper;
        this.teamDtoMapper = teamDtoMapper;
        this.findTeamScheduledMatches = findTeamScheduledMatches;
    }

    @PostMapping("create")
    public ResponseEntity<Map<String,Object>> createTeam(@RequestBody TeamDTO teamDto){
        Map<String, Object> response = new HashMap<>();
        Team team = mapper.toDomain(teamDto);
        response.put("Team", team.name());
        response.put("Team members: ", team.membersId());
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
        List<TeamResponse>  teamResponse = teams.stream().map(mapper::toResponse).collect(Collectors.toList());
        if(teams != null){
            return ResponseEntity.ok(teamResponse);
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
            return ResponseEntity.ok(teamDtoMapper.toDTO(teamFound));
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable String id, @RequestBody TeamDTO teamDTO){
        Map<String, Object> response = new HashMap<>();
        Team team = mapper.toDomain(teamDTO);
        Team updatedTeam = updateTeamCase.execute(team, id);
        response.put("Message", "Team updated successfully");
        response.put("Team", teamDtoMapper.toDTO(updatedTeam));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getScheduledMatches/{teamId}")
    public ResponseEntity<?> getScheduledMatches(@PathVariable String teamId){
        List<Match> scheduledMatches = findTeamScheduledMatches.execute(teamId);
        return ResponseEntity.ok(scheduledMatches);
    }
}
