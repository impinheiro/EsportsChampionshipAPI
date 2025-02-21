package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.core.usecases.user.CreateUserCase;
import fan.esports.championship.Esports.Championship.core.usecases.user.CreateUserCaseImpl;
import fan.esports.championship.Esports.Championship.core.usecases.user.GetUsersCase;
import fan.esports.championship.Esports.Championship.core.usecases.user.GetUsersCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfigurationUser {

    @Bean
    public CreateUserCase createUser(UserGateway userGateway){
        return new CreateUserCaseImpl(userGateway);
    }
    @Bean
    public GetUsersCase getUsers(UserGateway userGateway){
        return new GetUsersCaseImpl(userGateway);
    }
}
