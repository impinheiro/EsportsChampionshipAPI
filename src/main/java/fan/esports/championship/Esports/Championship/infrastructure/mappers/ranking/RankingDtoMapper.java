package fan.esports.championship.Esports.Championship.infrastructure.mappers.ranking;

import fan.esports.championship.Esports.Championship.core.domain.Ranking;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.RankingDTO;
import fan.esports.championship.Esports.Championship.infrastructure.dtos.requests.NewRanking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RankingDtoMapper {


    public Ranking toDomain(NewRanking playerRanking) {
        return new Ranking(
                playerRanking.id(),
                playerRanking.championshipId(),
                new ArrayList<>()
        );
    }

    public RankingDTO toDto(Ranking playerRanking) {
        return new RankingDTO(
                playerRanking.id(),
                playerRanking.championshipId(),
                playerRanking.scores()
        );
    }

    public Ranking toDomain(RankingDTO dto) {
        return new Ranking(
                dto.id(),
                dto.championshipId(),
                dto.scores()
        );
    }
}
