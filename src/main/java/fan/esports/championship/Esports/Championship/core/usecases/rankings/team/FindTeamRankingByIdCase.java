package fan.esports.championship.Esports.Championship.core.usecases.rankings.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;

public interface FindTeamRankingByIdCase {
    TeamRanking execute(String id);
}
