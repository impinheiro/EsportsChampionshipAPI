package fan.esports.championship.Esports.Championship.core.usecases.scores.team;

import fan.esports.championship.Esports.Championship.core.domain.Team;

public interface DeleteTeamScoreCase {
    void execute(String id);
}
