package fan.esports.championship.Esports.Championship.core.usecases.matches;

import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.RankingUpdateService;
import fan.esports.championship.Esports.Championship.core.domain.Championship;
import fan.esports.championship.Esports.Championship.core.domain.Match;
import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;

public class UpdateMatchCaseImpl implements  UpdateMatchCase {

    private final MatchGateway matchGateway;
    private final ChampionshipGateway championshipGateway;
    private final RankingGateway rankingGateway;
    private final RankingUpdateService rankingUpdateService;

    public UpdateMatchCaseImpl(MatchGateway matchGateway,
                               ChampionshipGateway championshipGateway,
                               RankingGateway rankingGateway) {
        this.matchGateway = matchGateway;
        this.championshipGateway = championshipGateway;
        this.rankingGateway = rankingGateway;
        this.rankingUpdateService = new RankingUpdateService(rankingGateway, championshipGateway);
    }

    @Override
    public Match execute(String id, Match match) {
        Match updatedMatch = matchGateway.update(id, match);
        rankingUpdateService.updateRankingForMatch(updatedMatch);
        return updatedMatch;
    }
}

