package fan.esports.championship.Esports.Championship.infrastructure.presentation;

import fan.esports.championship.Esports.Championship.core.domain.Team;


import fan.esports.championship.Esports.Championship.core.usecases.team.CreateTeamCase;
import fan.esports.championship.Esports.Championship.core.usecases.team.GetAllTeamsCase;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamDTO;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.TeamDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamDtoMapper mapper;
    private final CreateTeamCase createTeamCase;
    private final GetAllTeamsCase  getAllTeamsCase;

    public TeamController(TeamDtoMapper mapper, CreateTeamCase createTeamCase, GetAllTeamsCase getAllTeamsCase) {
        this.mapper = mapper;
        this.createTeamCase = createTeamCase;
        this.getAllTeamsCase = getAllTeamsCase;
    }

    @PostMapping("create")
    public TeamDTO createTeam(@RequestBody TeamDTO teamDto){
        Team team = mapper.toDomain(teamDto);
        Team newTeam = createTeamCase.execute(team);
        return mapper.toDTO(newTeam);
    }

    @GetMapping("findAll")
    public List<TeamDTO> findAllTeams(List<?> teamDTO){
        List<Team> teams = getAllTeamsCase.execute();
        return teams.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
