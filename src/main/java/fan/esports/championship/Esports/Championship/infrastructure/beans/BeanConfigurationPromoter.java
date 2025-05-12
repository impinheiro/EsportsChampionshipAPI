package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.core.usecases.promoters.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationPromoter {

    @Bean
    public FindPendingRegistrationsCase findPendingRegistrationsCase(ChampionshipGateway championshipGateway, UserGateway userGateway, RegistrationGateway registrationGateway){
        return new FindPendingRegistrationsCaseImpl(championshipGateway, userGateway, registrationGateway);
    }

    @Bean
    public FindProprietaryChampionshipsCase findProprietaryChampionshipsCase(ChampionshipGateway championshipGateway, UserGateway userGateway){
        return new FindProprietaryChampionshipsCaseImpl(championshipGateway, userGateway);
    }

    @Bean
    public FindPendingTeamRegistrationsCase findPendingTeamRegistrationsCase(ChampionshipGateway championshipGateway, UserGateway userGateway, RegistrationGateway registrationGateway){
        return new FindPendingTeamRegistrationsCaseImpl(championshipGateway, userGateway, registrationGateway);
    }
}
