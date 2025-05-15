package fan.esports.championship.Esports.Championship.core.usecases.rankings.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;

public interface CreateTeamRankingCase {
    TeamRanking execute(TeamRanking teamRanking);
}
