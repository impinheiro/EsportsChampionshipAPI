package fan.esports.championship.Esports.Championship.core.usecases.scores.team;

import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

public class DeleteTeamScoreCaseImpl implements DeleteTeamScoreCase {
    private final ScoreGateway scoreGateway;

    public DeleteTeamScoreCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public void execute(String id) {
        scoreGateway.deleteTeamScore(id);
    }
}
