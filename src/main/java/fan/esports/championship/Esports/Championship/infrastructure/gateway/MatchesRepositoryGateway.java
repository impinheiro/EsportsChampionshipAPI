package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.domain.TeamMatch;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.matches.MatchEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.matches.TeamMatchEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.team.TeamEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.user.UserEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.MatchEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.MatchRepository;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.TeamMatchEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.match.TeamMatchRepository;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.team.TeamEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.user.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MatchesRepositoryGateway implements MatchGateway {

    private final MatchRepository matchRepository;
    private final TeamMatchRepository teamMatchRepository;
    private final MatchEntityMapper matchEntityMapper;
    private final UserEntityMapper userEntityMapper;
    private final TeamEntityMapper teamEntityMapper;
    private final TeamMatchEntityMapper teamMatchEntityMapper;

    public MatchesRepositoryGateway(MatchRepository matchRepository, TeamMatchRepository teamMatchRepository, MatchEntityMapper matchEntityMapper, UserEntityMapper userEntityMapper, TeamEntityMapper teamEntityMapper, TeamMatchEntityMapper teamMatchEntityMapper) {
        this.matchRepository = matchRepository;
        this.teamMatchRepository = teamMatchRepository;
        this.matchEntityMapper = matchEntityMapper;
        this.userEntityMapper = userEntityMapper;
        this.teamEntityMapper = teamEntityMapper;
        this.teamMatchEntityMapper = teamMatchEntityMapper;
    }

    @Override
    public Match create(Match match) {
        MatchEntity matchEntity = matchEntityMapper.toEntity(match);
        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());
        matchEntity.setMatchInfo("Winner(s): ");
        matchRepository.save(matchEntity);
        return matchEntityMapper.toDomain(matchEntity);
    }

    @Override
    public Match update(String id, Match match) {
        MatchEntity matchToBeUpdated = matchRepository.findById(id).orElse(null);
        List<UserEntity> participants = match.participants()
                .stream()
                .map(userEntityMapper::toEntity)
                .collect(Collectors.toList()
                );
        matchToBeUpdated.setParticipants(participants);
        matchToBeUpdated.setName(match.name());
        matchToBeUpdated.setMatchInfo(match.matchInfo());
        matchToBeUpdated.setUpdatedAt(LocalDateTime.now());
        matchRepository.save(matchToBeUpdated);
        return matchEntityMapper.toDomain(matchToBeUpdated);
    }

    @Override
    public void delete(String id) {
        MatchEntity matchToBeDeleted = matchRepository.findById(id).orElse(null);
        matchRepository.delete(matchToBeDeleted);
    }

    @Override
    public Optional<Match> findById(String id) {
        MatchEntity matchEntity = matchRepository.findById(id).orElse(null);
        if (matchEntity != null) {
            return Optional.of(matchEntityMapper.toDomain(matchEntity));
        }
        return Optional.empty();
    }

    @Override
    public List<Match> findAll() {
        List<MatchEntity> matches = matchRepository.findAll();
        return matches
                .stream()
                .map(matchEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public TeamMatch createTeamMatch(TeamMatch teamMatch) {
        TeamMatchEntity teamMatchEntity = teamMatchEntityMapper.toEntity(teamMatch);
        teamMatchEntity.setMatchInfo("Winner(s): ");
        teamMatchEntity.setCreatedAt(LocalDateTime.now());
        teamMatchEntity.setUpdatedAt(LocalDateTime.now());
        teamMatchRepository.save(teamMatchEntity);
        return teamMatchEntityMapper.toDomain(teamMatchEntity);
    }

    @Override
    public TeamMatch updateTeamMatch(String id, TeamMatch teamMatch) {
        TeamMatchEntity teamMatchEntity = teamMatchRepository.findById(id).orElse(null);
        List<TeamEntity> participants = teamMatch.participants().stream().map(teamEntityMapper::toEntity).collect(Collectors.toList());
        teamMatchEntity.setParticipants(participants);
        teamMatchEntity.setName(teamMatch.name());
        teamMatchEntity.setMatchInfo(teamMatch.matchInfo());
        teamMatchEntity.setUpdatedAt(LocalDateTime.now());
        teamMatchRepository.save(teamMatchEntity);
        return teamMatchEntityMapper.toDomain(teamMatchEntity);
    }

    @Override
    public void deleteTeamMatch(String id) {
        TeamMatchEntity teamMatchEntity = teamMatchRepository.findById(id).orElse(null);
        teamMatchRepository.delete(teamMatchEntity);
    }

    @Override
    public Optional<TeamMatch> findTeamMatchById(String id) {
        TeamMatchEntity  teamMatchEntity = teamMatchRepository.findById(id).orElse(null);
        if (teamMatchEntity != null) {
            return Optional.of(
                    teamMatchEntityMapper.toDomain(teamMatchEntity)
            );
        }
        return Optional.empty();
    }

    @Override
    public List<TeamMatch> findAllTeamMatches() {
        List<TeamMatchEntity>  teamMatchEntities = teamMatchRepository.findAll();
        return teamMatchEntities
                .stream()
                .map(teamMatchEntityMapper::toDomain)
                .collect(Collectors.toList()
                );
    }
}
