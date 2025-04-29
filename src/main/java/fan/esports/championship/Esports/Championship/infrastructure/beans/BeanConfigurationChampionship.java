package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.MatchGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
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

    @Bean
    public SubscribeMatchCase subscribeMatchCase(ChampionshipGateway championshipGateway, MatchGateway matchGateway) {
        return new SubscribeMatchCaseImpl(championshipGateway, matchGateway);
    }

    @Bean
    public SubscribeRegistrationCase subscribeRegistrationCase(ChampionshipGateway championshipGateway, RegistrationGateway registrationGateway) {
        return new SubscribeRegistrationCaseImpl(championshipGateway, registrationGateway);
    }

    @Bean
    public FindAvailableChampionshipsCase findAvailableChampionshipsCase(ChampionshipGateway championshipGateway) {
        return new FindAvailableChampionshipsCaseImpl(championshipGateway);
    }

    @Bean
    public FindExpiredChampionshipsCase findExpiredChampionshipsCase(ChampionshipGateway championshipGateway) {
        return new FindExpiredChampionshipsCaseImpl(championshipGateway);
    }

    @Bean
    public FindByGameNameCase findByGameNameCase(ChampionshipGateway championshipGateway) {
        return new FindByGameNameCaseImpl(championshipGateway);
    }
    @Bean
    public FindByChampionshipFormatCase findByChampionshipFormatCase(ChampionshipGateway championshipGateway) {
        return new FindByChampionshipFormatCaseImpl(championshipGateway);
    }

    @Bean
    public FindByChampionshipTypeCase findByChampionshipTypeCase(ChampionshipGateway championshipGateway) {
        return new FindByChampionshipTypeCaseImpl(championshipGateway);
    }

}
