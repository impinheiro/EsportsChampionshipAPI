package fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.infrastructure.persistence.rankings.TeamRankingEntity;
import org.springframework.stereotype.Component;


@Component
public class TeamRankingEntityMapper {

    public TeamRankingEntity toEntity(TeamRanking teamRanking) {
        return new TeamRankingEntity(
                teamRanking.id(),
                teamRanking.championshipId(),
                teamRanking.scores()
        );
    }

    public TeamRanking toDomain(TeamRankingEntity teamRankingEntity) {
        return new TeamRanking(
                teamRankingEntity.getId(),
                teamRankingEntity.getChampionshipId(),
                teamRankingEntity.getScores()
        );
    }
}
