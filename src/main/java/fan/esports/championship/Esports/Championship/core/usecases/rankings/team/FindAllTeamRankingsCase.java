package fan.esports.championship.Esports.Championship.core.usecases.rankings.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamRanking;

import java.util.List;

public interface FindAllTeamRankingsCase {
    List<TeamRanking> execute();
}
