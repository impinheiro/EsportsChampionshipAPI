package fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.championships.ChampionShipEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.mappers.scores.teams.TeamScoreEntityMapper;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.TeamRankingEntity;

import java.util.stream.Collectors;

public class TeamRankingEntityMapper {

    private TeamScoreEntityMapper teamScoreEntityMapper;

    private ChampionShipEntityMapper championShipEntityMapper;

    public TeamRankingEntity toEntity(TeamRanking teamRanking) {
        return new TeamRankingEntity(
                teamRanking.id(),
                championShipEntityMapper.toEntity(teamRanking.championship()),
                teamRanking.scores()
                        .stream()
                        .map(teamScoreEntityMapper::toEntity)
                        .collect(Collectors.toList())
        );
    }

    public TeamRanking toDomain(TeamRankingEntity teamRankingEntity) {
        return new TeamRanking(
                teamRankingEntity.getId(),
                championShipEntityMapper.toDomain(teamRankingEntity.getChampionship()),
                teamRankingEntity.getScores()
                        .stream()
                        .map(teamScoreEntityMapper::toDomain)
                        .collect(Collectors.toList())
        );
    }
}
