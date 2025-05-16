package fan.esports.championship.Esports.Championship.core.usecases.scores.player;

import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

public class DeletePlayerScoreCaseImpl implements DeletePlayerScoreCase {
    private final ScoreGateway scoreGateway;

    public DeletePlayerScoreCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public void execute(String id) {
        scoreGateway.deletePlayerScore(id);
    }
}
