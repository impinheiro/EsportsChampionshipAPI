package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.ChampionshipGateway;
import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.core.usecases.players.TrackChampionshipsCase;
import fan.esports.championship.Esports.Championship.core.usecases.players.TrackChampionshipsCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationPlayer {

    @Bean
    public TrackChampionshipsCase trackChampionshipsCase(UserGateway userGateway, ChampionshipGateway championshipGateway, RegistrationGateway registrationGateway) {
        return new TrackChampionshipsCaseImpl(userGateway, championshipGateway, registrationGateway);
    }


}
