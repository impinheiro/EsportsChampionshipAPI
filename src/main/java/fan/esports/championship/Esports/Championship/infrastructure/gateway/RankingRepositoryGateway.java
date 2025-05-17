package fan.esports.championship.Esports.Championship.infrastructure.gateway;

import fan.esports.championship.Esports.Championship.core.domain.PlayerRanking;
import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.player.PlayerRankingEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.team.TeamRankingEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.PlayerRankingEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.PlayerRankingRepository;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.TeamRankingEntity;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.TeamRankingRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RankingRepositoryGateway implements RankingGateway {

    private final PlayerRankingEntityMapper playerRankingEntityMapper;
    private final TeamRankingEntityMapper teamRankingEntityMapper;
    private final PlayerRankingRepository playerRankingRepository;
    private final TeamRankingRepository teamRankingRepository;

    public RankingRepositoryGateway(PlayerRankingEntityMapper playerRankingEntityMapper, TeamRankingEntityMapper teamRankingEntityMapper, PlayerRankingRepository playerRankingRepository, TeamRankingRepository teamRankingRepository) {
        this.playerRankingEntityMapper = playerRankingEntityMapper;
        this.teamRankingEntityMapper = teamRankingEntityMapper;
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
    public Optional<PlayerRanking> findPlayerRankingById(String id) {
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
        TeamRankingEntity newTeamRanking = teamRankingEntityMapper.toEntity(teamRanking);
        newTeamRanking.setScores(new ArrayList<>());
        teamRankingRepository.save(newTeamRanking);
        return teamRankingEntityMapper.toDomain(newTeamRanking);
    }

    @Override
    public Optional<TeamRanking> findTeamRankingById(String id) {
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
