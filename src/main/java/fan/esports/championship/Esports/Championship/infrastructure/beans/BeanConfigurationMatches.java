package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.core.usecases.matches.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationMatches {

    @Bean
    public CreateMatchCase createMatchCase(MatchGateway matchGateway) {
        return new CreateMatchCaseImpl(matchGateway);
    }
    @Bean
    public UpdateMatchCase updateMatchCase(MatchGateway matchGateway) {
        return new UpdateMatchCaseImpl(matchGateway);
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
}
