package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.RankingGateway;
import fan.esports.championship.Esports.Championship.core.usecases.rankings.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationRanking {

    @Bean
    public CreateRankingCase createRankingCase(RankingGateway rankingGateway) {
        return new CreateRankingCaseImpl(rankingGateway);
    }

    @Bean
    public FindRankingByIdCase findRankingByIdCase(RankingGateway rankingGateway) {
        return new FindRankingByIdCaseImpl(rankingGateway);
    }

    @Bean
    public FindAllRankingsCase findAllRankingsCase(RankingGateway rankingGateway) {
        return new FindAllRankingsCaseImpl(rankingGateway);
    }

    @Bean
    public UpdateRankingCase updateRankingCase(RankingGateway rankingGateway) {
        return new UpdateRankingCaseImpl(rankingGateway);
    }

    @Bean
    public DeleteRankingCase deleteRankingCase(RankingGateway rankingGateway) {
        return new DeleteRankingCaseImpl(rankingGateway);
    }

}
