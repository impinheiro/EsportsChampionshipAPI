package fan.esports.championship.Esports.Championship.core.usecases.scores.player;

import fan.esports.championship.Esports.Championship.core.domain.PlayerScore;
import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

import java.util.List;

public class FindPlayerScoresCaseImpl implements FindPlayerScoresCase {

    private final ScoreGateway scoreGateway;

    public FindPlayerScoresCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public List<PlayerScore> execute() {
        return scoreGateway.findAllPlayerScores();
    }

}
