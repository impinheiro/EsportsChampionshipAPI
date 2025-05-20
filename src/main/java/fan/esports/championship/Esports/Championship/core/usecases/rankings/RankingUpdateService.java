package fan.esports.championship.Esports.Championship.core.usecases.rankings;

import fan.esports.championship.Esports.Championship.core.domain.*;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;

import java.util.*;

public class RankingUpdateService{


    private final RankingGateway rankingGateway;
    private final ChampionshipGateway championshipGateway;

    public RankingUpdateService(RankingGateway rankingGateway, ChampionshipGateway championshipGateway) {
        this.rankingGateway = rankingGateway;
        this.championshipGateway = championshipGateway;
    }

    public void updateRankingForMatch(Match match) {
        Championship championship = championshipGateway.findById(match.championshipId())
                .orElseThrow(() -> new RuntimeException("Championship not found"));

        Ranking ranking = rankingGateway.findById(championship.rankingId())
                .orElseThrow(() -> new RuntimeException("Ranking not found"));

        List<Score> updatedScores = new ArrayList<>();

        for (MatchResults result : match.results()) {
            boolean isWinner = result.placement() == 1;
            int points = isWinner ? 3 : 0;

            updatedScores.add(new Score(result.participantId(), points));
        }

        Ranking newRanking = new Ranking(null,null, updatedScores);
        rankingGateway.update(ranking.id(), newRanking);
    }
}