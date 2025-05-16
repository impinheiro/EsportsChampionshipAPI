package fan.esports.championship.Esports.Championship.core.usecases.scores.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamScore;

public interface FindTeamScoreByIdCase {
    TeamScore execute(String id);
}
