package fan.esports.championship.Esports.Championship.core.usecases.scores.team;

import fan.esports.championship.Esports.Championship.core.domain.TeamScore;
import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

import java.util.List;

public class FindTeamScoresCaseImpl implements FindTeamScoresCase {

    private final ScoreGateway scoreGateway;

    public FindTeamScoresCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public List<TeamScore> execute() {
        return scoreGateway.findAllTeamScores();
    }
}
