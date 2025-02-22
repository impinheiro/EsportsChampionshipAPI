package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.TeamEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamRepository;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamRepositoryGateway implements TeamGateway {


    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final TeamEntityMapper mapper;

    public TeamRepositoryGateway(TeamRepository teamRepository, UserRepository userRepository, TeamEntityMapper mapper) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public Team findTeamById(String id) {
        return null;
    }

    @Override
    public List<Team> findAllTeams() {
        List<TeamEntity> teamEntities = teamRepository.findAll();
        return teamEntities.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Team createTeam(Team team) {
        TeamEntity teamEntity = mapper.toEntity(team);
        TeamEntity teamEntitySaved = teamRepository.save(teamEntity);
        return mapper.toDomain(teamEntitySaved);
    }

    @Override
    public Team updateTeam(Team team, String id) {
        return null;
    }

    @Override
    public void deleteTeam(String id) {

    }
}
