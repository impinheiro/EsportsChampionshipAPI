package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.ScoreGateway;
import fan.esports.championship.Esports.Championship.core.usecases.scores.player.*;
import fan.esports.championship.Esports.Championship.core.usecases.scores.team.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationScore {

    @Bean
    public CreatePlayerScoreCase createPlayerScoreCase(ScoreGateway scoreGateway) {
        return new CreatePlayerScoreCaseImpl(scoreGateway);
    }

    @Bean
    public FindPlayerScoreByIdCase findPlayerScoreByIdCase(ScoreGateway scoreGateway) {
        return new FindPlayerScoreByIdCaseImpl(scoreGateway);
    }

    @Bean
    public FindPlayerScoresCase findPlayerScoresCase(ScoreGateway scoreGateway) {
        return new FindPlayerScoresCaseImpl(scoreGateway);
    }

    @Bean
    public UpdatePlayerScoreCase updatePlayerScoreCase(ScoreGateway scoreGateway) {
        return new UpdatePlayerScoreCaseImpl(scoreGateway);
    }

    @Bean
    public DeletePlayerScoreCase deletePlayerScoreCase(ScoreGateway scoreGateway) {
        return new DeletePlayerScoreCaseImpl(scoreGateway);
    }

    @Bean
    public CreateTeamScoreCase createTeamScoreCase(ScoreGateway scoreGateway) {
        return new CreateTeamScoreCaseImpl(scoreGateway);
    }

    @Bean
    public FindTeamScoreByIdCase findTeamScoreByIdCase(ScoreGateway scoreGateway) {
        return new FindTeamScoreByIdCaseImpl(scoreGateway);
    }

    @Bean
    public FindTeamScoresCase findTeamScoresCase(ScoreGateway scoreGateway) {
        return new FindTeamScoresCaseImpl(scoreGateway);
    }

    @Bean
    public UpdateTeamScoreCase updateTeamScoreCase(ScoreGateway scoreGateway) {
        return new UpdateTeamScoreCaseImpl(scoreGateway);
    }

    @Bean
    public DeleteTeamScoreCase deleteTeamScoreCase(ScoreGateway scoreGateway) {
        return new DeleteTeamScoreCaseImpl(scoreGateway);
    }
}
