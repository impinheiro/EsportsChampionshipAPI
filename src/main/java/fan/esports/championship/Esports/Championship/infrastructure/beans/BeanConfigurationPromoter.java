package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.PromoterGateway;
import fan.esports.championship.Esports.Championship.core.usecases.promoters.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationPromoter {

    @Bean
    public FindPendingRegistrationsCase findPendingRegistrationsCase(PromoterGateway gateway) {
        return new FindPendingRegistrationsCaseImpl(gateway);
    }

    @Bean
    public FindProprietaryChampionshipsCase findProprietaryChampionshipsCase(PromoterGateway gateway) {
        return new FindProprietaryChampionshipsCaseImpl(gateway);
    }

    @Bean
    public FindPendingTeamRegistrationsCase findPendingTeamRegistrationsCase(PromoterGateway gateway) {
        return new FindPendingTeamRegistrationsCaseImpl(gateway);
    }

    @Bean
    public ChangeRegistrationsStatusCaseImpl changeRegistrationsStatusCase(PromoterGateway gateway) {
        return new ChangeRegistrationsStatusCaseImpl(gateway);
    }
}
