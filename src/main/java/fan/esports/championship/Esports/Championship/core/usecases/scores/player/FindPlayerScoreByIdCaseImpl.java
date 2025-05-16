package fan.esports.championship.Esports.Championship.core.usecases.scores.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

public class FindPlayerScoreByIdCaseImpl implements FindPlayerScoreByIdCase {

    private final ScoreGateway scoreGateway;

    public FindPlayerScoreByIdCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public PlayerScore execute(String id) {
        return scoreGateway.findPlayerScoreById(id).orElse(null);
    }
}
