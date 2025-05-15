package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.player.*;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.team.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationRanking {

    @Bean
    public CreatePlayerRankingCase createPlayerRankingCase(RankingGateway rankingGateway) {
        return new CreatePlayerRankingCaseImpl(rankingGateway);
    }

    @Bean
    public FindPlayerRankingByIdCase findPlayerRankingByIdCase(RankingGateway rankingGateway) {
        return new FindPlayerRankingByIdCaseImpl(rankingGateway);
    }

    @Bean
    public FindPlayerRankingsCase findPlayerRankingsCase(RankingGateway rankingGateway) {
        return new FindPlayerRankingsCaseImpl(rankingGateway);
    }

    @Bean
    public UpdatePlayerRankingCase updatePlayerRankingCase(RankingGateway rankingGateway) {
        return new UpdatePlayerRankingCaseImpl(rankingGateway);
    }

    @Bean
    public DeletePlayerRankingCase deletePlayerRankingCase(RankingGateway rankingGateway) {
        return new DeletePlayerRankingCaseImpl(rankingGateway);
    }

    @Bean
    public CreateTeamRankingCase createTeamRankingCase(RankingGateway rankingGateway) {
        return new CreateTeamRankingCaseImpl(rankingGateway);
    }

    @Bean
    public FindTeamRankingByIdCase findTeamRankingByIdCase(RankingGateway rankingGateway) {
        return new FindTeamRankingByIdCaseImpl(rankingGateway);
    }

    @Bean
    public FindAllTeamRankingsCase findAllTeamRankingsCase(RankingGateway rankingGateway) {
        return new FindAllTeamRankingsCaseImpl(rankingGateway);
    }

    @Bean
    public UpdateTeamRankingCase updateTeamRankingCase(RankingGateway rankingGateway) {
        return new UpdateTeamRankingCaseImpl(rankingGateway);
    }

    @Bean
    public DeleteTeamRankingCase deleteTeamRankingCase(RankingGateway rankingGateway) {
        return new DeleteTeamRankingCaseImpl(rankingGateway);
    }

}
