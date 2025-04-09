package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.core.usecases.championship.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationChampionship {

    @Bean
    public CreateChampionshipCase createChampionshipCase(ChampionshipGateway championshipGateway, UserGateway userGateway) {
        return new CreateChampionshipCaseImpl(championshipGateway,userGateway);
    }

    @Bean
    public UpdateChampionshipCase updateChampionshipCase(ChampionshipGateway championshipGateway, UserGateway userGateway) {
        return new UpdateChampionshipCaseImpl(championshipGateway, userGateway);
    }

    @Bean
    public DeleteChampionshipCase deleteChampionshipCase(ChampionshipGateway championshipGateway, UserGateway userGateway) {
        return new DeleteChampionshipCaseImpl(championshipGateway, userGateway);
    }

    @Bean
    public FindChampionshipByIdCase findChampionshipByIdCase(ChampionshipGateway championshipGateway, UserGateway userGateway) {
        return new FindChampionshipByIdCaseImpl(championshipGateway, userGateway);
    }

    @Bean
    public FindAllChampionshipsCase findAllChampionshipsCase(ChampionshipGateway championshipGateway) {
        return new FindAllChampionshipsCaseImpl(championshipGateway);
    }
}
