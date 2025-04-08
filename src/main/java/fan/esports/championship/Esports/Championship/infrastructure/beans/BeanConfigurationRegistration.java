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

    @Bean
    public DeleteRegistrationCase deleteRegistrationCase(RegistrationGateway registrationGateway){
        return new DeleteRegistrationCaseImpl(registrationGateway);
    }

    @Bean
    public CreateTeamRegistrationCase createTeamRegistrationCase(RegistrationGateway registrationGateway){
        return new CreateTeamRegistrationCaseImpl(registrationGateway);
    }

    @Bean
    public UpdateTeamRegistrationCase updateTeamRegistrationCase(RegistrationGateway registrationGateway){
        return new UpdateTeamRegistrationCaseImpl(registrationGateway);
    }

    @Bean
    public DeleteTeamRegistrationCase deleteTeamRegistrationCase(RegistrationGateway registrationGateway){
        return new DeleteTeamRegistrationCaseImpl(registrationGateway);
    }

    @Bean
    FindTeamRegistrationByIdCase findTeamRegistrationByIdCase(RegistrationGateway registrationGateway){
        return new FindTeamRegistrationByIdCaseImpl(registrationGateway);
    }
}
