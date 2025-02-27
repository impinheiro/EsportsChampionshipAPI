package fan.esports.championship.Esports.Championship.infrastructure.beans;

import fan.esports.championship.Esports.Championship.core.gateway.UserGateway;
import fan.esports.championship.Esports.Championship.core.usecases.user.*;
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
    @Bean
    public DeleteUserCase deleteUser(UserGateway userGateway){
        return new DeleteUserCaseImpl(userGateway);
    }
    @Bean
    public FindUserByIdCase findUserById(UserGateway userGateway){
        return new FindUserByIdCaseImpl(userGateway);
    }
}
