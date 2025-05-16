package fan.esports.championship.Esports.Championship.core.usecases.scores.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

public class UpdatePlayerScoreCaseImpl implements UpdatePlayerScoreCase {

    private final ScoreGateway scoreGateway;

    public UpdatePlayerScoreCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public PlayerScore execute(String id, PlayerScore score) {
        return scoreGateway.updatePlayerScore(id, score);
    }
}
