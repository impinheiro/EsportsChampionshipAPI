package fan.esports.championship.Esports.Championship.core.usecases.scores.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamScore;
import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

public class UpdateTeamScoreCaseImpl implements UpdateTeamScoreCase {

    private final ScoreGateway scoreGateway;

    public UpdateTeamScoreCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public TeamScore execute(String id, TeamScore score) {
        return scoreGateway.updateTeamScore(id, score);
    }
}
