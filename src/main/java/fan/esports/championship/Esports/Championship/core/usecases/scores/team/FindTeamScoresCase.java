package fan.esports.championship.Esports.Championship.core.usecases.scores.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamScore;

import java.util.List;

public interface FindTeamScoresCase {
    List<TeamScore> execute();
}
