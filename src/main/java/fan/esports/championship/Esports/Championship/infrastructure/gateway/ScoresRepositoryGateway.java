package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.core.domain.TeamScore;
import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.scores.players.PlayerScoreEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.scores.teams.TeamScoreEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.scores.PlayerScoreEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.scores.PlayerScoreRepository;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.scores.TeamScoreRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScoresRepositoryGateway implements ScoreGateway {

    private final PlayerScoreRepository playerScoreRepository;
    private final TeamScoreRepository teamScoreRepository;
    private final PlayerScoreEntityMapper playerScoreEntityMapper;
    private final TeamScoreEntityMapper teamScoreEntityMapper;

    public ScoresRepositoryGateway(PlayerScoreRepository playerScoreRepository, TeamScoreRepository teamScoreRepository, PlayerScoreEntityMapper playerScoreEntityMapper, TeamScoreEntityMapper teamScoreEntityMapper) {
        this.playerScoreRepository = playerScoreRepository;
        this.teamScoreRepository = teamScoreRepository;
        this.playerScoreEntityMapper = playerScoreEntityMapper;
        this.teamScoreEntityMapper = teamScoreEntityMapper;
    }

    @Override
    public PlayerScore createPlayerScore(PlayerScore playerScore) {
        PlayerScoreEntity playerScoreEntity = playerScoreEntityMapper.toEntity(playerScore);

        playerScoreEntity.setScore(0);
        playerScoreRepository.save(playerScoreEntity);

        return playerScoreEntityMapper.toDomain(playerScoreEntity);
    }

    @Override
    public PlayerScore findPlayerScoreById(String id) {
        PlayerScoreEntity playerScore = playerScoreRepository.findById(id).orElse(null);
        if(playerScore != null) {
            return playerScoreEntityMapper.toDomain(playerScore);
        }
        return null;
    }

    @Override
    public List<PlayerScore> findAllPlayerScores() {
        return List.of();
    }

    @Override
    public PlayerScore updatePlayerScore(String id, PlayerScore playerScore) {
        return null;
    }

    @Override
    public void deletePlayerScore(String id) {

    }

    @Override
    public TeamScore createTeamScore(TeamScore teamScore) {
        return null;
    }

    @Override
    public TeamScore findTeamScoreById(String id) {
        return null;
    }

    @Override
    public List<TeamScore> findAllTeamScores() {
        return List.of();
    }

    @Override
    public TeamScore updateTeamScore(String id, TeamScore teamScore) {
        return null;
    }

    @Override
    public void deleteTeamScore(String id) {

    }
}
