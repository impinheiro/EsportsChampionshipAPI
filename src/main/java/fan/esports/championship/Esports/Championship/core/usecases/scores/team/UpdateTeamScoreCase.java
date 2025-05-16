package fan.esports.championship.Esports.Championship.core.usecases.scores.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamScore;

public interface UpdateTeamScoreCase {
    TeamScore execute(String id, TeamScore score);
}
