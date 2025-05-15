package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.player.PlayerRankingEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.team.TeamRankingEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.PlayerRankingEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.PlayerRankingRepository;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.TeamRankingRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RankingRepositoryGateway implements RankingGateway {

    private PlayerRankingEntityMapper playerRankingEntityMapper;
    private TeamRankingEntityMapper teamRankingEntityMapper;
    private final PlayerRankingRepository playerRankingRepository;
    private final TeamRankingRepository teamRankingRepository;

    public RankingRepositoryGateway(PlayerRankingRepository playerRankingRepository, TeamRankingRepository teamRankingRepository) {
        this.playerRankingRepository = playerRankingRepository;
        this.teamRankingRepository = teamRankingRepository;
    }

    @Override
    public PlayerRanking createPlayerRanking(PlayerRanking playerRanking) {
        PlayerRankingEntity newPlayerRanking = playerRankingEntityMapper.toEntity(playerRanking);
        newPlayerRanking.setScores(new ArrayList<>());
        playerRankingRepository.save(newPlayerRanking);
        return playerRankingEntityMapper.toDomain(newPlayerRanking);
    }

    @Override
    public PlayerRanking findPlayerRankingById(String id) {
        return null;
    }

    @Override
    public List<PlayerRanking> findAllPlayerRankings() {
        return List.of();
    }

    @Override
    public PlayerRanking updatePlayerRanking(String id, PlayerRanking playerRanking) {
        return null;
    }

    @Override
    public void deletePlayerRanking(String id) {

    }

    @Override
    public TeamRanking createTeamRanking(TeamRanking teamRanking) {
        return null;
    }

    @Override
    public TeamRanking findTeamRankingById(String id) {
        return null;
    }

    @Override
    public List<TeamRanking> findAllTeamRankings() {
        return List.of();
    }

    @Override
    public TeamRanking updateTeamRanking(String id, TeamRanking teamRanking) {
        return null;
    }

    @Override
    public void deleteTeamRanking(String id) {

    }
}
