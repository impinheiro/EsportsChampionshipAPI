package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.RegistrationGateway;
import fan.esports.championship.Esports.Championship.core.usecases.registrations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfigurationRegistration {

    @Bean
    public CreateRegistrationCase createRegistrationCase(RegistrationGateway registrationGateway){
        return new CreateRegistrationCaseImpl(registrationGateway);
    }
    @Bean
    public UpdateRegistrationCase updateRegistrationCase(RegistrationGateway registrationGateway){
        return new UpdateRegistrationCaseImpl(registrationGateway);
    }
    @Bean
    public GetRegistrationByIdCase getRegistrationByIdCase(RegistrationGateway registrationGateway){
        return new GetRegistrationByIdCaseImpl(registrationGateway);
    }
}
