package fan.esports.championship.Esports.Championship.core.usecases.scores.team;


import fan.esports.championship.Esports.Championship.core.domain.TeamScore;
import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;

public class CreateTeamScoreCaseImpl implements CreateTeamScoreCase {
    private final ScoreGateway scoreGateway;

    public CreateTeamScoreCaseImpl(ScoreGateway scoreGateway) {
        this.scoreGateway = scoreGateway;
    }

    @Override
    public TeamScore execute(TeamScore score) {
        return scoreGateway.createTeamScore(score);
    }
}
