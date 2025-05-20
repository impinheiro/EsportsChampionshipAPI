package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;
import fan.esports.championship.Esports.Championship.core.usecases.matches.*;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.RankingUpdateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationMatches {

    @Bean
    public CreateMatchCase createMatchCase(MatchGateway matchGateway) {
        return new CreateMatchCaseImpl(matchGateway);
    }

    @Bean
    public UpdateMatchCase updateMatchCase(MatchGateway matchGateway, ChampionshipGateway championshipGateway, RankingGateway rankingGateway) {
        return new UpdateMatchCaseImpl(matchGateway, championshipGateway, rankingGateway);
    }

    @Bean
    public DeleteMatchCase deleteMatchCase(MatchGateway matchGateway) {
        return new DeleteMatchCaseImpl(matchGateway);
    }

    @Bean
    public FindAllMatchesCase findAllMatchesCase(MatchGateway matchGateway) {
        return new FindAllMatchesCaseImpl(matchGateway);
    }

    @Bean
    public FindMatchByIdCase findMatchByIdCase(MatchGateway matchGateway) {
        return new FindMatchByIdCaseImpl(matchGateway);
    }

    @Bean
    public SetMatchChampionshipIdCase setMatchChampionshipIdCase(MatchGateway matchGateway) {
        return new SetMatchChampionshipIdCaseImpl(matchGateway);
    }

}
