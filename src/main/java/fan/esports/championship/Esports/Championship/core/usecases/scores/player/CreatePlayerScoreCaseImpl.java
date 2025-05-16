package fan.esports.championship.Esports.Championship.core.usecases.scores.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

public class CreatePlayerScoreCaseImpl implements CreatePlayerScoreCase {

    private final ScoreGateway scoreGateway;

    public CreatePlayerScoreCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public PlayerScore execute(PlayerScore playerScore) {

        return scoreGateway.createPlayerScore(playerScore);

    }
}
