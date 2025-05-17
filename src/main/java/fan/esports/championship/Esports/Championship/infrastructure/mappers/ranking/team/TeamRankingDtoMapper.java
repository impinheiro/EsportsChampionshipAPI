package fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.TeamRankingDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewRanking;

import java.util.ArrayList;

public class TeamRankingDtoMapper {

    public TeamRanking toDomain(NewRanking teamRanking) {
        return new TeamRanking(
                teamRanking.id(),
                teamRanking.championshipId(),
                new ArrayList<>()
        );
    }

    public TeamRankingDTO toDto(TeamRanking teamRanking) {
        return new TeamRankingDTO(
                teamRanking.id(),
                teamRanking.championshipId(),
                teamRanking.scores()
        );
    }

    public TeamRanking toDomain(TeamRankingDTO dto) {
        return new TeamRanking(
                dto.id(),
                dto.championshipId(),
                dto.scores()
        );
    }
}


