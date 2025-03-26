package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Team;
import fan.esports.championship.Esports.Championship.core.gateway.TeamGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.TeamEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TeamRepositoryGateway implements TeamGateway {


    private final TeamRepository teamRepository;
    private final TeamEntityMapper mapper;
    private final UserEntityMapper userMapper;

    public TeamRepositoryGateway(TeamRepository teamRepository, TeamEntityMapper mapper, UserEntityMapper userMapper) {
        this.teamRepository = teamRepository;
        this.mapper = mapper;
        this.userMapper = userMapper;
    }


    @Override
    public Team findTeamById(String id) {
        TeamEntity team = teamRepository.findById(id).orElse(null);
         return mapper.toDomain(team);
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
        teamEntity.setCreatedAt(LocalDateTime.now());
        teamEntity.setUpdatedAt(LocalDateTime.now());
        TeamEntity teamEntitySaved = teamRepository.save(teamEntity);
        return mapper.toDomain(teamEntitySaved);
    }

    @Override
    public Team updateTeam(Team team, String id) {

        TeamEntity teamEntity = teamRepository.findById(id).orElse(null);
        teamEntity.setName(team.name());
        teamEntity.setMembers(team.members()
                .stream()
                .map(userMapper::toEntity)
                .collect(Collectors.toList()));
        teamEntity.setUpdatedAt(LocalDateTime.now());
        teamRepository.save(teamEntity);
        return mapper.toDomain(teamEntity);
    }

    @Override
    public void deleteTeam(String id) {
        TeamEntity teamEntity = teamRepository.findById(id).orElse(null);
        teamRepository.delete(teamEntity);
    }
}
