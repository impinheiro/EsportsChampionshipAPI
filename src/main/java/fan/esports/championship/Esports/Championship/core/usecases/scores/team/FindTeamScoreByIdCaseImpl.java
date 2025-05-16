package fan.esports.championship.Esports.Championship.core.usecases.scores.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamScore;
import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

public class FindTeamScoreByIdCaseImpl implements FindTeamScoreByIdCase {

    private final ScoreGateway scoreGateway;

    public FindTeamScoreByIdCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public TeamScore execute(String id) {
        return scoreGateway.findTeamScoreById(id).orElse(null);
    }
}
