package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.usecases.championship.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationChampionship {

    @Bean
    public CreateChampionshipCase createChampionshipCase(ChampionshipGateway championshipGateway) {
        return new CreateChampionshipCaseImpl(championshipGateway);
    }

    @Bean
    public UpdateChampionshipCase updateChampionshipCase(ChampionshipGateway championshipGateway) {
        return new UpdateChampionshipCaseImpl(championshipGateway);
    }

    @Bean
    public DeleteChampionshipCase deleteChampionshipCase(ChampionshipGateway championshipGateway) {
        return new DeleteChampionshipCaseImpl(championshipGateway);
    }

    @Bean
    public FindChampionshipByIdCase findChampionshipByIdCase(ChampionshipGateway championshipGateway) {
        return new FindChampionshipByIdCaseImpl(championshipGateway);
    }

    @Bean
    public FindAllChampionshipsCase findAllChampionshipsCase(ChampionshipGateway championshipGateway) {
        return new FindAllChampionshipsCaseImpl(championshipGateway);
    }
}
